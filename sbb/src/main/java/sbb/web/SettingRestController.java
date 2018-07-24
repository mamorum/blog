package sbb.web;

import static sbb.config.security.LoginUser.*;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import sbb.exception.RequestParameterException;
import sbb.model.User;
import sbb.model.UserInfo;
import sbb.repository.UserInfoRepository;
import sbb.repository.UserRepository;

@RestController
public class SettingRestController extends WebMvcAutoConfigurationAdapter{

	@Autowired UserInfoRepository infoRepo;
	@Autowired UserRepository userRepo;
	@Autowired MessageSource msg;

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/setting").setViewName("/setting");
    }

	@RequestMapping(value="/userInfo", method=RequestMethod.GET)
	public UserInfo findInfo() {
		return infoRepo.findOneByUserId(userId()).orElse(null);
	}

	@RequestMapping(value="/userInfo", method=RequestMethod.POST)
	public void saveInfo(@Valid UserInfo paramInfo, BindingResult br) {

		RequestParameterException.assertValid(br);

		infoRepo.findOneByUserId(userId()).map(dbInfo -> {
			// update.
			paramInfo.copyTo(dbInfo);
			return infoRepo.save(dbInfo);
		}).orElseGet(() -> {
			// create.
			paramInfo.setUserId(userId());
			return infoRepo.save(paramInfo);
		});
	}

	@RequestMapping(value="/userMail", method=RequestMethod.GET)
	public Map<String, String> findMail() {
		String mail = userRepo.findOne(userId()).getUsername();
		return Collections.singletonMap("mail", mail);
	}

	// TODO URL付きのメールを送る（いつか）。
	// TODO そして、ユーザの所有するメールか確認してから変更する。
	@RequestMapping(value="/userMail", method=RequestMethod.POST)
	public void saveMail(@Valid MailForm form, BindingResult br) {
		RequestParameterException.assertValid(br);
		User user = userRepo.findOne(userId());
		String next = nextMail(user, form);
		assertMailIsUnique(next);
		user.setUsername(next);
		userRepo.save(user);
	}
	@Data public static class MailForm {
		@NotEmpty(message="{mail}{NotEmpty}")
		@Email(message="{mail}{Email}")
		@Size(max=50, message="{mail}{Max}")
		private String mail;
		private String password;
	}
	private String nextMail(User user, MailForm form) {
		if (!StringUtils.equals(user.getPassword(), form.password)) {
			throw new RequestParameterException(
					msg.getMessage("password.invalid", null, Locale.JAPAN)
			);
		}
		return form.mail;
	}
	private void assertMailIsUnique(String nextMail) {
		Long count = userRepo.countByUsername(nextMail);
		if (count != 0) throw new RequestParameterException(
				msg.getMessage("mail.duplicate", null, Locale.JAPAN)
		);
	}

	@RequestMapping(value="/userPass", method=RequestMethod.POST)
	public void savePass(@Valid PasswordForm form, BindingResult br) {
		RequestParameterException.assertValid(br);
		User user = userRepo.findOne(userId());
		String next = nextPassword(user, form);
		user.setPassword(next);
		userRepo.save(user);
	}
	@Data public static class PasswordForm {
		@NotEmpty(message="{nowPass}{NotEmpty}")
		@Size(max=50, message="{nowPass}{Max}")
		private String nowPass;

		@NotEmpty(message="{nextPass}{NotEmpty}")
		@Size(max=50, message="{nextPass}{Max}")
		private String nextPass;

		@NotEmpty(message="{nextPassRe}{NotEmpty}")
		@Size(max=50, message="{nextPassRe}{Max}")
		private String nextPassRe;
	}
	private String nextPassword(User user, PasswordForm form) {
		if (!StringUtils.equals(user.getPassword(), form.nowPass)) {
			throw new RequestParameterException(
					msg.getMessage("password.invalid", null, Locale.JAPAN)
			);
		}
		if (!StringUtils.equals(form.nextPass, form.nextPassRe)) {
			throw new RequestParameterException(
					msg.getMessage("password.unmatch", null, Locale.JAPAN)
			);
		}
		return form.nextPass;
	}

}