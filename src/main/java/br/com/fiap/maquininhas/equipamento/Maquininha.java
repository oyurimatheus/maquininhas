package br.com.fiap.maquininhas.equipamento;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "maquininhas")
public class Maquininha {

    @Column(name = "id_maquininha")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = STRING)
    private ModeloDaMaquina modelo;

    @ManyToMany
    @JoinTable(
        name = "maquininhas_cartoes",
        joinColumns = @JoinColumn(name = "id_maquininha"),
        inverseJoinColumns = { @JoinColumn(name = "id_cartao") }
    )
    private List<Cartao> cartoesAceitos;

    @ManyToMany
    @JoinTable(
        name = "maquininhas_vouchers",
        joinColumns = @JoinColumn(name = "id_maquininha"),
        inverseJoinColumns = { @JoinColumn(name = "id_voucher") }
    )
    private List<Voucher> vouchers;



    @ElementCollection(targetClass = Conexao.class)
    @JoinTable(name = "comprvantes", joinColumns = { @JoinColumn(name = "id_maquininha") })
    @Column(name = "comprovante")
    @Enumerated(STRING)
    private List<Comprovante> comprovantes;

    private EspecificacoesTecnicas especificacoesTecnicas;

    public Maquininha(ModeloDaMaquina modelo, List<Cartao> cartoesAceitos, List<Voucher> vouchers, List<Comprovante> comprovantes, EspecificacoesTecnicas especificacoesTecnicas) {
        this.modelo = modelo;
        this.cartoesAceitos = cartoesAceitos;
        this.vouchers = vouchers;
        this.comprovantes = comprovantes;
        this.especificacoesTecnicas = especificacoesTecnicas;
    }


    /**
     * apenas para frameworks
     */
    @Deprecated
    public Maquininha() {}

    public Long getId() {
        return id;
    }

    public ModeloDaMaquina getModelo() {
        return modelo;
    }

    public List<Cartao> getCartoesAceitos() {
        return cartoesAceitos;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public EspecificacoesTecnicas getEspecificacoesTecnicas() {
        return especificacoesTecnicas;
    }
}
