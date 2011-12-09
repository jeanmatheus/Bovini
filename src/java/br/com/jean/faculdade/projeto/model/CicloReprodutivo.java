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
public class CicloReprodutivo implements Serializable, GenericModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Integer numeroParto;
    private String ciclo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInseminacao;
    
    @OneToOne
    private Animal animal;

    /**
     * 
     */
    public CicloReprodutivo() {
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
     * @return the numeroParto
     */
    public Integer getNumeroParto() {
        return numeroParto;
    }

    /**
     * @param numeroParto the numeroParto to set
     */
    public void setNumeroParto(Integer numeroParto) {
        this.numeroParto = numeroParto;
    }

    /**
     * @return the dataInseminacao
     */
    public Date getDataInseminacao() {
        return dataInseminacao;
    }

    /**
     * @param dataInseminacao the dataInseminacao to set
     */
    public void setDataInseminacao(Date dataInseminacao) {
        this.dataInseminacao = dataInseminacao;
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

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CicloReprodutivo other = (CicloReprodutivo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.numeroParto != other.numeroParto && (this.numeroParto == null || !this.numeroParto.equals(other.numeroParto))) {
            return false;
        }
        if (this.dataInseminacao != other.dataInseminacao && (this.dataInseminacao == null || !this.dataInseminacao.equals(other.dataInseminacao))) {
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
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 73 * hash + (this.numeroParto != null ? this.numeroParto.hashCode() : 0);
        hash = 73 * hash + (this.dataInseminacao != null ? this.dataInseminacao.hashCode() : 0);
        hash = 73 * hash + (this.animal != null ? this.animal.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "CicloReprodutivo{" + "id=" + id + ", numeroParto=" + numeroParto + ", dataInseminacao=" + dataInseminacao + ", animal=" + animal + '}';
    }
    
    
}
