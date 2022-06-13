package MySpring.MySpring.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CompensationValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Compensation.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Compensation compensation = (Compensation)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type_com", "required.type_com",
				"Type is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "required.amount",
				"Amount is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description_com", "required.description_com",
				"Description is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date_com", "required.date_com",
				"Date is required");

	}

}
