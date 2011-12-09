/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Pais;
import br.com.jean.faculdade.projeto.repositorio.PaisRP;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jeanmatheus
 */
@ManagedBean
@SessionScoped
public class PaisMB {

    private Pais paisSelecionado;
    private PaisRP paisDAO;

    public PaisMB() {
        this.paisDAO = new PaisRP();
        this.paisSelecionado = new Pais();
    }

    
    public void salvar() {
        paisDAO.salvar(paisSelecionado);
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

    public Pais getPaisSelecionado() {
        return paisSelecionado;
    }

    public void setPaisSelecionado(Pais paisSelecionado) {
        this.paisSelecionado = paisSelecionado;
    }

    public PaisRP getPaisDAO() {
        return paisDAO;
    }

    public void setPaisDAO(PaisRP paisDAO) {
        this.paisDAO = paisDAO;
    }
}
