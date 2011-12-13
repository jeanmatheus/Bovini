/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

import br.com.jean.faculdade.projeto.model.Propriedade;
import br.com.jean.faculdade.projeto.repositorio.PropriedadeRP;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author adml01
 */
public class PropriedadeTest {

    Propriedade pro;
    PropriedadeRP proRP;
    
    @Before
    public void PropriedadeTest() {
        pro = new Propriedade();
        proRP = new PropriedadeRP();
    } 
    
    @Test
    public void inserirPropriedade(){
        //REFAZER TESTE DE INSERÇÃO DE PROPRIEDADE
    }
    
    
    @Test
    public void removerTest(){ 
       //FAZER TESTE DE REMOÇÃO
    }
    
}
