package sbb.web;

import static sbb.config.security.LoginUser.*;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.MessageSource;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import sbb.exception.ConflictException;
import sbb.exception.RequestParameterException;
import sbb.model.Customer;
import sbb.repository.CustomerRepository;


@RestController @RequestMapping("/customers")
public class CustomerRestController extends WebMvcAutoConfigurationAdapter {

	@Autowired CustomerRepository customers;
    @Autowired HttpSession session;
    @Autowired MessageSource msg;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/customer").setViewName("/customer");
    }

    @RequestMapping(method=RequestMethod.POST)
    public Map<String, Customer> add(@Valid Customer customer, BindingResult br) {
    	RequestParameterException.assertValid(br);
    	customer.setUserId(userId());
        return Collections.singletonMap("content",  customers.save(customer));
    }

    // TODO 引数をformにしても良いかも。
    @RequestMapping(method=RequestMethod.GET)
    public Page<Customer> search(
            @RequestParam(value="lastName", defaultValue="") String lastName,
            @RequestParam(value="page", defaultValue="1") int page) {

        PageRequest pageable = new PageRequest((page - 1), 10);

        if (StringUtils.isEmpty(lastName)) {
            return customers.findByUserIdOrderByIdDesc(userId(), pageable);
        }
        return customers.findByUserIdAndLastNameStartsWithOrderByIdDesc(userId(), lastName, pageable);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Customer edit(@PathVariable long id) {
        // for optimistic locking.
        Customer target = customers.findOneByIdAndUserId(id,  userId()).orElse(null);
        // bellow, causes javac error because of java's bug. not affects eclipse.
        // .findOneByIdAndUserId(id,  userId()).orElseThrow(() -> {
        //		throw new RequestParameterException(DELETED_MSG);
        // });
        if (target == null) {
        	throw new RequestParameterException(
        			msg.getMessage("customer.deleted", null, Locale.JAPAN)
        	);
        }
        session.setAttribute("update", target);
        return target;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public Map<String, Customer> update(@Valid Customer param, BindingResult br) {

    	RequestParameterException.assertValid(br);
        Customer customer = (Customer) session.getAttribute("update");
        param.copyTo(customer);

        try {
            return Collections.singletonMap("content", customers.save(customer));
        } catch (OptimisticLockingFailureException e) {
            throw new ConflictException(
            		msg.getMessage("customer.conflict", null, Locale.JAPAN)
            );
        } finally {
            session.removeAttribute("update");
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public Map<String, Long> delete(@PathVariable long id) {
    	customers.findOneByIdAndUserId(id, userId()).ifPresent(c -> {
    		customers.delete(c);
    	});
    	return Collections.singletonMap("id", id);
    }

}
