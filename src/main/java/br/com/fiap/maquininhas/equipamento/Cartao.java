package br.com.fiap.maquininhas.equipamento;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "cartoes")
public class Cartao {

    @Column(name = "id_cartao")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(STRING)
    private TipoDoCartao tipo;
    @Enumerated(STRING)
    private Bandeira bandeira;
    private TaxaDeCompra taxa;

    public Cartao(TipoDoCartao tipo, Bandeira bandeira, TaxaDeCompra taxa) {
        this.tipo = tipo;
        this.bandeira = bandeira;
        this.taxa = taxa;
    }

    /**
     * apenas frameworks
     */
    @Deprecated
    public Cartao() {}

    public Long getId() {
        return id;
    }

    public TipoDoCartao getTipo() {
        return tipo;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public TaxaDeCompra getTaxa() {
        return taxa;
    }

}
