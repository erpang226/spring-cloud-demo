package com.syc.apigatewaydynamicfilter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("zuul.filter")
@Data
public class FilterConfiguration {
    private String root;
    private Integer interval;

}
