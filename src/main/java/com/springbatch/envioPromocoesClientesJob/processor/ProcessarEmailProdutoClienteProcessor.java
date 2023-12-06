package com.springbatch.envioPromocoesClientesJob.processor;

import com.springbatch.envioPromocoesClientesJob.domain.InteresseProdutoCliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

@Component
public class ProcessarEmailProdutoClienteProcessor implements ItemProcessor<InteresseProdutoCliente, SimpleMailMessage> {

    @Override
    public SimpleMailMessage process(InteresseProdutoCliente interesseProdutoCliente) throws Exception {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("noreply@mail.com");
        email.setTo(interesseProdutoCliente.getCliente().getEmail());
        email.setSubject("Promoção Imperdível!!!");
        email.setText(gerarTextoPromocao(interesseProdutoCliente));
        return email;
    }

    private String gerarTextoPromocao(InteresseProdutoCliente interesseProdutoCliente) {
        String writer = String.format("Olá, %s!\n\n", interesseProdutoCliente.getCliente().getNome()) +
                "Essa promoção poser ser do seu interesse:\n\n" +
                String.format("%s - %s\n\n", interesseProdutoCliente.getProduto().getNome(),
                        interesseProdutoCliente.getProduto().getDescricao()) +
                String.format("Por apenas: %s!",
                        NumberFormat
                                .getCurrencyInstance(Locale.of("pt_BR"))
                                .format(interesseProdutoCliente.getProduto().getPreco()));

        return writer;
    }
}
