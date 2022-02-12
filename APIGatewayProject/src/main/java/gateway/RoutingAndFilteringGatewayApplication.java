package gateway;

import filters.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class RoutingAndFilteringGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoutingAndFilteringGatewayApplication.class, args);
    }

    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }
}

/**
 * http://localhost:8080/student/get-students/internal to access a non-exposed API in Student service
 */