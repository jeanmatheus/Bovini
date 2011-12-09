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
public class Animal implements Serializable, GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String nomeMae;
    private String nomePai;
    
    
    private String sisbov;
    
    private String sexo;
    private Integer numeroControle;
    private String categoria;
    private String raca;
    private String status;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDesmame;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date descarte;
    
    //ligaçoes
    @OneToOne
    private Propriedade propriedade;
    
    @OneToMany
    private List<Vacina> vacinas;
    
    @OneToMany
    private List<Desverminacao> desverminacao;
    
    @OneToMany
    private List<Cio> cios;
    
    @OneToMany
    private List<CicloReprodutivo> cicloReprodutivo;

    /**
     * 
     */
    public Animal() {
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
     * @return the nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @param nomeMae the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * @return the nomePai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * @param nomePai the nomePai to set
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * @return the sisbov
     */
    public String getSisbov() {
        return sisbov;
    }

    /**
     * @param sisbov the sisbov to set
     */
    public void setSisbov(String sisbov) {
        this.sisbov = sisbov;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    /**
     * @return the dataDesmame
     */
    public Date getDataDesmame() {
        return dataDesmame;
    }

    /**
     * @param dataDesmame the dataDesmame to set
     */
    public void setDataDesmame(Date dataDesmame) {
        this.dataDesmame = dataDesmame;
    }

    /**
     * @return the descarte
     */
    public Date getDescarte() {
        return descarte;
    }

    /**
     * @param descarte the descarte to set
     */
    public void setDescarte(Date descarte) {
        this.descarte = descarte;
    }

    /**
     * @return the propriedade
     */
    public Propriedade getPropriedade() {
        return propriedade;
    }

    /**
     * @param propriedade the propriedade to set
     */
    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<CicloReprodutivo> getCicloReprodutivo() {
        return cicloReprodutivo;
    }

    public void setCicloReprodutivo(List<CicloReprodutivo> cicloReprodutivo) {
        this.cicloReprodutivo = cicloReprodutivo;
    }

    public List<Cio> getCios() {
        return cios;
    }

    public void setCios(List<Cio> cios) {
        this.cios = cios;
    }

    public List<Desverminacao> getDesverminacao() {
        return desverminacao;
    }

    public void setDesverminacao(List<Desverminacao> desverminacao) {
        this.desverminacao = desverminacao;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(Integer numeroControle) {
        this.numeroControle = numeroControle;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.sisbov == null) ? (other.sisbov != null) : !this.sisbov.equals(other.sisbov)) {
            return false;
        }
        if ((this.sexo == null) ? (other.sexo != null) : !this.sexo.equals(other.sexo)) {
            return false;
        }
        if (this.dataNascimento != other.dataNascimento && (this.dataNascimento == null || !this.dataNascimento.equals(other.dataNascimento))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 23 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 23 * hash + (this.sisbov != null ? this.sisbov.hashCode() : 0);
        hash = 23 * hash + (this.sexo != null ? this.sexo.hashCode() : 0);
        hash = 23 * hash + (this.dataNascimento != null ? this.dataNascimento.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return nome ;
    }
    
}
