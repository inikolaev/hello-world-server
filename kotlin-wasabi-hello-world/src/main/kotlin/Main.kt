
import org.wasabifx.wasabi.app.AppConfiguration
import org.wasabifx.wasabi.app.AppServer

/**
 * Created by inikolaev on 11/02/2017.
 */

fun main(args: Array<String>) {
    var server = AppServer(AppConfiguration(port=9090))
    server.get("/", { response.send("Hello World!") })
    server.start()
}