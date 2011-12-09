/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Animal;
import br.com.jean.faculdade.projeto.model.Propriedade;
import br.com.jean.faculdade.projeto.model.Vacina;
import br.com.jean.faculdade.projeto.repositorio.AnimalRP;
import java.util.ArrayList;
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
public class AnimailMB{

    private Animal animalSelecionado;
    private AnimalRP animalRP;
    
    //lista de todos os animais
    private List<Animal> listaAnimais;
     
    //PropriedadeMB propriMB;
    
    public AnimailMB() {
        this.animalRP = new AnimalRP();
        this.animalSelecionado = new Animal();
        this.animalSelecionado.setPropriedade(new Propriedade()); 
        
        this.listaAnimais = new ArrayList<Animal>();
    }

  
    public void salvar() {
        try {
            
            this.animalSelecionado.setDataCadastro(new Date());
            
            this.animalRP.salvar(animalSelecionado);
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns", "Animal cadastrado com sucesso!!"));
            
            setAnimalSelecionado(new Animal());
            
            //atualizando a lista
            this.listaAnimais = getListaAnimais();
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao inserir o Animal: "+e ));
        }
    }
    
  
    public void remover() {
        try {
            this.animalRP.remover(this.animalSelecionado.getId());
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns", "Animal REMOVIDO com sucesso!!"));
            
            setAnimalSelecionado(new Animal());
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao REMOVER o Animal: "+e ));
        }
    }
    
    public void novo(){
        setAnimalSelecionado(new Animal());
    }

    
    public void buscarPorNome(String nome) {
        this.animalSelecionado = animalRP.getPorNome(nome);
    }

    
    public void buscarPorCodigo() {
        this.animalSelecionado = animalRP.getPorCodigo(this.animalSelecionado.getId());
    }
 
    
    
    //gets e sets
    public AnimalRP getAnimalRP() {
        return animalRP;
    }

    public void setAnimalRP(AnimalRP animalRP) {
        this.animalRP = animalRP;
    }

    public Animal getAnimalSelecionado() {
        return animalSelecionado;
    }

    public void setAnimalSelecionado(Animal animalSelecionado) {
        this.animalSelecionado = animalSelecionado;
    }

    //busca todos os animais
    public List<Animal> getListaAnimais() {
        return listaAnimais = animalRP.getTodos();
    }

    public void setListaAnimais(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }

    
}
