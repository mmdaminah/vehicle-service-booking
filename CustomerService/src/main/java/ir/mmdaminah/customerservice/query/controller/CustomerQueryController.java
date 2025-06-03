package ir.mmdaminah.customerservice.query.controller;

import ir.mmdaminah.customerservice.core.dto.CustomerDto;

import ir.mmdaminah.customerservice.query.queries.FindCustomersQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerQueryController {


    private final QueryGateway queryGateway;

    public CustomerQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return queryGateway.query(
                new FindCustomersQuery(),
                 ResponseTypes.multipleInstancesOf(CustomerDto.class)
        ).join();
    }

}
