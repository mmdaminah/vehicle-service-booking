package ir.mmdaminah.servicecenterservice.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceCenterCreatedEvent {
    private String serviceCenterId;
    private String name;
    private String province;
    private String city;
    private String address;
}
