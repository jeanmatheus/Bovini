/**
 * 
 */
package br.com.jean.faculdade.projeto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
public class Pessoa implements Serializable, GenericModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true)
    private String nome;
    private Integer senha;
    private String email;
    private Long cpf;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
       
    @OneToOne
    private Endereco endereco;
    
    @OneToMany
    private List<Propriedade> propriedade;
    
    /**
     * 
     */
    public Pessoa() {
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
     * @return the senha
     */
    public Integer getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public Long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(Long cpf) {
        this.cpf = cpf;
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

    public List<Propriedade> getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(List<Propriedade> propriedade) {
        this.propriedade = propriedade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.senha != other.senha && (this.senha == null || !this.senha.equals(other.senha))) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if (this.cpf != other.cpf && (this.cpf == null || !this.cpf.equals(other.cpf))) {
            return false;
        }
        if (this.endereco != other.endereco && (this.endereco == null || !this.endereco.equals(other.endereco))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 31 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 31 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 31 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 31 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return  nome + "-" + senha + "-" + email + "-" + cpf + "-" + endereco;
    }

    
    
}
