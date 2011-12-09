/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Uf;
import br.com.jean.faculdade.projeto.repositorio.UfRP;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author Jean Matheus
 */
@ManagedBean
@RequestScoped
public class UfMB {

    private Uf ufSelecionado;
    private UfRP ufRP;
    private List<Uf> listaUfs;

    public UfMB() {
        this.ufSelecionado = new Uf();
        this.ufRP = new UfRP();
        this.listaUfs = new ArrayList<Uf>();
    }

   
    public void salvar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public void remover() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    public void buscarPorNome() {
        
    }

    
    public void buscarPorCodigo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public void novo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public UfRP getUfRP() {
        return ufRP;
    }

    public void setUfRP(UfRP ufRP) {
        this.ufRP = ufRP;
    }

    public Uf getUfSelecionado() {
        return ufSelecionado;
    }

    public void setUfSelecionado(Uf ufSelecionado) {
        this.ufSelecionado = ufSelecionado;
    }

    public List<Uf> getListaUfs() {
        return listaUfs = this.ufRP.getTodos();
    }
    
    

}
