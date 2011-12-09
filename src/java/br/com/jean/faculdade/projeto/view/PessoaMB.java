/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.model.Pessoa;
import br.com.jean.faculdade.projeto.repositorio.PessoaRP;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

/**
 *
 * @author adml01
 */
@ManagedBean
@SessionScoped
public class PessoaMB {

    private Pessoa pessoaSelecionada;
    private List<Pessoa> listaPessoas;
    private PessoaRP pessoaRP;
    private String senha1;
    private String senha2;
    private String userLogin;
    private String senhaLogin;

    public PessoaMB() {
        this.pessoaRP = new PessoaRP();
        this.pessoaSelecionada = new Pessoa();
        this.listaPessoas = new ArrayList<Pessoa>();
    }

    public String salvar() {
        String retorno = "#";
        try {
            if (validaSenha()) {
                //hash da senha
                this.getPessoaSelecionada().setSenha(this.senha1.hashCode());
                //data cadastro
                this.getPessoaSelecionada().setDataCadastro(new Date());

                this.pessoaRP.salvar(pessoaSelecionada);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns", "Você é nosso novo usuário!!"));
                setPessoaSelecionada(new Pessoa());

                retorno = "xhtml/index.xhtml";

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha Incorretas", "Suas senhas foram digitadas diferentes"));
            }

        } catch (ExceptionInInitializerError e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Ocorreu um erro ao tentar efetivar seu cadastro, nosso equipe já está analizando a situação: " + e));
        } catch (EntityExistsException cp) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Este NOME já está cadastrado em nossa base de dados"));
        }

        return retorno;
    }

    public boolean validaSenha() {
        boolean valida = false;
        if (senha1.equals(senha2)) {
            valida = true;
        } else {
            valida = false;
        }

        return valida;
    }

    public String logar() {
        String retorno = "#";

        try {
            Pessoa p = new Pessoa();
            
            //busca usuario no banco
            p = pessoaRP.getPorNome(userLogin);
            
            if (p.getSenha().equals(senhaLogin.hashCode())) {
                retorno = "componentes/bem-vindo.xhtml";

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo " + p.getNome(), "Bom trabalho"));

                setPessoaSelecionada(p);
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no Login " + p.getNome().toUpperCase(), "Usuário ou senha incorretos"));
            }

        } catch (ExceptionInInitializerError e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no Login", "EXCEPTION: "+e));
        } catch(NoResultException noResu){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no Login", "Usuário não encontrado na base de dados"));
        }

        return retorno;
    }

    public void logout() {
        setPessoaSelecionada(new Pessoa());
    }

    //buscando todos as lista de pessoas
    public List<Pessoa> getListaPessoas() {
        return listaPessoas = this.pessoaRP.getTodos();
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

    public PessoaRP getPessoaRP() {
        return pessoaRP;
    }

    public void setPessoaRP(PessoaRP pessoaRP) {
        this.pessoaRP = pessoaRP;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    public String getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(String senhaLogin) {
        this.senhaLogin = senhaLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
