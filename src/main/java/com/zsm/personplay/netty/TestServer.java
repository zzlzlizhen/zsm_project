package com.zsm.personplay.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * created by zsm on 2020/4/29
 */
public class TestServer {
    public static void main(String[] args) {
        //定义俩个事件循环组（死循环）
        EventLoopGroup bossGroup = new NioEventLoopGroup();//获取链接，然后把连接转给下面的线程
        EventLoopGroup workGroup = new NioEventLoopGroup();//

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class).childHandler(new TestServerInitializer());
            ChannelFuture channelFature = serverBootstrap.bind(8899).sync();
            channelFature.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
