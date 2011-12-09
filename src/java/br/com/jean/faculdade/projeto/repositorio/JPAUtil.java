/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jeanmatheus
 */
public class JPAUtil {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    static {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ProjetoSoftwareLeiteiroPU");
        }
    }
    
    public static EntityManager getEm(){
        if (em == null || ! em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }
}
