package com.cam.camelmicroservicesb.routes.annotations;

import java.lang.annotation.Documented;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = EnumNamePatternValidator.class)
public @interface EnumNamePattern {
	String regexp();

	String message() default "must match \"{regexp}\"";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
