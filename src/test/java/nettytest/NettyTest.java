package nettytest;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/context.xml"})
public class NettyTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CamelContext camelContext;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void testRaw() {
        Exchange exchange = new DefaultExchange(camelContext, ExchangePattern.InOut);
        Utils.setBody(exchange.getIn(), "<a><b><c>text</c></b></a>");
        exchange = producerTemplate.send(Utils.URI, exchange);
        Utils.print(exchange.getOut());
    }

}
