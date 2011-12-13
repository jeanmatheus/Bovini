/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;


import br.com.jean.faculdade.projeto.model.Animal;
import br.com.jean.faculdade.projeto.model.Vacina;
import br.com.jean.faculdade.projeto.repositorio.AnimalRP;
import br.com.jean.faculdade.projeto.repositorio.VacinaRP;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author adml01
 */
public class AnimailTest {
    
    @Test
    public void insereAnimais(){
        AnimalRP rp = new AnimalRP();
        
        for(int i = 0; i < 10 ; i++){
            Animal a = new Animal();
            
            a.setCategoria("Bezerro");
            a.setDataCadastro(new Date());
            a.setNome("NOME ANIMAL "+i);
            a.setNomeMae("NOME MAE "+i);
            a.setNomePai("NOME PAI "+i);
            a.setNumeroControle(i);
            a.setSexo("M");
            
            
            rp.salvar(a);
        
            Assert.assertNotNull(a);
        }
        
    }
    
    
    @Test
    public void buscaVacinas(){
        VacinaRP rp = new VacinaRP();
        
        List<Vacina> porAnimal = new ArrayList<Vacina>();
        
        porAnimal = rp.buscaVacinasPorAnimal(2l);
        
        if(porAnimal == null){
            System.out.println("null");
        }else
            for(Vacina va : porAnimal){
                System.out.println(va.toString());
            }
    }
    
}
