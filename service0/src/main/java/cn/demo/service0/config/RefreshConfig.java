package cn.demo.service0.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author: chenhongwei
 * @data: Created in 上午11:47 2017/10/31
 * @version: 1.0
 */
@Component
@EnableApolloConfig
public class RefreshConfig {

    @Autowired
    private RefreshScope refreshScope;

    @ApolloConfigChangeListener
    private void onchange(ConfigChangeEvent event) {

        String appConfigBean = "appConfigBean";
        refreshScope.refresh(appConfigBean);
    }
}
