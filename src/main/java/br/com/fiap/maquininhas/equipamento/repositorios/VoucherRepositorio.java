package br.com.fiap.maquininhas.equipamento.repositorios;

import br.com.fiap.maquininhas.equipamento.Maquininha;
import br.com.fiap.maquininhas.equipamento.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepositorios extends JpaRepository<Voucher, Long> {
}
