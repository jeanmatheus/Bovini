/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.repositorio;

import br.com.jean.faculdade.projeto.model.CicloReprodutivo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jean Matheus
 */
public class CicloReprodutivoRP extends GenericRP<CicloReprodutivo> {
    
    public List<CicloReprodutivo> buscaCicloReprodutivoPorAnimal(Long codigoAnimal) {

        List<CicloReprodutivo> listaCicloReprodutivoPorAnimal = new ArrayList<CicloReprodutivo>();

        //logica pra buscar as vacinas
        String sql = " select ci from CicloReprodutivo ci where ci.animal = " + codigoAnimal +" and ci.animal.sexo = 'F'";

        //pegando a lista de resultados
        listaCicloReprodutivoPorAnimal = JPAUtil.getEm().createQuery(sql).getResultList();

        return listaCicloReprodutivoPorAnimal;
    }
}
