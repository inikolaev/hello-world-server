import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 * Created by inikolaev on 11/02/2017.
 */
public class HelloWorldVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();

        Router router = Router.router(vertx);

        router.route().handler(context -> {
            HttpServerResponse response = context.response();
            response.putHeader("Server", "akka-http/2.3.12");
            response.putHeader("Date", "Wed, 08 Feb 2017 18:32:30 GMT");
            response.putHeader("Content-Type", "text/plain; charset=UTF-8");
            response.end("Hello, World!");
        });

        vertx.createHttpServer().requestHandler(request -> router.accept(request)).listen(9090);
    }
}
