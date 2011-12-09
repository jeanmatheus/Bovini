/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

import br.com.jean.faculdade.projeto.model.Vacina;
import br.com.jean.faculdade.projeto.repositorio.VacinaRP;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author adml01
 */
public class VacinaTeste {

    @Test
    public void buscaVacinas() {
        VacinaRP rp = new VacinaRP();

        List<Vacina> porAnimal = new ArrayList<Vacina>();

        porAnimal = rp.buscaVacinasPorAnimal(2l);

        if (porAnimal == null) {
            System.out.println("null");
        } else {
            for (Vacina va : porAnimal) {
                System.out.println(va.toString());
            }
        }
    }
}
