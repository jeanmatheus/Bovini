/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suiteTeste;


import jpautil.JPAUtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import rp.AnimailTest;
import rp.CicloReprodutivoTeste;
import rp.PessoaRPTest;
import rp.PropriedadeTest;
import rp.VacinaTeste;

/**
 *  SUITE DE TESTES
 *  ESSA CLASSE CHAMA TODAS AS CLASSE QUE ESTÃO NA ANOTAÇÃO E 
 *  REALIZA CADA TESTE CONTIDO EM CADA CLASSE
 * 
 *  ENTAO SO É PRECISO EXECUTAR ESSA CLASSE QUE TODAS AS OUTRA IRÃO 
 *  SER CHAMADAS AUTOMATICAMENTE
 *  
 * @author jeanmatheus
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JPAUtilTest.class,
                    AnimailTest.class,
                    CicloReprodutivoTeste.class,
                    PessoaRPTest.class,
                    PropriedadeTest.class,
                    VacinaTeste.class
})
public class SuiteTeste {

}
