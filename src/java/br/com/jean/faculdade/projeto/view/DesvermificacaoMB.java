/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Desverminacao;
import br.com.jean.faculdade.projeto.repositorio.DesverminacaoRP;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jean Matheus
 */
@ManagedBean
@SessionScoped
public class DesvermificacaoMB {

    private Desverminacao desvermificacaoSelecionado;
    private DesverminacaoRP desvermificacaoRP;
    //validade da desverminação
    private int validadeDesAux;
    //lista de animais desesvemificados
    private List<Desverminacao> listaAnimaisDesverminados;
    //busca as deverminaçoes de tal animal
    private List<Desverminacao> listaDeserveminacaoPorAnimal;

    public DesvermificacaoMB() {
        this.desvermificacaoSelecionado = new Desverminacao();
        this.desvermificacaoRP = new DesverminacaoRP();

        //todos os animais que tem deseveminacao
        this.listaAnimaisDesverminados = new ArrayList<Desverminacao>();

        //desveminação por animal
        this.listaDeserveminacaoPorAnimal = new ArrayList<Desverminacao>();
    }

    public void salvar() {
        try {
            if(this.desvermificacaoSelecionado.getAnimal() != null){
                
                this.desvermificacaoSelecionado.setValidadeDes(calculaValidade());
                
                this.desvermificacaoRP.salvar(desvermificacaoSelecionado);
                
                setDesvermificacaoSelecionado(new Desverminacao());
                
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Animal Desverminado com SUCESSO"));
                
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao VACINAR o Animal, id: "+this.desvermificacaoSelecionado.getAnimal().getId()));
            }
        } catch (Exception e) {
        }
    }

    public void remover() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void buscarPorNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void buscarPorCodigo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void novo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Busca todos os animais deverminados
     * @return 
     */
    public List<Desverminacao> getListaAnimaisDesverminados() {
        return listaAnimaisDesverminados = this.desvermificacaoRP.getTodos();
    }

    /**
     * Busca todos as desverminações de tal animal
     * se getAnimal for diferente de null carrega so as do animais
     * se nao traz todas
     * @return 
     */
    public List<Desverminacao> getListaDeserveminacaoPorAnimal() {

        if (this.desvermificacaoSelecionado.getAnimal() != null) {
             return this.listaDeserveminacaoPorAnimal = this.desvermificacaoRP.buscaVacinasPorAnimal(this.desvermificacaoSelecionado.getAnimal().getId());

        } else {
            return this.listaAnimaisDesverminados = this.desvermificacaoRP.getTodos();
        }

    }
    
    public Date calculaValidade(){
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(this.desvermificacaoSelecionado.getDataDesvermificacao());
        calendar.add(Calendar.MONTH, validadeDesAux);

        return calendar.getTime();
    }

    //gets e sets
    public DesverminacaoRP getDesvermificacaoRP() {
        return desvermificacaoRP;
    }

    public void setDesvermificacaoRP(DesverminacaoRP desvermificacaoRP) {
        this.desvermificacaoRP = desvermificacaoRP;
    }

    public Desverminacao getDesvermificacaoSelecionado() {
        return desvermificacaoSelecionado;
    }

    public void setDesvermificacaoSelecionado(Desverminacao desvermificacaoSelecionado) {
        this.desvermificacaoSelecionado = desvermificacaoSelecionado;
    }

    public int getValidadeDes() {
        return validadeDesAux;
    }

    public void setValidadeDes(int validadeDesAux) {
        this.validadeDesAux = validadeDesAux;
    }
}
