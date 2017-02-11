import io.vertx.core.Vertx;

/**
 * Created by inikolaev on 11/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        Vertx vertx = Vertx.vertx();

        for (int i = 0; i < availableProcessors; i++) {
            vertx.deployVerticle(new HelloWorldVerticle());
        }
    }
}
