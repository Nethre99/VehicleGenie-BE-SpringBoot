package com.ncgroup.vehiclegenie.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "recommendation-config")
public class VehicleGenieML {
    private String baseUrl;
}
