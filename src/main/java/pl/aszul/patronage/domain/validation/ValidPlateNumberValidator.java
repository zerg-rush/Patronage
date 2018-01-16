package pl.aszul.patronage.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.aszul.patronage.domain.Vehicle;

public class ValidPlateNumberValidator implements ConstraintValidator<ValidPlateNumber, Vehicle> {

    @Override
    public void initialize(ValidPlateNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(Vehicle vehicle, ConstraintValidatorContext context) {
        if ( vehicle == null ) {
            return true;
        }
        return !vehicle.getPlateNumber().substring(0,1).equals(vehicle.getPlateNumber().substring(1,2));
    }
}
