/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.CicloReprodutivo;
import br.com.jean.faculdade.projeto.repositorio.CicloReprodutivoRP;
import java.util.ArrayList;
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
public class CicloReprodutivoMB{

    private CicloReprodutivo cicloReproSelecionado;
    private CicloReprodutivoRP cicloReproRP;
    
    //lista de animais qeu podem ter ciclo reprodutivo
    private List<CicloReprodutivo> listaAnimaisCicloReprodutivo;

    public CicloReprodutivoMB() {
        this.cicloReproSelecionado = new CicloReprodutivo();
        this.cicloReproRP = new CicloReprodutivoRP();
        
        this.listaAnimaisCicloReprodutivo = new ArrayList<CicloReprodutivo>();
    }
     
    
    public void salvar() {
        try {
            if(this.cicloReproSelecionado.getAnimal() != null){
                
                this.cicloReproRP.salvar(cicloReproSelecionado);
                
                setCicloReproSelecionado(new CicloReprodutivo());
                
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Novo ciclo reprodutivo agendado "
                                + "com SUCESSO"));
                
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "ID do animal nulo"));
            }
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Problema ao setar o Ciclo "
                    + "Reprodutivo do Animal: " + e));
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
     * Busca os ciclos reprodutivos dos animais
     * @return 
     */
    public List<CicloReprodutivo> getListaAnimaisCicloReprodutivo() {
        return listaAnimaisCicloReprodutivo = this.cicloReproRP.getTodos();
    }

    
    //gets e sets
    public CicloReprodutivoRP getCicloReproRP() {
        return cicloReproRP;
    }

    public void setCicloReproRP(CicloReprodutivoRP cicloReproRP) {
        this.cicloReproRP = cicloReproRP;
    }

    public CicloReprodutivo getCicloReproSelecionado() {
        return cicloReproSelecionado;
    }

    public void setCicloReproSelecionado(CicloReprodutivo cicloReproSelecionado) {
        this.cicloReproSelecionado = cicloReproSelecionado;
    }
   
}
