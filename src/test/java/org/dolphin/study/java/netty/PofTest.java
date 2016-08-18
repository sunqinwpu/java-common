package org.dolphin.study.java.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.epoll.EpollDomainSocketChannel;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.DomainSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by qi.sun on 16/8/13.
 */
public class PofTest {

    private static Logger logger = LogManager.getLogger(PofTest.class);

    @Test public void pofTest() {
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(new EpollEventLoopGroup()).channel(EpollDomainSocketChannel.class).handler(
                    new ChannelInitializer<DomainSocketChannel>() {

                        @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
                                throws Exception {
                            logger.error("Error occur when reading from Unix domain socket: %s", cause);
                            ctx.close();
                            super.exceptionCaught(ctx, cause);
                        }

                        @Override protected void initChannel(DomainSocketChannel domainSocketChannel) throws Exception {
                            domainSocketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter() {

                                @Override public void channelRead(ChannelHandlerContext ctx, Object msg)
                                        throws Exception {
                                    super.channelRead(ctx, msg);
                                    final ByteBuf buff = (ByteBuf) msg;
                                    try {
                                        ByteBuf byteBuf = buff.readBytes(buff.readableBytes());
                                        logger.info("byteBuf : " + byteBuf);
                                    } finally {
                                        buff.release();
                                    }
                                }
                            });
                        }
                    });

            bootstrap.connect(new DomainSocketAddress("/Users/sunqi/study/p0f/p0f.socket"));
        } catch (Throwable e) {
            logger.error("error", e);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            logger.error("sleep error", e);
        }
        logger.info("success");
    }
}
