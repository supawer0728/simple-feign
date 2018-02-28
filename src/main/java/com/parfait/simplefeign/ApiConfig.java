package com.parfait.simplefeign;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

@Configuration
public class ApiConfig {

    @Bean
    public Module customModule() {
        SimpleModule module = new SimpleModule("simple-feign", new Version(0, 0, 1, "SNAPSHOT", "com.parfait", "simple-feign"));
        module.setMixInAnnotation(Page.class, SimplePageImpl.class);
        return module;
    }

    @JsonDeserialize(as = SimplePageImpl.class)
    private interface PageMixIn {
    }
}
