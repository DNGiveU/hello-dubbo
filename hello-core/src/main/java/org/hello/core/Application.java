package org.hello.core;

import java.io.IOException;

import org.hello.api.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

/**
 * Hello world!
 * -Djava.net.preferIPv4Stack=true
 * mvn -Djava.net.preferIPv4Stack=true -Dexec.mainClass=org.hello.core.Application exec:java
 */
public class Application {
    public static void main(String[] args) throws IOException {
    	ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
    	serviceConfig.setApplication(new ApplicationConfig("dubbo-provider"));
    	serviceConfig.setRegistry(new RegistryConfig("multicast://224.5.6.7:1234"));
    	serviceConfig.setInterface(UserService.class);
    	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(org.hello.core.ApplicationConfig.class);
    	// 实例从Spring中获取，以便使用自动装配
//    	serviceConfig.setRef(new DefaultUserService());
    	serviceConfig.setRef(applicationContext.getBean(UserService.class));
    	serviceConfig.export();
    	// 阻塞
    	System.in.read();
    	applicationContext.close();
    }
}
