package nl.manoharanrajesh.spring.cloud.contract.producer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @GetMapping(path = "/customer/{id}", produces = "application/json")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
        switch (id) {
            case "500": return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            case "404": return ResponseEntity.notFound().build();
            default: return ResponseEntity.ok(find(id).orElse(createCustomer(id)));
        }
    }

    @GetMapping(path = "/customers", produces = "application/json")
    public ResponseEntity<List> customers() {
        return ResponseEntity.ok(getCustomers());
    }

    private Optional<Customer> find(String id){
        List<Customer> customers = getCustomers();
        return customers.stream().filter(c-> c.getId().equals(id)).findFirst();
    }

    private List<Customer> getCustomers() {
        List<Customer>  customers = new ArrayList<>();
        customers.add(new Customer("1","Iron man",new BigDecimal(100000)));
        customers.add(new Customer("2","Hulk",new BigDecimal(200000)));
        customers.add(new Customer("3","Thor",new BigDecimal(300000)));
        customers.add(new Customer("4","Black panther",new BigDecimal(400000)));
        customers.add(new Customer("5","Caption America",new BigDecimal(500000)));
        customers.add(new Customer("6","Vision",new BigDecimal(600000)));
        return customers;
    }

    private Customer createCustomer(String id) {
        return new Customer(id,"Iron man",new BigDecimal(100000));
    }
}