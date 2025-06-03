package ir.mmdaminah.vehicleservice.query.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindCustomerVehiclesQuery {
    private String customerId;
}
