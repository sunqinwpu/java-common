package org.dolphin.study.java.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by qi.sun on 16/8/16.
 */
public class HelloServerHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LogManager.getLogger(HelloServerHandler.class);

    @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf byteBuf = (ByteBuf) msg;
            logger.info("discard message, " + byteBuf);
            StringBuilder builder = new StringBuilder();
            while (byteBuf.isReadable()) {
                builder.append((char) byteBuf.readByte());
            }
            logger.info("read message, " + byteBuf);
            ctx.write("hello world, echo  :");
            ctx.write(msg);
        } catch (Throwable e) {
            logger.info("read exception", e);
        } finally {
            ReferenceCountUtil.release(msg);
        }
        super.channelRead(ctx, msg);
    }

    @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("error", cause);
        super.exceptionCaught(ctx, cause);
    }
}
