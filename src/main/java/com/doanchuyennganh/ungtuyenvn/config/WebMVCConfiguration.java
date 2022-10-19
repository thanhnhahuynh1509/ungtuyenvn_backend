package com.doanchuyennganh.ungtuyenvn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String dir = "assets/common/image";
        String absolutePath = new File(dir).getAbsolutePath();
        registry.addResourceHandler("/" + dir + "/**").addResourceLocations("file:/" + absolutePath + "/");
    }
}
