package nettytest;

import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.xml.XmlFrameDecoder;
import org.apache.camel.component.netty4.DefaultChannelHandlerFactory;

public class XmlDecoderFactory extends DefaultChannelHandlerFactory {

    @Override
    public ChannelHandler newChannelHandler() {
        return new XmlFrameDecoder(8 * 1024);
    }
}
