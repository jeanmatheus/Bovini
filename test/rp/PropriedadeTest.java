/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

import br.com.jean.faculdade.projeto.model.Propriedade;
import br.com.jean.faculdade.projeto.repositorio.PropriedadeRP;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author adml01
 */
public class PropriedadeTest {
    
    @Test
    public void inserirPropriedade(){
        
        PropriedadeRP rp = new PropriedadeRP();
        
        for(int i = 0; i < 5; i++){
            Propriedade p = new Propriedade();
            p.setBlocoProdutor(Long.valueOf(123 * i));
            p.setComplemento("TESTES "+i);
            p.setNome("TESTE NOME "+i+1*3);
            p.setNomeFantasia("TESTE NOME FANTASIA "+i*2);
            p.setDataCadastro(new Date());
            
            rp.salvar(p);
        }
    }
    
    /*
    @Test
    public void removerTest(){
        PropriedadeRP rp = new PropriedadeRP();
        
        rp.remover(10l);
        
    }
    */
}
