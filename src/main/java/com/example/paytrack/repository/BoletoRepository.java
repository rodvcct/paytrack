package com.example.paytrack.repository;

import com.example.paytrack.entity.Boleto;
import com.example.paytrack.entity.StatusBoleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long> {

    boolean existsByLinhaDigitavel(String linhaDigitavel);

    Optional<Boleto> findByLinhaDigitavel(String linhaDigitavel);

    List<Boleto> findByStatus(StatusBoleto status);

    List<Boleto> findByStatusOrderByVencimentoAsc(StatusBoleto status);

    List<Boleto> findByVencimentoBefore(LocalDate data);

    List<Boleto> findByVencimentoBetween(LocalDate inicio, LocalDate fim);
}
