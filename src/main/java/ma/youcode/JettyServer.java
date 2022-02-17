package ma.youcode;

import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.PostConstruct;


@Component
public class JettyServer {

    private ApplicationContext context;

    public JettyServer(ApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void launcher() throws Exception {
        System.out.println("context = " + context.getDisplayName());
        System.out.println("JettyServer.launcher");
        Server server = new Server();
        ServerConnector httpConnector = new ServerConnector(server);

        httpConnector.setPort(8082);
        httpConnector.setHost("0.0.0.0");

        server.addConnector(httpConnector);

        server.setHandler(getHandler());

        server.start();
        server.join();
    }

    private ServletContextHandler getHandler() {
        ServletContextHandler handler = new ServletContextHandler();
        // TODO: search how to convert ApplicationContext -> WebApplicationContext
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        ServletHolder springServletHolder = new ServletHolder("mvc-dispatcher", dispatcherServlet);
        handler.addServlet(springServletHolder, "/");
//        contextHandler.addEventListener(new ContextLoaderListener(webAppContext));
        return handler;
    }
}
