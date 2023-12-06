package com.springbatch.envioPromocoesClientesJob.step;

import com.springbatch.envioPromocoesClientesJob.domain.InteresseProdutoCliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepConfig {

    @Bean
    public Step envioEmailClientesStep(
            JobRepository jobRepository,
            ItemReader<InteresseProdutoCliente> lerInteresseProdutoClienteReader,
            ItemProcessor<InteresseProdutoCliente, SimpleMailMessage> processarEmailProdutoClienteProcessor,
            ItemWriter<SimpleMailMessage> enviarEmailProdutoClienteWriter,
            PlatformTransactionManager transactionManager) {
        return new StepBuilder("envioEmailClientesStep", jobRepository)
                .<InteresseProdutoCliente, SimpleMailMessage>chunk(1, transactionManager)
                .reader(lerInteresseProdutoClienteReader)
                .processor(processarEmailProdutoClienteProcessor)
                .writer(enviarEmailProdutoClienteWriter)
                .build();
    }
}
