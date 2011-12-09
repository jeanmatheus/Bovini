/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Vacina;
import br.com.jean.faculdade.projeto.repositorio.VacinaRP;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jean Matheus
 */
@ManagedBean
@SessionScoped
public class VacinaMB {

    private Vacina vacinaSelecionado;
    private VacinaRP vacinaRP;
    //auxiliar para validae
    private int validadeMeses;
    //lista de vacina por animal
    private List<Vacina> listaVacinaPorAnimal;
    
    //lista de todos os animais vacinados
    private List<Vacina> listaTodosAnimaisVacinados;

    public VacinaMB() {
        this.vacinaSelecionado = new Vacina();
        this.vacinaRP = new VacinaRP();

        //inicia lista vacina por animal
        this.listaVacinaPorAnimal = new ArrayList<Vacina>();
        this.listaTodosAnimaisVacinados = this.vacinaRP.getTodos();
    }

    public void salvar() {

        try {

            if (this.vacinaSelecionado.getAnimal() != null) {
                
                this.vacinaSelecionado.setValidade(calculaValidade());

                this.vacinaRP.salvar(vacinaSelecionado);

                setVacinaSelecionado(new Vacina());

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Animal VACINADO com SUCESSO"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao VACINAR o Animal, id: "+this.vacinaSelecionado.getAnimal().getId()));
            }


        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao VACINAR o Animal: " + e));
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
     * Calcula a validade da vacina Apartir da data de vacinação
     * soma a quantidade de meses informado
     * @return 
     */
    public Date calculaValidade() {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(this.vacinaSelecionado.getDataVacinacao());
        calendar.add(Calendar.MONTH, validadeMeses);

        return calendar.getTime();
    }

    /**
     * BUSCA TODAS AS VACINAS POR ANIMAL
     * @return 
     */
    public List<Vacina> getListaVacinaPorAnimal() {
        if(this.vacinaSelecionado.getAnimal() != null){
            return listaVacinaPorAnimal = this.vacinaRP.buscaVacinasPorAnimal(this.vacinaSelecionado.getAnimal().getId());
        }else{
            return listaVacinaPorAnimal = this.vacinaRP.getTodos();
        }
        
    }

    /**
     * BUSCA TODOS OS ANIMAIS VACINADOS
     * @return 
     */
    public List<Vacina> getListaTodosAnimaisVacinados() {
        return listaTodosAnimaisVacinados = this.vacinaRP.getTodos();
    }
    
    

    //gets e sets
    public VacinaRP getVacinaRP() {
        return vacinaRP;
    }

    public void setVacinaRP(VacinaRP vacinaRP) {
        this.vacinaRP = vacinaRP;
    }

    public Vacina getVacinaSelecionado() {
        return vacinaSelecionado;
    }

    public void setVacinaSelecionado(Vacina vacinaSelecionado) {
        this.vacinaSelecionado = vacinaSelecionado;
    }

    public int getValidadeMeses() {
        return validadeMeses;
    }

    public void setValidadeMeses(int validadeMeses) {
        this.validadeMeses = validadeMeses;
    }
}
