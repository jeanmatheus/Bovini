/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

import br.com.jean.faculdade.projeto.model.CicloReprodutivo;
import br.com.jean.faculdade.projeto.repositorio.CicloReprodutivoRP;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Jean Matheus
 */
public class CicloReprodutivoTeste {

    @Test
    public void buscaCiclos() {
        List<CicloReprodutivo> lis = new ArrayList<CicloReprodutivo>();
        CicloReprodutivoRP rp = new CicloReprodutivoRP();
        
        lis = rp.buscaCicloReprodutivoPorAnimal(11l);
        
        System.out.println("tamanho: "+lis.size());
    }
}
