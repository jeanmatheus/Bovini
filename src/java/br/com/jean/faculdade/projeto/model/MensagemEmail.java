/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.model;

/**
 *
 * @author Jean Matheus
 */
public class MensagemEmail {

    private String nome;
    private String mensagem;
    private String remetente;
    private String titulo;

    public MensagemEmail() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
