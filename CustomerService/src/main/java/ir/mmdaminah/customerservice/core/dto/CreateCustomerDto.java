package ir.mmdaminah.customerservice.core.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateCustomerDto {

    @NotNull
    @Min(2)
    @Max(100)
    private String firstName;

    @NotNull
    @Min(2)
    @Max(100)
    private String lastName;

}
