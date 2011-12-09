/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.repositorio;

import br.com.jean.faculdade.projeto.model.Desverminacao;
import java.util.*;
/**
 *
 * @author Jean Matheus
 */
public class DesverminacaoRP  extends  GenericRP<Desverminacao> {
    
    public List<Desverminacao> buscaVacinasPorAnimal(Long codigoAnimal) {

        List<Desverminacao> listaDesverminacaoPorAnimal = new ArrayList<Desverminacao>();

        //logica pra buscar as vacinas
        String sql = " select d from Desverminaca d where d.animal = " + codigoAnimal;

        //pegando a lista de resultados
        listaDesverminacaoPorAnimal = JPAUtil.getEm().createQuery(sql).getResultList();

        return listaDesverminacaoPorAnimal;
    }
}
