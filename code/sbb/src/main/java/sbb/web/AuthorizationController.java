package sbb.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/auth")
public class AuthorizationController {

	@RequestMapping(value="/nav", method=RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE)
	public Resource nav(HttpServletRequest req) {
		boolean isAdmin = req.isUserInRole("ROLE_ADMIN");
		return isAdmin ? new ClassPathResource("/templates/admin/nav.ftl") : null;
	}
}
