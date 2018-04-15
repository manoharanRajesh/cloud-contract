package nl.manoharanrajesh.spring.cloud.contract.producer.customer;

import nl.manoharanrajesh.spring.cloud.contract.producer.Customer;
import nl.manoharanrajesh.spring.cloud.contract.producer.CustomerController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Unit test which tests the different scenarios in the OrderController.
 * <p>
 * In the unit test we leave the environment configuration out of scope (Spring).
 * <p>
 * We focus on testing the component: OrderController
 */
public class CustomerControllerTest {

    private CustomerController customerController;

    @Before
    public void setup() {
        customerController = new CustomerController();
    }

    @Test
    public void assertOk() {
        ResponseEntity<Customer> response200 = customerController.getCustomerById("1");
        Assert.assertEquals(200, response200.getStatusCodeValue());
        Assert.assertEquals("1", response200.getBody().getId());
    }

    @Test
    public void assertNotFound() {
        ResponseEntity<Customer> response404 = customerController.getCustomerById("404");
        Assert.assertEquals(404, response404.getStatusCodeValue());
    }

    @Test
    public void assertError() {
        ResponseEntity<Customer> response500 = customerController.getCustomerById("500");
        Assert.assertEquals(500, response500.getStatusCodeValue());
    }
}