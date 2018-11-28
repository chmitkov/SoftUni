package ch.util;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationUtilImpl implements ValidationUtil {

    private Validator validator;

    public ValidationUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory()
                .getValidator();
    }

    @Override
    public <O> Boolean isValid(O object) {
        return this.validator.validate(object).size() == 0;
    }

    @Override
    public <O> Set<ConstraintViolation<O>> violations(O object) {
        return this.validator.validate(object);
    }
}
