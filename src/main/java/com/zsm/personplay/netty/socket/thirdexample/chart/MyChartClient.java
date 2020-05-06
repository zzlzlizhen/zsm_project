package com.zsm.personplay.netty.socket.thirdexample.chart;

import com.zsm.personplay.netty.socket.client.MyClientInitlalizer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * created by zsm on 2020/5/6
 */
public class MyChartClient {
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new MyChartInitLalizer());
            try {
                Channel channel = bootstrap.connect("localhost", 8789).sync().channel();
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                for (;;){
                    channel.writeAndFlush(br.readLine() + "\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
