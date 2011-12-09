/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.controller;

import br.com.jean.faculdade.projeto.model.MensagemEmail;
import br.com.jean.faculdade.projeto.view.EmailMB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Jean Matheus
 */
public class EmailController {

    private static final String HOSTNAME = "smtp.gmail.com";
    private static final String USERNAME = "jeanmatheusouto";
    private static final String PASSWORD = "camilalove123";
    private static final String EMAILORIGEM = "jeanmatheusouto@gmail.com";

    public static Email conectaEmail() throws EmailException {

        Email email = new SimpleEmail();

        email.setHostName(HOSTNAME);
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
        email.setTLS(true);
        email.setFrom(EMAILORIGEM);

        return email;
    }

    public static void enviaEmail(MensagemEmail mensagem) throws EmailException {
        Email email = new SimpleEmail();
        String destino = "jeanmatheussouto@gmail.com"; 
        
        email = conectaEmail();
        email.setSubject(mensagem.getTitulo());
        email.setMsg(mensagem.getMensagem());
        email.addTo(destino);
        String resposta = email.send();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "E-mail enviado com sucesso para: " + destino, "Informação"));
    }
}
