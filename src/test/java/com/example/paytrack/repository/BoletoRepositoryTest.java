package com.example.paytrack.repository;

import com.example.paytrack.entity.Boleto;
import com.example.paytrack.entity.StatusBoleto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class BoletoRepositoryTest {

    @Autowired
    private BoletoRepository repository;

    @Test
    void deveSalvarEBuscarPorLinhaDigitavel() {
        Boleto boleto = new Boleto();
        boleto.setBeneficiario("Empresa Teste");
        boleto.setLinhaDigitavel("12345678901234567890123456789012345678901234567");
        boleto.setValor(new BigDecimal("150.75"));
        boleto.setVencimento(LocalDate.now().plusDays(5));
        boleto.setStatus(StatusBoleto.values()[0]); // primeiro valor do seu enum

        Boleto salvo = repository.save(boleto);

        assertNotNull(salvo.getId());
        assertTrue(repository.existsByLinhaDigitavel(boleto.getLinhaDigitavel()));
        assertTrue(repository.findByLinhaDigitavel(boleto.getLinhaDigitavel()).isPresent());
    }
}