/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Endereco;
import br.com.jean.faculdade.projeto.repositorio.EnderecoRP;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jean Matheus
 */
@ManagedBean
@SessionScoped
public class EnderecoMB {

    private Endereco enderecoSelecionado;
    private EnderecoRP enderecoRP;

    public EnderecoMB() {
        this.enderecoSelecionado = new Endereco();
        this.enderecoRP = new EnderecoRP();
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

    public EnderecoRP getEnderecoRP() {
        return enderecoRP;
    }

    public void setEnderecoRP(EnderecoRP enderecoRP) {
        this.enderecoRP = enderecoRP;
    }

    public Endereco getEnderecoSelecionado() {
        return enderecoSelecionado;
    }

    public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
        this.enderecoSelecionado = enderecoSelecionado;
    }
        
}
