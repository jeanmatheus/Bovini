/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Endereco;
import br.com.jean.faculdade.projeto.model.Propriedade;
import br.com.jean.faculdade.projeto.repositorio.PropriedadeRP;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.RollbackException;

/**
 *
 * @author Jean Matheus
 */
@ManagedBean
public class PropriedadeMB {

    private Propriedade propriedadeSelecionado;
    private PropriedadeRP propriedadeRP;
    private List<Propriedade> listaPropri;

    public PropriedadeMB() {
        this.propriedadeRP = new PropriedadeRP();
        this.propriedadeSelecionado = new Propriedade();

        getPropriedadeSelecionado().setEndereco(new Endereco());

        this.listaPropri = new ArrayList<Propriedade>();
    }

    public void salvar() {
        try {
            this.propriedadeSelecionado.setDataCadastro(new Date());

            this.propriedadeRP.salvar(this.propriedadeSelecionado);
            
            setPropriedadeSelecionado(new Propriedade());

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns", "Propriedade ADICIONADA com sucesso!!"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao inserir a Propriedade: " + e));
        }
    }

    /**
     * FUNCIONANDO
     */
    public void remover() {
        try {
            if (this.propriedadeSelecionado.getId() != null) {

                this.propriedadeRP.remover(getPropriedadeSelecionado().getId());

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "REMOVIDO", "Propriedade REMOVIDO com sucesso"));

                this.propriedadeSelecionado = new Propriedade();

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao REMOVER o Propriedade: ID: " + this.propriedadeSelecionado.getId()));
            }
        } catch (ExceptionInInitializerError e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao REMOVER o Propriedade: ID: " + this.propriedadeSelecionado.getId() + " : " + e));
        } catch (RollbackException ro) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao REMOVER o Propriedade: ID: " + this.propriedadeSelecionado.getId() + " possui dependencias: " + ro));
        }

    }

    public void novo() {
        setPropriedadeSelecionado(new Propriedade());
    }

    public void buscarPorNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void buscarPorCodigo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //gets e sets
    public PropriedadeRP getPropriedadeRP() {
        return propriedadeRP;
    }

    public void setPropriedadeRP(PropriedadeRP propriedadeRP) {
        this.propriedadeRP = propriedadeRP;
    }

    public Propriedade getPropriedadeSelecionado() {
        return propriedadeSelecionado;
    }

    public void setPropriedadeSelecionado(Propriedade propriedadeSelecionado) {
        this.propriedadeSelecionado = propriedadeSelecionado;
    }

    /**
     * @return Lista de Propriedades
     */
    public List<Propriedade> getListaPropri() {
        return listaPropri = propriedadeRP.getTodos();
    }
}
