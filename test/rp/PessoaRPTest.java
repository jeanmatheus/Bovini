/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

import br.com.jean.faculdade.projeto.model.Cidade;
import br.com.jean.faculdade.projeto.model.Endereco;
import br.com.jean.faculdade.projeto.model.Pais;
import br.com.jean.faculdade.projeto.model.Pessoa;
import br.com.jean.faculdade.projeto.model.Uf;
import br.com.jean.faculdade.projeto.repositorio.CidadeRP;
import br.com.jean.faculdade.projeto.repositorio.EnderecoRP;
import br.com.jean.faculdade.projeto.repositorio.PaisRP;
import br.com.jean.faculdade.projeto.repositorio.PessoaRP;
import br.com.jean.faculdade.projeto.repositorio.UfRP;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author adml01
 */
public class PessoaRPTest {
   
    /*
    @Test
    public void insere10Test(){
        PessoaRP r = new PessoaRP();
        
        for(int i = 0; i< 10;i++){
            Pessoa p = new Pessoa();
            p.setDataCadastro(new Date());
            p.setEmail("email"+i);
            p.setNome("nome"+i);
            
            r.salvar(p);
        }
    }
     */
    
    @Test
    public void addAdmin(){
     Pessoa p = new Pessoa();
     String senha = "admin";
     p.setCpf(123456789l);
     p.setDataCadastro(new Date());
     p.setEmail("admin@admin.com.br");
     p.setNome("admin");
     p.setSenha(senha.hashCode());
     
     Pais pais = new Pais();
     pais.setNome("Brasil");
     
     PaisRP rpPais = new PaisRP();
     
     rpPais.salvar(pais);
     
     Uf uf = new Uf();
     uf.setNome("Santa Catarina");
     uf.setPais(rpPais.getPorNome("Brasil"));
     uf.setSigla("SC");
     
     UfRP rpUF = new UfRP();
     rpUF.salvar(uf);
     
     Cidade ci = new Cidade();
     ci.setCep(89820000l);
     ci.setNome("Xanxere");
     ci.setUf(rpUF.getPorNome("Santa Catarina"));
     
     CidadeRP rpCidade = new CidadeRP();
     rpCidade.salvar(ci);
     
     Endereco r = new Endereco();
     r.setNumero(123);
     r.setRua("rua do endereço");
     r.setCidade(rpCidade.getPorNome("Xanxere"));
     
     EnderecoRP rpEndereco = new EnderecoRP();
     rpEndereco.salvar(r);
     
     p.setEndereco(r);
     
     PessoaRP  rpPessoa = new PessoaRP();
     rpPessoa.salvar(p);
    }
    
    @Test
    public void buscaTodosTest(){
        PessoaRP rp = new PessoaRP();
        //System.out.println("teste2");
        
        List<Pessoa> lista = new ArrayList<Pessoa>();
        
        lista.addAll(rp.getTodos());
        
        for (Pessoa pessoa : lista) {
            System.out.println(""+pessoa.toString());
        }
    }
    

}
