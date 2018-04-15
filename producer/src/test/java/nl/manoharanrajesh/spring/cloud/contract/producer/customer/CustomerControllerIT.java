package nl.manoharanrajesh.spring.cloud.contract.producer.customer;

import nl.manoharanrajesh.spring.cloud.contract.producer.Customer;
import nl.manoharanrajesh.spring.cloud.contract.producer.CustomerController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * In the integration test if our component works in the runtime environment.
 * <p>
 * We start a Spring application context and test the component inside the context.
 * <p>
 * Note: same test cases as in the CustomerControllerTest. But slower to start/run.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerIT {

    @Autowired
    private CustomerController customerController;

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
