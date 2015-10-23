package com.doomphantoom.validation.validator;

import com.doomphantoom.dto.User;
import com.doomphantoom.exception.AnnotationInvalidException;
import com.doomphantoom.util.DataSourceHelper;
import com.doomphantoom.validation.constraint.ValidState;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by doomphantom on 23/10/2015.
 */
public class StateValidator implements ConstraintValidator<ValidState, Object> {

    private String countryFieldName;
    private String stateFieldName;

    public void initialize(ValidState constraintAnnotation) {
        countryFieldName = constraintAnnotation.country();
        stateFieldName = constraintAnnotation.state();
    }

    public boolean isValid(Object target, ConstraintValidatorContext context) {
        if (StringUtils.isNoneBlank(countryFieldName, stateFieldName)) {
            try {
                String country = BeanUtils.getProperty(target, countryFieldName);
                String state = BeanUtils.getProperty(target, stateFieldName);
                return isCheckStateValid(country, state);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                throw new AnnotationInvalidException(e.getMessage());
            }
        } else if (StringUtils.isBlank(countryFieldName) && StringUtils.isBlank(stateFieldName)) {
            if (target instanceof User) {
                User user = (User) target;
                return isCheckStateValid(user.getCountry(), user.getState());
            }
            return true;
        } else {
            throw new AnnotationInvalidException("'country' and 'state' must be same blank or not blank");
        }
    }

    public boolean isCheckStateValid(String country, String state) {
        if (DataSourceHelper.getListCountryThatRequireState().contains(country)) {
            return StringUtils.isNotBlank(state);
        }
        return true;
    }
}