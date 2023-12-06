package com.springbatch.envioPromocoesClientesJob.config;

import com.springbatch.envioPromocoesClientesJob.job.ScheduleJobConfig;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean // Detalhes do job que será executado
    public JobDetail quartzJobDetail() {
        return JobBuilder
                .newJob(ScheduleJobConfig.class)
                .storeDurably() // Propriedade que diz para manter os dados das execuções agendadas
                .build();
    }

    @Bean
    public Trigger jobEmailTrigger() {
        SimpleScheduleBuilder scheduleBuilder =
                SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(60)
                        .withRepeatCount(2); // Vai executar 2x + 1(execução inicial);

        return TriggerBuilder
                .newTrigger()
                .forJob(quartzJobDetail())
                .withSchedule(scheduleBuilder)
                .build();
    }
}
