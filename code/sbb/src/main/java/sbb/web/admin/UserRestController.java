package sbb.web.admin;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.MessageSource;
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

import sbb.exception.RequestParameterException;
import sbb.model.User;
import sbb.repository.CustomerRepository;
import sbb.repository.UserInfoRepository;
import sbb.repository.UserRepository;

@RestController @RequestMapping("/admin")
public class UserRestController extends WebMvcAutoConfigurationAdapter{

	@Autowired UserRepository users;
	@Autowired UserInfoRepository infos;
	@Autowired CustomerRepository customers;
	@Autowired MessageSource msg;

	@Override public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/admin/user").setViewName("/admin/user");
    }

	@RequestMapping(value="/users", method=RequestMethod.GET)
	public Page<User> search(
			@RequestParam(value="username", defaultValue="") String username,
            @RequestParam(value="page", defaultValue="1") int page) {

        PageRequest pageable = new PageRequest((page - 1), 10);

        if (StringUtils.isEmpty(username)) {
        	return users.findAllByOrderByIdDesc(pageable);
        }
        return users.findByUsernameStartsWithOrderByIdDesc(username, pageable);
	}

	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public User get(@PathVariable long id) {
		return users.findOne(id);
	}

	@RequestMapping(value="/users", method=RequestMethod.POST)
	public Map<String, User> add(@Valid User user, BindingResult br) {
		RequestParameterException.assertValid(br);
		Long count = users.countByUsername(user.getUsername());
		if (count != 0) throw new RequestParameterException(
				msg.getMessage("mail.duplicate", null, Locale.JAPAN)
		);
		return Collections.singletonMap("content", users.save(user));
	}

	@RequestMapping(value="/users/{id}", method=RequestMethod.POST)
	public Map<String, User> update(@PathVariable long id, @Valid User param, BindingResult br) {
		RequestParameterException.assertValid(br);
		User user = users.findOne(id);
		param.copyTo(user);
		return Collections.singletonMap("content", users.save(user));
	}

	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public Map<String, Long> delete(@PathVariable long id) {
		customers.deleteByUserId(id);
		infos.deleteByUserId(id);
		users.delete(id);
		return Collections.singletonMap("id", id);
	}
}
