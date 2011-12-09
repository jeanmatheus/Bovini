/**
 * 
 */
package br.com.jean.faculdade.projeto.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * @author jeanmatheus
 *
 */
@Entity
public class Vacina implements Serializable, GenericModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private String nome;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVacinacao;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date validade;
    
    private Integer numeroDose;
    
    @OneToOne
    private Animal animal;

    /**
     * 
     */
    public Vacina() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataVacinacao
     */
    public Date getDataVacinacao() {
        return dataVacinacao;
    }

    /**
     * @param dataVacinacao the dataVacinacao to set
     */
    public void setDataVacinacao(Date dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    /**
     * @return the validade
     */
    public Date getValidade() {
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(Date validade) {
        this.validade = validade;
    }

    /**
     * @return the numeroDose
     */
    public Integer getNumeroDose() {
        return numeroDose;
    }

    /**
     * @param numeroDose the numeroDose to set
     */
    public void setNumeroDose(Integer numeroDose) {
        this.numeroDose = numeroDose;
    }

    /**
     * @return the animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vacina other = (Vacina) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.dataVacinacao != other.dataVacinacao && (this.dataVacinacao == null || !this.dataVacinacao.equals(other.dataVacinacao))) {
            return false;
        }
        if (this.validade != other.validade && (this.validade == null || !this.validade.equals(other.validade))) {
            return false;
        }
        if (this.numeroDose != other.numeroDose && (this.numeroDose == null || !this.numeroDose.equals(other.numeroDose))) {
            return false;
        }
        if (this.animal != other.animal && (this.animal == null || !this.animal.equals(other.animal))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 61 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 61 * hash + (this.dataVacinacao != null ? this.dataVacinacao.hashCode() : 0);
        hash = 61 * hash + (this.validade != null ? this.validade.hashCode() : 0);
        hash = 61 * hash + (this.numeroDose != null ? this.numeroDose.hashCode() : 0);
        hash = 61 * hash + (this.animal != null ? this.animal.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Vacina{" + "nome=" + nome + ", animal=" + animal + '}';
    }
    
    
}
