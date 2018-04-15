package nl.manoharanrajesh.spring.cloud.contract.consumer;


import nl.manoharanrajesh.spring.cloud.contract.producer.Customer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/")
    public String index(@RequestParam(value = "id", required = false) String id) {
        try {
            return html("Consumer application", id == null ? "" : "Your customercustomer data: " + getOrderDetails(id));
        } catch (Exception e) {
            return html("Oops, something went wrong!", "Error: " + e.getMessage());
        }
    }

    private String getOrderDetails(String id) {
        ResponseEntity<Customer> response = restTemplate.getForEntity("/orders/{id}", Customer.class, id);
        return response.hasBody() && response.getStatusCode().is2xxSuccessful() ? response.getBody().toString() : "Unexpected HTTP response, status code: " + response.getStatusCode() + " (" + response.getStatusCode().getReasonPhrase() + ")";
    }

    private String html(String header, String body) {
        return "<html><body><h1>" + header + "</h1><p>" + body + "</p>" +
                "<ul>" +
                "<li><a href='?id=1'>Test happy flow</a></li>" +
                "<li><a href='?id=404'>Test with id=404 (not found)</a></li>" +
                "<li><a href='?id=500'>Test with id=500 (error)</a></li>" +
                "</ul>" +
                "</body></html>";
    }
}