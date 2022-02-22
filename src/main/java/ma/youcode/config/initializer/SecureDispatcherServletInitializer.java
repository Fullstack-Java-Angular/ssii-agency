package ma.youcode.config.initializer;

import ma.youcode.config.SecureWebApplicationConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class SecureDispatcherServletInitializer extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext secureWebContext = new AnnotationConfigWebApplicationContext();
        secureWebContext.register(SecureWebApplicationConfig.class);
        return secureWebContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/s/*"};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    @Override
    protected String getServletName() {
        return "secure-dispatcher";
    }
}
