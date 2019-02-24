package br.com.fiap.maquininhas.equipamento.repositorios;

import br.com.fiap.maquininhas.equipamento.Cartao;
import br.com.fiap.maquininhas.equipamento.Maquininha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepositorio extends JpaRepository<Cartao, Long> {
}
