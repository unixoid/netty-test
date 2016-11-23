package nettytest;

import org.apache.camel.builder.RouteBuilder;

public class NettyTestRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(Utils.URI)
                .process(exchange -> {
                    Utils.print(exchange.getIn());
                    Utils.setBody(exchange.getOut(), "<element attribute=\"value\"></element>");
                });
    }

}
