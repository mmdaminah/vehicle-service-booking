package ir.mmdaminah.customerservice.core.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class CreateCustomerDto {

    @NotNull
    @Length(min = 2, max = 100)
    private String firstName;

    @NotNull
    @Length(min = 2, max = 100)
    private String lastName;

}
