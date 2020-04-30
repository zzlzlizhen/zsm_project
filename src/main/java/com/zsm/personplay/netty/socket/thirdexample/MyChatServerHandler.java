package com.zsm.personplay.netty.socket.thirdexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * created by zsm on 2020/4/30
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    //ChannelGroup(保存一个一个channel对象)
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //客户端一连接触发
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

    }

    //表示连接建立
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //得到通到对象（服务器要把所有建立的连接channel通道保存起来）
        Channel channel = ctx.channel();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
