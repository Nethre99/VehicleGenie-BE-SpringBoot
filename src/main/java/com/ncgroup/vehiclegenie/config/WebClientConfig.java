package com.ncgroup.vehiclegenie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
public class WebClientConfig {

    @Bean
    public Scheduler scheduler(){
        return Schedulers.boundedElastic();
    }

    @Bean(name = "vehicle-genie-ml")
    public WebClient vehicleGenieWebClient(ReactorClientHttpConnector connector, VehicleGenieML vehicleGenieML){
        return WebClient.builder().baseUrl(vehicleGenieML.getBaseUrl())
                .clientConnector(connector)
                .build();
    }
}
