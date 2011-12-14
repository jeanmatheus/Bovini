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
import org.junit.Before;
import org.junit.Test;

public class PessoaRPTest {

    Pessoa pessoa;
    PessoaRP pessoaRP;

    @Before
    public void pessoaTest() {
        pessoa = new Pessoa();
        pessoaRP = new PessoaRP();
    }

    @Test
    public void addAdmin() {

        if (pessoaRP.getPorNome("admin") == null) {

            String senha = "admin";
            pessoa.setCpf(123456789l);
            pessoa.setDataCadastro(new Date());
            pessoa.setEmail("admin@admin.com.br");
            pessoa.setNome("admin");
            pessoa.setSenha(senha.hashCode());

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

            pessoa.setEndereco(r);

            pessoaRP.salvar(pessoa);


        }
        
        Assert.assertEquals("admin", pessoaRP.getPorNome("admin").getNome());
    }

    @Test
    public void buscaTodosTest() {
        PessoaRP rp = new PessoaRP();
        //System.out.println("teste2");

        List<Pessoa> lista = new ArrayList<Pessoa>();

        lista.addAll(rp.getTodos());

        for (Pessoa pes : lista) {
            System.out.println("" + pes.toString());
        }
    }
}
