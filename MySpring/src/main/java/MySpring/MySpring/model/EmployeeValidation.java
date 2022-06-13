package MySpring.MySpring.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "required.first_name",
				"First name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middle_name", "required.middle_name",
				"Middle name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", "required.last_name",
				"Last name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birth", "required.birth",
				"Birthday is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "required.position",
				"Position is required");
	}

}
