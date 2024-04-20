package org.example.nacos.cluster;

import com.alibaba.nacos.sys.filter.NacosTypeExcludeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.alibaba.nacos","org.example"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {NacosTypeExcludeFilter.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {TypeExcludeFilter.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {AutoConfigurationExcludeFilter.class}),
        @ComponentScan.Filter(type = FilterType.REGEX,
                pattern = {"com.alibaba.nacos.core.namespace.*",
                        "com.alibaba.nacos.core.service.NamespaceOperationService","com.alibaba.nacos.persistence.repository.*",
                        "com.alibaba.nacos.core.persistence.*"}),
})
@ServletComponentScan
@EnableScheduling
public class NacosCluster {
    public static void main(String[] args) {
        SpringApplication.run(NacosCluster.class, args);
    }

}
