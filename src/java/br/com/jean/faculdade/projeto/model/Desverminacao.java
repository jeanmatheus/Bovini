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
public class Desverminacao implements Serializable, GenericModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer principioAtivo;
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date validadeDes;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDesvermificacao;
    
    @OneToOne
    private Animal animal;

    /**
     * 
     */
    public Desverminacao() {
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
     * @return the principioAtivo
     */
    public Integer getPrincipioAtivo() {
        return principioAtivo;
    }

    /**
     * @param principioAtivo the principioAtivo to set
     */
    public void setPrincipioAtivo(Integer principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    /**
     * @return the dataDesvermificacao
     */
    public Date getDataDesvermificacao() {
        return dataDesvermificacao;
    }

    /**
     * @param dataDesvermificacao the dataDesvermificacao to set
     */
    public void setDataDesvermificacao(Date dataDesvermificacao) {
        this.dataDesvermificacao = dataDesvermificacao;
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

    public Date getValidadeDes() {
        return validadeDes;
    }

    public void setValidadeDes(Date validadeDes) {
        this.validadeDes = validadeDes;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Desverminacao other = (Desverminacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.principioAtivo != other.principioAtivo && (this.principioAtivo == null || !this.principioAtivo.equals(other.principioAtivo))) {
            return false;
        }
        if (this.dataDesvermificacao != other.dataDesvermificacao && (this.dataDesvermificacao == null || !this.dataDesvermificacao.equals(other.dataDesvermificacao))) {
            return false;
        }
        if (this.animal != other.animal && (this.animal == null || !this.animal.equals(other.animal))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 79 * hash + (this.principioAtivo != null ? this.principioAtivo.hashCode() : 0);
        hash = 79 * hash + (this.dataDesvermificacao != null ? this.dataDesvermificacao.hashCode() : 0);
        hash = 79 * hash + (this.animal != null ? this.animal.hashCode() : 0);
        return hash;
    }
    
    
}
