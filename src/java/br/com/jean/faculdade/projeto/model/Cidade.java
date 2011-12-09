/**
 * 
 */
package br.com.jean.faculdade.projeto.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author jeanmatheus
 *
 */

@Entity
public class Cidade implements Serializable, GenericModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private String nome;
    
    @Column(unique = true)
    private Long cep;
    
    @OneToOne(cascade= CascadeType.ALL)
    private Uf uf;
    
    /**
     * 
     */
    public Cidade() {      
    }

    /**
     * @return the id
     */
    @Override
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
     * @return the cep
     */
    public Long getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(Long cep) {
        this.cep = cep;
    }

    /**
     * @return the uf
     */
    public Uf getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(Uf uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.cep != other.cep && (this.cep == null || !this.cep.equals(other.cep))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 41 * hash + (this.cep != null ? this.cep.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return  nome ;
    }
}
