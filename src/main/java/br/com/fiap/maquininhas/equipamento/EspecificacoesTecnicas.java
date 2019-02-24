package br.com.fiap.maquininhas.equipamento;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.EnumType.STRING;

@Embeddable
public class EspecificacoesTecnicas {

    private Integer duracaoDaBateria;

    @ElementCollection(targetClass = Conexao.class)
    @JoinTable(name = "conexoes", joinColumns = { @JoinColumn(name = "id") })
    @Column(name = "conexao")
    @Enumerated(STRING)
    private List<Conexao> conexoes;

    private Dimensao dimensao;
    private Integer garantia;
    private Double peso;

    @Enumerated(STRING)
    private TipoDoTeclado tipoDoTeclado;

    @Enumerated(STRING)
    private Visor visor;

    @Enumerated(STRING)
    private Voltagem voltagem;

    public EspecificacoesTecnicas(Integer duracaoDaBateria, List<Conexao> conexoes, Dimensao dimensao,
                                  Integer garantia, Double peso,
                                  TipoDoTeclado tipoDoTeclado, Visor visor, Voltagem voltagem) {
        this.duracaoDaBateria = duracaoDaBateria;
        this.conexoes = conexoes;
        this.dimensao = dimensao;
        this.garantia = garantia;
        this.peso = peso;
        this.tipoDoTeclado = tipoDoTeclado;
        this.visor = visor;
        this.voltagem = voltagem;
    }

    /**
     * apenas frameworks
     */
    @Deprecated
    public EspecificacoesTecnicas() {}

    public Integer getDuracaoDaBateria() {
        return duracaoDaBateria;
    }

    public List<Conexao> getConexoes() {
        return conexoes;
    }

    public Dimensao getDimensao() {
        return dimensao;
    }

    public Integer getGarantia() {
        return garantia;
    }

    public Double getPeso() {
        return peso;
    }

    public TipoDoTeclado getTipoDoTeclado() {
        return tipoDoTeclado;
    }

    public Visor getVisor() {
        return visor;
    }

    public Voltagem getVoltagem() {
        return voltagem;
    }
}
