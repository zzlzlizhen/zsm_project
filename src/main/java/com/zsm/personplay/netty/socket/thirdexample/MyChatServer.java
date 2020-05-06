package com.zsm.personplay.netty.socket.thirdexample;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * created by zsm on 2020/4/30
 */
public class MyChatServer {
    public static void main(String[] args) {
        //定义俩个事件循环组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        //
        try {
            //便捷简化类，来启动服务
            ServerBootstrap serverStrap = new ServerBootstrap();
            serverStrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new MyCharInitalizer());
            ChannelFuture channelFuture = serverStrap.bind(8789).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
