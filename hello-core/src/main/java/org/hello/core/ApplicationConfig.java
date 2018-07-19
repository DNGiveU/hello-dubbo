package org.hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring 配置类
 * @author: hanqiang
 * @Date: 2018年7月19日
 */
@Configuration
@ComponentScan(basePackages = {"org.hello.core"})
@EnableAspectJAutoProxy
public class ApplicationConfig {}
