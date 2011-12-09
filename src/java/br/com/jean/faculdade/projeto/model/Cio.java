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
public class Cio implements Serializable, GenericModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCio;
    private String nomeReprodutor;
    
    @OneToOne
    private Animal animal;

    /**
     * 
     */
    public Cio() {
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
     * @return the dataCio
     */
    public Date getDataCio() {
        return dataCio;
    }

    /**
     * @param dataCio the dataCio to set
     */
    public void setDataCio(Date dataCio) {
        this.dataCio = dataCio;
    }

    /**
     * @return the nomeReprodutor
     */
    public String getNomeReprodutor() {
        return nomeReprodutor;
    }

    /**
     * @param nomeReprodutor the nomeReprodutor to set
     */
    public void setNomeReprodutor(String nomeReprodutor) {
        this.nomeReprodutor = nomeReprodutor;
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
        final Cio other = (Cio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.dataCio != other.dataCio && (this.dataCio == null || !this.dataCio.equals(other.dataCio))) {
            return false;
        }
        if ((this.nomeReprodutor == null) ? (other.nomeReprodutor != null) : !this.nomeReprodutor.equals(other.nomeReprodutor)) {
            return false;
        }
        if (this.animal != other.animal && (this.animal == null || !this.animal.equals(other.animal))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 43 * hash + (this.dataCio != null ? this.dataCio.hashCode() : 0);
        hash = 43 * hash + (this.nomeReprodutor != null ? this.nomeReprodutor.hashCode() : 0);
        hash = 43 * hash + (this.animal != null ? this.animal.hashCode() : 0);
        return hash;
    }
    
    
}
