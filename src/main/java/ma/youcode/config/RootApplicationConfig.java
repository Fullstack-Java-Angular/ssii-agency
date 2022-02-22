package ma.youcode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ma.youcode.repository", "ma.youcode.service"})
public class RootApplicationConfig {
}
