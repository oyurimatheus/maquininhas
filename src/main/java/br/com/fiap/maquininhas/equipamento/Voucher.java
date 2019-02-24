package br.com.fiap.maquininhas.equipamento;

import javax.persistence.*;

@Entity
@Table(name = "vouchers")
public class Voucher {

    @Column(name = "id_voucher")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Bandeira bandeira;

    private String ressalva;

    public Voucher(Bandeira bandeira, String ressalva) {
        this.bandeira = bandeira;
        this.ressalva = ressalva;
    }

    /**
     * apenas frameworks
     */
    @Deprecated
    public Voucher() {}

    public Long getId() {
        return id;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public String getRessalva() {
        return ressalva;
    }
}
