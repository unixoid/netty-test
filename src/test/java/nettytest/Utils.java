package nettytest;

import io.netty.buffer.ByteBuf;
import org.apache.camel.Message;
import org.apache.camel.component.netty4.NettyConverter;

import java.nio.charset.StandardCharsets;

public class Utils {

    public static final String URI = "netty4:tcp://localhost:8081" +
            "?encoder=#encoder" +
            "&decoder=#decoder" +
            "&sync=true" +
            "&lazyChannelCreation=true" +
            "&transferExchange=false";

    public static void print(Message message) {
        ByteBuf buffer = message.getBody(ByteBuf.class);
        byte[] bytes = NettyConverter.toByteArray(buffer, message.getExchange());
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("Received XML document: " + s);
    }

    public static void setBody(Message message, String xml) {
        message.setBody(NettyConverter.toByteBuffer(xml, message.getExchange()));
    }
}
