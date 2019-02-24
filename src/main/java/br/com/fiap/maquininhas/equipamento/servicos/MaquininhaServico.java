package br.com.fiap.maquininhas.equipamento.servicos;

import br.com.fiap.maquininhas.equipamento.Maquininha;
import br.com.fiap.maquininhas.equipamento.repositorios.MaquininhaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class MaquininhaServico {

    private MaquininhaRepositorio maquininhaRepositorio;

    public MaquininhaServico(MaquininhaRepositorio maquininhaRepositorio) {

        this.maquininhaRepositorio = maquininhaRepositorio;
    }

    public Maquininha salvar(Maquininha maquininha) {
        return maquininhaRepositorio.save(maquininha);
    }
}
