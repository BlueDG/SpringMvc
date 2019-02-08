package fr.dta.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	public void initialize(Password constraintAnnotation) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !StringUtils.isEmpty(value) && value.length() >= 6;
	}

}
