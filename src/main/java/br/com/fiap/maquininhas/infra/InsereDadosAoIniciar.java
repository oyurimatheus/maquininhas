package br.com.fiap.maquininhas.infra;

import br.com.fiap.maquininhas.equipamento.Cartao;
import br.com.fiap.maquininhas.equipamento.TaxaDeCompra;
import br.com.fiap.maquininhas.equipamento.Voucher;
import br.com.fiap.maquininhas.equipamento.repositorios.CartaoRepositorio;
import br.com.fiap.maquininhas.equipamento.repositorios.VoucherRepositorio;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static br.com.fiap.maquininhas.equipamento.Bandeira.*;
import static br.com.fiap.maquininhas.equipamento.TipoDoCartao.CREDITO;
import static br.com.fiap.maquininhas.equipamento.TipoDoCartao.DEBITO;

@Component
public class InsereDadosAoIniciar implements ApplicationRunner {


    private final CartaoRepositorio cartaoRepositorio;
    private final VoucherRepositorio voucherRepositorio;

    public InsereDadosAoIniciar(CartaoRepositorio cartaoRepositorio, VoucherRepositorio voucherRepositorio) {
        this.cartaoRepositorio = cartaoRepositorio;
        this.voucherRepositorio = voucherRepositorio;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        insereCartoes();
        insereVouchers();
    }

    private void insereVouchers() {
        voucherRepositorio.save(new Voucher(ALELO, "A aceitação de voucher depende de contrato com a bandeira"));
        voucherRepositorio.save(new Voucher(SODEXO, "A aceitação de voucher depende de contrato com a bandeira"));
        voucherRepositorio.save(new Voucher(TICKET, "A aceitação de voucher depende de contrato com a bandeira"));
        voucherRepositorio.save(new Voucher(VR, "A aceitação de voucher depende de contrato com a bandeira"));
    }

    private void insereCartoes() {
        TaxaDeCompra taxaDeCompraPadraoCredito = new TaxaDeCompra(new BigDecimal("3.19"),
                new BigDecimal("3.79"),
                "Vendas parceladas, acréscimo de 2,99% ao mês");

        TaxaDeCompra taxaDeCompraPadraoDebito = new TaxaDeCompra(new BigDecimal("1.99"));

        TaxaDeCompra taxaDeCompraCartoesCreditoInternacionais = new TaxaDeCompra(new BigDecimal("3.59"),
                new BigDecimal("4.19"),
                "Vendas parceladas, acréscimo de 2,99% ao mês");


        cartaoRepositorio.save(new Cartao(CREDITO, MASTERCARD, taxaDeCompraPadraoCredito));
        cartaoRepositorio.save(new Cartao(CREDITO, VISA, taxaDeCompraPadraoCredito));
        cartaoRepositorio.save(new Cartao(CREDITO, ELO, taxaDeCompraPadraoCredito));
        cartaoRepositorio.save(new Cartao(CREDITO, HIPERCARD, taxaDeCompraPadraoCredito));
        cartaoRepositorio.save(new Cartao(CREDITO, HIPER, taxaDeCompraPadraoCredito));
        cartaoRepositorio.save(new Cartao(CREDITO, CANAL, taxaDeCompraPadraoCredito));
        cartaoRepositorio.save(new Cartao(CREDITO, AMERICAN_EXPRESS, taxaDeCompraCartoesCreditoInternacionais));
        cartaoRepositorio.save(new Cartao(CREDITO, DINERS, taxaDeCompraCartoesCreditoInternacionais));

        cartaoRepositorio.save(new Cartao(DEBITO, MAESTRO, taxaDeCompraPadraoDebito));
        cartaoRepositorio.save(new Cartao(DEBITO, VISA_ELECTRON, taxaDeCompraPadraoDebito));
        cartaoRepositorio.save(new Cartao(DEBITO, ELO, taxaDeCompraPadraoDebito));
        cartaoRepositorio.save(new Cartao(DEBITO, BANRI_COMPRAS, taxaDeCompraPadraoDebito));
        cartaoRepositorio.save(new Cartao(DEBITO, CABAL_DEBITO, taxaDeCompraPadraoDebito));
    }
}
