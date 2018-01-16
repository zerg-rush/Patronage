package pl.aszul.patronage.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.aszul.patronage.domain.Vehicle;

public class ValidRegistrationCardIssueDateValidator
        implements ConstraintValidator<ValidRegistrationCardIssueDate, Vehicle> {

    @Override
    public void initialize(ValidRegistrationCardIssueDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(Vehicle vehicle, ConstraintValidatorContext context) {
        if ( vehicle == null ) {
            return true;
        }
        return vehicle.getRegistrationCardIssueDate().isAfter(vehicle.getFirstRegistrationDate()) ||
                vehicle.getRegistrationCardIssueDate().isEqual(vehicle.getFirstRegistrationDate());
    }
}
