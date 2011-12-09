/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.repositorio;

import java.util.List;
import br.com.jean.faculdade.projeto.model.Pessoa;
import br.com.jean.faculdade.projeto.model.Propriedade;

/**
 *
 * @author Jean Matheus
 */
public class PropriedadeRP extends GenericRP<Propriedade> {
    
    public List<Pessoa> buscaListaPessoaPorPropriedade(Long idPropriedade){
        String query = "select p from "+getModelClazz().getSimpleName() +
                " p where p.pessoas.id = "+idPropriedade;
        return JPAUtil.getEm().createQuery(query).getResultList();
    }
    
}
