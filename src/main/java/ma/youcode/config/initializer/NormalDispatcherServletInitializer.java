package ma.youcode.config.initializer;

import ma.youcode.config.NormalWebApplicationConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class NormalDispatcherServletInitializer extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext normalWebContext = new AnnotationConfigWebApplicationContext();
        normalWebContext.register(NormalWebApplicationConfig.class);
        return normalWebContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }


    @Override
    protected String getServletName() {
        return "normal-dispatcher";
    }
}
