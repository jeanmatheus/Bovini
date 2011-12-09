package br.com.jean.faculdade.projeto.repositorio;

import br.com.jean.faculdade.projeto.model.GenericModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 
 * Classe GENERIC DAO, onde é criado todos os metodos de transação com o banco
 * 
 * 
 * USANDO POLIMORFISMO
 * 
 *                                CLASSE MUITO FODONA
 * 
 *                              CLASSE MUITO IMPORTANTE
 * 
 * 
 * 
 * @author jeanmatheus
 * T = é do tipo de genericmodel
 * T = é do tipo Genericmodel, mas não eh um GenericModel
 * 
 */
public class GenericRP<T extends GenericModel> {

    //atributo para descobrir que tipo de classe está sendo vinculado ao genericModel
    //T = tipo generico da classe dao
    private Class<T> modelClazz;

    /**
     * Via Reflexão, indo na declaração da classe, e pegando qual a classe que implentou
     * e buscando os argumentos, que estao dentro do <>, e guarda no Type,
     * e faz a busca no vetor types, por posição pela qtd de argumentos
     * @return 
     */
    public Class<T> getModelClazz() {
        if (this.modelClazz == null) {
            Type[] types = ((ParameterizedType) getClass().
                    getGenericSuperclass()).getActualTypeArguments();
            return this.modelClazz = (Class<T>) types [types.length > 1 ? 1 : 0];
        }else{
            return this.modelClazz;
        }
        
    }
    
    /**
     * Metodo para Salvar/Editar um Generic model
     * recebe um Generic, e ae sim usa o metodo salvar
     * ou editar caso o getcodigo, for diferente de null
     * @param model 
     */
    public void salvar(T model) {
        if (model.getId() == null) {
            inserir(model);
        } else {
            editar(model);
        }
    }

    private void inserir(T model) {
        //abrindo a transação com o banco
        JPAUtil.getEm().getTransaction().begin();
        //fazendo o inserção no banco na tabela 
        JPAUtil.getEm().persist(model);
        //fazendo o commi no banco
        JPAUtil.getEm().getTransaction().commit();
        //fechando a conexao
        JPAUtil.getEm().close();
    }

    public void editar(T model) {
        //abrindo a transação com o banco
        JPAUtil.getEm().getTransaction().begin();
        //fazendo o update no banco na tabela 
        JPAUtil.getEm().merge(model);
        //fazendo o commi no banco
        JPAUtil.getEm().getTransaction().commit();
        //fechando a conexao
        JPAUtil.getEm().close();
    }

    public void remover(Long codigo) {

        //abrindo a transação com o banco
        JPAUtil.getEm().getTransaction().begin();

        //      IMPORTANTE
        //como não quero o objeto inteiro, eu uso o getReference
        //trazendo somente o ID, faz uma referencia o objeto com o id desejado
        T model = JPAUtil.getEm().getReference(getModelClazz(), codigo);

        //      IMPORTANTE
        //executando o remove
        JPAUtil.getEm().remove(model);

        //fazendo o commit no banco
        JPAUtil.getEm().getTransaction().commit();

        //fechando a conexao
        JPAUtil.getEm().close();
    }

    public T getPorCodigo(Long codigo) {

        //busca o objeto pelo ID
        return JPAUtil.getEm().find(getModelClazz(), codigo);

    }
    
    /**
     * BUsca todos os objetos no banco apartir do modelClazz
     * getSimpleName = pega o nome somente da classe
     * @return 
     */
    public List<T> getTodos(){
        return JPAUtil.getEm().createQuery("select o from " +getModelClazz().getSimpleName()+" o").
                                            getResultList();
    }
    
    /**
     * Busca por nome 
     * @param nomeP
     * @return 
     */
    public T getPorNome(String nomeP){
        System.out.println("classe: " + getModelClazz().getSimpleName());
        return (T) JPAUtil.getEm().createQuery("select o from " +getModelClazz().getSimpleName()
              +" o where o.nome = '"+nomeP+"'").getSingleResult();
    }
}
