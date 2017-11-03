package cn.demo.service0.config;

import cn.g2link.storage.api.IStorageHandler;
import cn.g2link.storage.config.StorageConfigBean;
import cn.g2link.storage.oss.StorageHandlerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: chenhongwei
 * @data: Created in 上午9:36 2017/10/31
 * @version: 1.0
 */
@RefreshScope
@ConfigurationProperties
@Component("appCofigBean")
public class AppCofigBean {

    @Value("${server.port}")
    private Integer port;
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String serviceUrl;
    @Value("${eureka.instance.instance-id:http://localhost:8081}")
    private String instanceId;
    @Value("${eureka.instance.hostname:localhost}")
    private String hostname;
    @Value("${oss.accessKeyId}")
    private String accessKeyId;
    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${oss.endpoint}")
    private String endpoint;

    @Bean
    public IStorageHandler getStorageUtil() {
        return new StorageHandlerImpl(StorageConfigBean.newInstance(endpoint, accessKeyId, accessKeySecret));
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
