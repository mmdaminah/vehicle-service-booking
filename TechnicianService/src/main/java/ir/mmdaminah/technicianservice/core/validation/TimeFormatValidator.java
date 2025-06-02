package ir.mmdaminah.technicianservice.core.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TimeFormatValidator implements ConstraintValidator<ValidTimeFormat, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) return false;
        if(!value.matches("^\\d{2}:\\d{2}-\\d{2}:\\d{2}$")) return false;

        String[] parts = value.split("-");
        return isValidTime(parts[0]) && isValidTime(parts[1]);
    }

    private boolean isValidTime(String time){
        String[] hm = time.split(":");
        int hours = Integer.parseInt(hm[0]);
        int minutes = Integer.parseInt(hm[1]);
        return hours >=0 && hours <=23 && minutes >=0 && minutes <=59;
    }
}
