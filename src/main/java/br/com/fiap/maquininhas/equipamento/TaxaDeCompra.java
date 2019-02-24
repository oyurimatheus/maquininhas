package br.com.fiap.maquininhas.equipamento;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class TaxaDeCompra {

    private BigDecimal taxaAvista;
    private BigDecimal taxaParcelada;
    private String ressalvas;


    public TaxaDeCompra(BigDecimal taxaAvista, BigDecimal taxaParcelada, String ressalvas) {
        this.taxaAvista = taxaAvista;
        this.taxaParcelada = taxaParcelada;
        this.ressalvas = ressalvas;
    }


    /**
     * apenas frameworks
     */
    @Deprecated
    public TaxaDeCompra() {}

    public TaxaDeCompra(BigDecimal taxaAvista) {
        this(taxaAvista, BigDecimal.ZERO, "");
    }

    public BigDecimal getTaxaAvista() {
        return taxaAvista;
    }

    public BigDecimal getTaxaParcelada() {
        return taxaParcelada;
    }

    public String getRessalvas() {
        return ressalvas;
    }
}
