package com.cam.camelmicroservicesb.routes.annotations;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerTypeSubSetValidator implements ConstraintValidator<CustomerTypeSubset, Status> {
	private Status[] subset;

	@Override
	public boolean isValid(Status value, ConstraintValidatorContext context) {
		return value == null || Arrays.asList(subset).contains(value);
	}

}
