package ivan.learn.springboot.controller;

import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class GreetingController
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public ResponseEntity<String> greeting(@RequestParam String name)
	{
		logger.info("Wellcome to springboot logback");
		logger.debug("Wellcome to springboot logback");
		return new ResponseEntity<String>("Hello, " + name + "!", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/password_reset")
	public ResponseEntity<String> forgetPassword(@Email(message = "Email is not valid.") @RequestParam String email)
	{
		return new ResponseEntity<String>("Reset password successfully.", HttpStatus.OK);
	}
}
