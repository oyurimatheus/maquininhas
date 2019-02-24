package br.com.fiap.maquininhas.equipamento;

import javax.persistence.Embeddable;

@Embeddable
public class Dimensao {

    private Double comprimento;
    private Double largura;
    private Double altura;

    public Dimensao(Double comprimento, Double largura, Double altura) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
    }

    /**
     * apenas frameworks
     */
    @Deprecated
    public Dimensao() {}

    public Double getComprimento() {
        return comprimento;
    }

    public Double getLargura() {
        return largura;
    }

    public Double getAltura() {
        return altura;
    }
}
