/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Cidade;
import br.com.jean.faculdade.projeto.repositorio.CidadeRP;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jean Matheus
 */
@ManagedBean
@SessionScoped
public class CidadeMB{
    
    private Cidade cidadeSelecionada;
    private CidadeRP cidadeRP;
    private List<Cidade> listaCidade;

    public CidadeMB() {
        this.cidadeSelecionada = new Cidade();
        this.cidadeRP = new CidadeRP();
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

    public CidadeRP getCidadeRP() {
        return cidadeRP;
    }

    public void setCidadeRP(CidadeRP cidadeRP) {
        this.cidadeRP = cidadeRP;
    }

    public Cidade getCidadeSelecionada() {
        return cidadeSelecionada;
    }

    public void setCidadeSelecionada(Cidade cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
    }

    public List<Cidade> getListaCidade() {
        return listaCidade = cidadeRP.getTodos();
    }

    
}
