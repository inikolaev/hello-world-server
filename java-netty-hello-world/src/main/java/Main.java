import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Created by inikolaev on 11/02/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        EpollEventLoopGroup group = new EpollEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group);
            bootstrap.channel(EpollServerSocketChannel.class);

            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();

                    pipeline.addLast(new HttpServerCodec());
                    pipeline.addLast(new ServerHandler());
                }
            });

            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.bind(9090).sync().channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
