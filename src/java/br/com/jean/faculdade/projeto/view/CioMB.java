/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Cio;
import br.com.jean.faculdade.projeto.repositorio.CioRP;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jean Matheus
 */
@ManagedBean
@SessionScoped
public class CioMB{

    private Cio cioSelecionado;
    private CioRP cioRP;

    public CioMB() {
        this.cioSelecionado = new Cio();
        this.cioRP = new CioRP();
    }
    
    
    public void salvar() {
        throw new UnsupportedOperationException("Not supported yet.");
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

    public CioRP getCioRP() {
        return cioRP;
    }

    public void setCioRP(CioRP cioRP) {
        this.cioRP = cioRP;
    }

    public Cio getCioSelecionado() {
        return cioSelecionado;
    }

    public void setCioSelecionado(Cio cioSelecionado) {
        this.cioSelecionado = cioSelecionado;
    }
}
