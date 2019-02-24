package br.com.fiap.maquininhas.equipamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum ModeloDaMaquina {

    MODERNINHA_SMART(new BigDecimal("478.80")),
    MODERNINHA_PRO(new BigDecimal("430.80")),
    MODERNINHA_PLUS(new BigDecimal("118.80")),
    MINIZINHA_CHIP(new BigDecimal("118.80")),
    MINIZINHA(new BigDecimal("58.80"));


    private final BigDecimal precoTotal;

    ModeloDaMaquina(BigDecimal total) {
        this.precoTotal = total;
    }
    public BigDecimal getPrecoTotal() {
        return this.precoTotal;
    }
    public BigDecimal getPrecoParcelado() {
        return this.precoTotal.divide(new BigDecimal("12"), RoundingMode.HALF_UP);
    }
}
