package br.com.fiap.maquininhas.equipamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.maquininhas.equipamento.Bandeira.*;
import static br.com.fiap.maquininhas.equipamento.Comprovante.EMAIL;
import static br.com.fiap.maquininhas.equipamento.Comprovante.IMPRESSO;
import static br.com.fiap.maquininhas.equipamento.Comprovante.SMS;
import static br.com.fiap.maquininhas.equipamento.Conexao.BLUETOOTH;
import static br.com.fiap.maquininhas.equipamento.Conexao.CHIP_4G;
import static br.com.fiap.maquininhas.equipamento.Conexao.WIFI;
import static br.com.fiap.maquininhas.equipamento.TipoDoCartao.CREDITO;
import static br.com.fiap.maquininhas.equipamento.TipoDoCartao.DEBITO;
import static br.com.fiap.maquininhas.equipamento.TipoDoTeclado.TOUCHSCREEN;
import static br.com.fiap.maquininhas.equipamento.Visor.COLORIDO_TOUCHSCREEN;
import static br.com.fiap.maquininhas.equipamento.Voltagem.BIVOLT;

public class FabricaDeMaquininha {

    private static TaxaDeCompra taxaDeCompraPadraoCredito = new TaxaDeCompra(new BigDecimal("3.19"),
            new BigDecimal("3.79"),
            "Vendas parceladas, acréscimo de 2,99% ao mês");
    private static TaxaDeCompra taxaDeCompraPadraoDebito = new TaxaDeCompra(new BigDecimal("1.99"));


    private FabricaDeMaquininha() {}

    public static Maquininha criaModerninhaSmart() {

       final TaxaDeCompra taxaDeCompraCartoesCreditoInternacionais = new TaxaDeCompra(new BigDecimal("3.59"),
                new BigDecimal("4.19"),
                "Vendas parceladas, acréscimo de 2,99% ao mês");

        List<Cartao> cartoes = new ArrayList<Cartao>() {{
            add(new Cartao(CREDITO, MASTERCARD, taxaDeCompraPadraoCredito));
            add(new Cartao(CREDITO, VISA, taxaDeCompraPadraoCredito));
            add(new Cartao(CREDITO, ELO, taxaDeCompraPadraoCredito));
            add(new Cartao(CREDITO, HIPERCARD, taxaDeCompraPadraoCredito));
            add(new Cartao(CREDITO, HIPER, taxaDeCompraPadraoCredito));
            add(new Cartao(CREDITO, CANAL, taxaDeCompraPadraoCredito));
            add(new Cartao(CREDITO, AMERICAN_EXPRESS, taxaDeCompraCartoesCreditoInternacionais));
            add(new Cartao(CREDITO, DINERS, taxaDeCompraCartoesCreditoInternacionais));

            add(new Cartao(DEBITO, MAESTRO, taxaDeCompraPadraoDebito));
            add(new Cartao(DEBITO, VISA_ELECTRON, taxaDeCompraPadraoDebito));
            add(new Cartao(DEBITO, ELO, taxaDeCompraPadraoDebito));
            add(new Cartao(DEBITO, BANRI_COMPRAS, taxaDeCompraPadraoDebito));
            add(new Cartao(DEBITO, CABAL_DEBITO, taxaDeCompraPadraoDebito));
        }};

        List<Voucher> vouchers = new ArrayList<Voucher>() {{
            add(new Voucher(ALELO, "A aceitação de voucher depende de contrato com a bandeira"));
            add(new Voucher(SODEXO, "A aceitação de voucher depende de contrato com a bandeira"));
            add(new Voucher(TICKET, "A aceitação de voucher depende de contrato com a bandeira"));
            add(new Voucher(VR, "A aceitação de voucher depende de contrato com a bandeira"));
        }};

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
