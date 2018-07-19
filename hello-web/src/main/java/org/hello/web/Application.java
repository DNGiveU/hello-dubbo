package org.hello.web;

import org.hello.api.service.UserService;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * Hello world!
 * -Djava.net.preferIPv4Stack=true
 * mvn -Djava.net.preferIPv4Stack=true -Dexec.mainClass=org.hello.web.Application exec:java
 */
public class Application {
    public static void main(String[] args){
    	ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<>();
    	referenceConfig.setApplication(new ApplicationConfig("dubbo-consumer"));
    	referenceConfig.setRegistry(new RegistryConfig("multicast://224.5.6.7:1234"));
    	referenceConfig.setInterface(UserService.class);
    	
    	UserService userService = referenceConfig.get();
    	System.out.println(userService.getById("tom"));
    }
}
