package chapter01;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.time.Duration;

public class FileCopierWithCamel {

    public static void main(String[] args) throws Exception {
        DefaultCamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:data/inbox?noop=true").to("file:data/outbox");
            }
        });
        context.start();
        Thread.sleep(Duration.ofSeconds(10));
        context.stop();
    }
}
