package sbb.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestParameterException extends RuntimeException {

	public RequestParameterException(String msg) {
		super(msg);
	}

	public static void assertValid(BindingResult br) {
		if (br.hasErrors()) {
			throwWith(br.getAllErrors());
		}
	}

	private static void throwWith(List<ObjectError> errors) {
		StringBuilder msg = new StringBuilder();
		errors.forEach(error -> {
			msg.append(error.getDefaultMessage());
		});
		throw new RequestParameterException(msg.toString());
	}
}
