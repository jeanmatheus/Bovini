/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.repositorio;

import br.com.jean.faculdade.projeto.model.Vacina;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jean Matheus
 */
public class VacinaRP extends GenericRP<Vacina> {
    
    /**
     * Busca as vacinas por  animal
     * @param codigoAnimal
     * @return 
     */
    public List<Vacina> buscaVacinasPorAnimal(Long codigoAnimal) {

        List<Vacina> listaVacinaPorAnimal = new ArrayList<Vacina>();

        //logica pra buscar as vacinas
        String sql = " select v from Vacina v where v.animal = " + codigoAnimal;

        //pegando a lista de resultados
        listaVacinaPorAnimal = JPAUtil.getEm().createQuery(sql).getResultList();

        return listaVacinaPorAnimal;
    }
}
