package ch.util;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

   <O> Boolean isValid(O object);

   <O> Set<ConstraintViolation<O>> violations (O object);
}
