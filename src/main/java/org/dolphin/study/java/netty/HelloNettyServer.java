package org.dolphin.study.java.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by qi.sun on 16/8/16.
 */
public class HelloNettyServer {

    private static Logger logger = LogManager.getLogger(HelloServerHandler.class);
    private int port;

    public HelloNettyServer(int port) {
        this.port = port;
    }

    public void start() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            serverBootstrap.group(bossGroup, workGroup);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

                @Override protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new HelloServerHandler());
                }

                @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                    super.exceptionCaught(ctx, cause);
                }
            });
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 128);
            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            logger.info("server start");

            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("start exception");
        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
