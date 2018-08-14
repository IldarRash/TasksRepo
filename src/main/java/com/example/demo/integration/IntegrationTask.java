package com.example.demo.integration;

import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;

import javax.sql.DataSource;

@Configuration
public class IntegrationTask {
   /*
    @Autowired
    private DataSource dataSource;

    private static final String UPDATE_TASK_TO_RUN = "UPDATE tasks set status = runnig where status = created";

    private static final String SELECT_TASK = "SELECT * FROM tasks";

    @Bean
    public MessageSource<Task> jdbcMessageSource() {
        return (MessageSource)new JdbcPollingChannelAdapter(dataSource, SELECT_TASK);
    }

    public IntegrationFlow pollingFlowUpdate() {
        return IntegrationFlows.from(jdbcMessageSource(),
                c ->)
    }*/


}
