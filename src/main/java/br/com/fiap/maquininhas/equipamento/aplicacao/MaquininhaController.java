package br.com.fiap.maquininhas.equipamento.aplicacao;

import br.com.fiap.maquininhas.equipamento.FabricaDeMaquininha;
import br.com.fiap.maquininhas.equipamento.Maquininha;
import br.com.fiap.maquininhas.equipamento.servicos.MaquininhaServico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maquininhas")
public class MaquininhaController {

    private final MaquininhaServico maquininhaServico;
    private FabricaDeMaquininha fabricaDeMaquininha;


    public MaquininhaController(MaquininhaServico maquininhaServico, FabricaDeMaquininha fabricaDeMaquininha) {
        this.maquininhaServico = maquininhaServico;
        this.fabricaDeMaquininha = fabricaDeMaquininha;
    }


    @GetMapping("insereSmart")
    public Maquininha urlMagica() {
        Maquininha maquininha = fabricaDeMaquininha.criaModerninhaSmart();
        return maquininhaServico.salvar(maquininha);
    }
}
