package com.springbatch.envioPromocoesClientesJob.reader;

import com.springbatch.envioPromocoesClientesJob.domain.Cliente;
import com.springbatch.envioPromocoesClientesJob.domain.InteresseProdutoCliente;
import com.springbatch.envioPromocoesClientesJob.domain.Produto;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class LerInteresseProdutoClienteReaderConfig {

    @Bean
    public JdbcCursorItemReader<InteresseProdutoCliente> lerInteresseProdutoClienteReader(
            @Qualifier("appDataSource") DataSource dataSource
    ) {
        return new JdbcCursorItemReaderBuilder<InteresseProdutoCliente>()
                .name("lerInteresseProdutoClienteReader")
                .dataSource(dataSource)
                .sql("""
                        select *
                            from interesse_produto_cliente ipc
                                inner join cliente c on (c.id = ipc.cliente)
                                inner join produto p on (p.id = ipc.produto)
                        """)
                .rowMapper(rowMapper())
                .build();
    }

    private RowMapper<InteresseProdutoCliente> rowMapper() {
        return new RowMapper<InteresseProdutoCliente>() {
            @Override
            public InteresseProdutoCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));

                Produto produto = new Produto();
                produto.setId(rs.getInt(6));
                produto.setNome(rs.getString(7));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));

                return new InteresseProdutoCliente(cliente, produto);
            }
        };
    }
}
