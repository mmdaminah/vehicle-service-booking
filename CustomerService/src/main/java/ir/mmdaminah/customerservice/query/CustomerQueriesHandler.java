package ir.mmdaminah.customerservice.query;

import ir.mmdaminah.customerservice.core.dto.CustomerDto;
import ir.mmdaminah.customerservice.core.repository.CustomerRepository;
import ir.mmdaminah.customerservice.query.queries.FindCustomerQuery;
import ir.mmdaminah.customerservice.query.queries.FindCustomersQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CustomerQueriesHandler {

    private final CustomerRepository customerRepository;

    public CustomerQueriesHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @QueryHandler
    public List<CustomerDto> getCustomers(FindCustomersQuery query) {

        return customerRepository.findAll().stream().map(customer -> {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            return customerDto;
        }).collect(Collectors.toList());

    }

    @QueryHandler
    public CustomerDto getCustomer(FindCustomerQuery query) {
        var customer = customerRepository.findById(query.getCustomerId());
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

}
