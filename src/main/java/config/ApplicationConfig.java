package config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * Created by Newbody on 2016/3/1.
 */
@Configuration
@ComponentScan(basePackages = "com.sm", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class }) })
@EnableAspectJAutoProxy(proxyTargetClass=true)
@Import({DaoConfig.class})
public class ApplicationConfig {
}
