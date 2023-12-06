package com.springbatch.envioPromocoesClientesJob.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    @Bean
    public Job envioEmailClientesJob(JobRepository jobRepository, Step envioEmailClientesStep) {
        return new JobBuilder("envioEmailClientesJob", jobRepository)
                .start(envioEmailClientesStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
