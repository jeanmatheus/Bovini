/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import br.com.jean.faculdade.projeto.controller.EmailController;
import br.com.jean.faculdade.projeto.model.MensagemEmail;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Jean Matheus
 */
@ManagedBean
public class EmailMB {

    private MensagemEmail mensagem;

    public EmailMB() {
        this.mensagem = new MensagemEmail();
    }

    public void enviaEmail() {
        try {
            EmailController.enviaEmail(mensagem);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Email enviado com Sucesso!!", "Sucesso"));
            
        } catch (EmailException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro! Occoreu um erro ao enviar a mensagem.", "Erro"));
        }
    }

    public void limpaCampos() {
        mensagem = new MensagemEmail();
    }

    public MensagemEmail getMensagem() {
        return mensagem;
    }

    public void setMensagem(MensagemEmail mensagem) {
        this.mensagem = mensagem;
    }
}
