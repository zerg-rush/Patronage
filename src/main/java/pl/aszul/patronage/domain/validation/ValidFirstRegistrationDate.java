package pl.aszul.patronage.domain.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidFirstRegistrationDateValidator.class })
@Documented

public @interface ValidFirstRegistrationDate {
    String message() default "Registration card can not be issued before car was manufactured!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
