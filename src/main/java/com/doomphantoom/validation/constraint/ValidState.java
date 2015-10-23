package com.doomphantoom.validation.constraint;

import com.doomphantoom.validation.validator.StateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by doomphantom on 23/10/2015.
 */
@Constraint(validatedBy = {StateValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidState {
    String message() default "The state is required for the selected country";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String country() default "";

    String state() default "";
}
