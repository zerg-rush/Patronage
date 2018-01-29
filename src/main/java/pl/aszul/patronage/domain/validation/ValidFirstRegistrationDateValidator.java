package pl.aszul.patronage.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import pl.aszul.patronage.domain.Vehicle;
import java.time.LocalDate;

public class ValidFirstRegistrationDateValidator
        implements ConstraintValidator<ValidFirstRegistrationDate, Vehicle> {

    @Override
    public void initialize(ValidFirstRegistrationDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(Vehicle vehicle, ConstraintValidatorContext context) {
        if ( vehicle == null ) {
            return true;
        }
        return (vehicle.getFirstRegistrationDate().isAfter(LocalDate.parse("1900-01-01")) ||
                        vehicle.getFirstRegistrationDate().isEqual(LocalDate.parse("1900-01-01"))) &&
                        (vehicle.getFirstRegistrationDate().isBefore(LocalDate.now()) ||
                                vehicle.getFirstRegistrationDate().isEqual(LocalDate.now()));
    }
}