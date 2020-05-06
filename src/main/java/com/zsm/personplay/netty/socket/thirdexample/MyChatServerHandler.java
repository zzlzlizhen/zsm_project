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
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Channel channel = ctx.channel();
        channels.forEach(ch->{
            if(channel != ch){
                ch.writeAndFlush(channel.remoteAddress() + "发送消息：" + s + "\n");
            }else {
                ch.writeAndFlush("[自己]" + s + "\n");
            }
        });
    }

    //表示连接建立（服务器端跟客户端建立连接）
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //得到通到对象（服务器要把所有建立的连接channel通道保存起来）
        Channel channel = ctx.channel();
        channels.writeAndFlush("[服务器]-" + channel.remoteAddress() + "加入\n");
        channels.add(channel);
    }

    /**
     * 连接断开
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.writeAndFlush("【服务器】--" + channel.remoteAddress() + "离开\n");
        System.out.println(channels.size());
    }

    /**
     * 表示链接在活动状态
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.writeAndFlush( channel.remoteAddress() + "上线\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.writeAndFlush(channel.remoteAddress() + "下线\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
