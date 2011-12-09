/**
 * 
 */
package br.com.jean.faculdade.projeto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * @author jeanmatheus
 *
 */
@Entity
public class Propriedade implements Serializable, GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true)
    private String nome;  
    private String nomeFantasia; 
    private Long blocoProdutor;
    
    //auxiliar
    private String estadoAux;
    private String cidadeAux;
    
    
    @OneToOne(cascade= CascadeType.ALL)
    private Endereco endereco;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    private String complemento;
    
    @OneToMany
    private List<Animal> animais;
    
    @OneToMany
    private List<Pessoa> pessoas;

    /**
     * 
     */
    public Propriedade() {
        // TODO Auto-generated constructor stub
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
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return the blocoProdutor
     */
    public Long getBlocoProdutor() {
        return blocoProdutor;
    }

    /**
     * @param blocoProdutor the blocoProdutor to set
     */
    public void setBlocoProdutor(Long blocoProdutor) {
        this.blocoProdutor = blocoProdutor;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public List<Pessoa> getPessoas() {
        return pessoas ;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public String getCidadeAux() {
        return cidadeAux;
    }

    public void setCidadeAux(String cidadeAux) {
        this.cidadeAux = cidadeAux;
    }

    public String getEstadoAux() {
        return estadoAux;
    }

    public void setEstadoAux(String estadoAux) {
        this.estadoAux = estadoAux;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Propriedade other = (Propriedade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.nomeFantasia == null) ? (other.nomeFantasia != null) : !this.nomeFantasia.equals(other.nomeFantasia)) {
            return false;
        }
        if (this.blocoProdutor != other.blocoProdutor && (this.blocoProdutor == null || !this.blocoProdutor.equals(other.blocoProdutor))) {
            return false;
        }
        if (this.endereco != other.endereco && (this.endereco == null || !this.endereco.equals(other.endereco))) {
            return false;
        }
        if (this.dataCadastro != other.dataCadastro && (this.dataCadastro == null || !this.dataCadastro.equals(other.dataCadastro))) {
            return false;
        }
        if ((this.complemento == null) ? (other.complemento != null) : !this.complemento.equals(other.complemento)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 71 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 71 * hash + (this.nomeFantasia != null ? this.nomeFantasia.hashCode() : 0);
        hash = 71 * hash + (this.blocoProdutor != null ? this.blocoProdutor.hashCode() : 0);
        hash = 71 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 71 * hash + (this.dataCadastro != null ? this.dataCadastro.hashCode() : 0);
        hash = 71 * hash + (this.complemento != null ? this.complemento.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return nome;
    }
}
