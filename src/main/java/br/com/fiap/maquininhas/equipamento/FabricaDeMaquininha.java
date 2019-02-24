package br.com.fiap.maquininhas.equipamento;

import br.com.fiap.maquininhas.equipamento.repositorios.CartaoRepositorio;
import br.com.fiap.maquininhas.equipamento.repositorios.VoucherRepositorio;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.maquininhas.equipamento.Comprovante.*;
import static br.com.fiap.maquininhas.equipamento.Conexao.*;
import static br.com.fiap.maquininhas.equipamento.TipoDoTeclado.TOUCHSCREEN;
import static br.com.fiap.maquininhas.equipamento.Visor.COLORIDO_TOUCHSCREEN;
import static br.com.fiap.maquininhas.equipamento.Voltagem.BIVOLT;

@Component
public class FabricaDeMaquininha {


    private CartaoRepositorio cartaoRepositorio;
    private VoucherRepositorio voucherRepositorio;

    public FabricaDeMaquininha(CartaoRepositorio cartaoRepositorio, VoucherRepositorio voucherRepositorio) {
        this.cartaoRepositorio = cartaoRepositorio;
        this.voucherRepositorio = voucherRepositorio;
    }

    public  Maquininha criaModerninhaSmart() {
        List<Cartao> cartoes = cartaoRepositorio.findAll();

        List<Voucher> vouchers = voucherRepositorio.findAll();

        List<Conexao> conexoes = new ArrayList<Conexao>(){{
            add(BLUETOOTH);
            add(WIFI);
            add(CHIP_4G);

        }};

        List<Comprovante> comprovantes = new ArrayList<Comprovante>(){{
            add(EMAIL);
            add(SMS);
            add(IMPRESSO);

        }};

        EspecificacoesTecnicas especificacoes= new EspecificacoesTecnicas(10, conexoes,
                new Dimensao(19.0, 8.5, 6.6),
                5, 455.0,
                TOUCHSCREEN, COLORIDO_TOUCHSCREEN, BIVOLT);


        return new Maquininha(ModeloDaMaquina.MODERNINHA_SMART, cartoes, vouchers, comprovantes, especificacoes);
    }
}
