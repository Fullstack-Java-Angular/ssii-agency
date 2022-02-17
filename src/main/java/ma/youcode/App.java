package ma.youcode;

import ma.youcode.config.WebConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class App {
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
    }
}
