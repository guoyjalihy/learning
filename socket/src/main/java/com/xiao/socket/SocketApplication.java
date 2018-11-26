package com.xiao.socket;

import com.xiao.socket.server.AlarmServerHandler;
import com.xiao.socket.server.AlarmSocketServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;
import java.nio.charset.Charset;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.xiao.socket.dao")
public class SocketApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private AlarmSocketServer alarmSocketServer;
	private int[] portArry = new int[]{31232,31233,31234};
	public static void main(String[] args) {
		SpringApplication.run(SocketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		alarmSocketServer.startServer(portArry);
	}

	public void startServerAndListeningPort(int port) throws Exception{
		EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap(); // (2)
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class) // (3)
					.childHandler(new ChannelInitializer<SocketChannel>() { // (4)
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new IdleStateHandler(180,0,0, TimeUnit.SECONDS));
							ch.pipeline().addLast(new AlarmServerHandler());
							ch.pipeline().addLast(new StringEncoder(Charset.forName("UTF-8")));
							ch.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
						}
					})
					.option(ChannelOption.SO_BACKLOG, 1024)
//                    .option(ChannelOption.SO_SNDBUF,  1024)
					.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

			// Bind and start to accept incoming connections.
			ChannelFuture f = b.bind(port).sync(); // (7)
			logger.info("ApiApplication startServerAndListeningPort.port:{}",port);
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
