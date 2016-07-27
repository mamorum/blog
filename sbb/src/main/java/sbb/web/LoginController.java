package sbb.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
public class LoginController extends WebMvcAutoConfigurationAdapter {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpServletRequest req) {
		Principal authenticated = req.getUserPrincipal();
		return authenticated == null ? "login" : "redirect:/customer";
	}

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/").setViewName("redirect:/customer");
    }
}
