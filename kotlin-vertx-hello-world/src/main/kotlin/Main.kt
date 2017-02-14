/**
 * Created by inikolaev on 04/02/2017.
 */

import io.vertx.core.AbstractVerticle
import io.vertx.core.DeploymentOptions
import io.vertx.core.Vertx
import io.vertx.ext.web.Router

class HelloWorldVerticle: AbstractVerticle() {
    override fun start() {
        val router = Router.router(vertx)

        router.route().handler { context ->
            context.response().apply {
                putHeader("Server", "akka-http/2.3.12")
                putHeader("Date", "Wed, 08 Feb 2017 18:32:30 GMT")
                putHeader("Content-Type", "text/plain; charset=UTF-8")
                end("Hello, World!")
            }
        }

        vertx.createHttpServer().requestHandler { router.accept(it) }.listen(9090)
    }
}

fun main(args: Array<String>) {
    val vertx = Vertx.vertx()
    val options = DeploymentOptions().setInstances(Runtime.getRuntime().availableProcessors())

    vertx.deployVerticle(HelloWorldVerticle(), options)
}

