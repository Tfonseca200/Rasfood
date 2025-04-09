package br.com.rasmo.restaurante.dao;

import br.com.rasmo.restaurante.entity.Endereco;
import br.com.rasmo.restaurante.entity.Ordem;
import br.com.rasmo.restaurante.vo.ClienteVo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {

    private EntityManager entityManager;

    public EnderecoDao (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Endereco endereco){
        this.entityManager.persist(endereco);
    }

    public Endereco consultaPorId(Integer id){
        return this.entityManager.find(Endereco.class, id);
    }

    public List<Endereco> consultaTodos(){
        String jpql = "SELECT endereco FROM Endereco endereco";
        return this.entityManager.createQuery(jpql, Endereco.class).getResultList();
    }


    // Consulta dinamica com cidade e rua //
    public List<ClienteVo> consultaClientes(String cidade, String rua){
        String jpql = "SELECT new br.com.rasmo.restaurante.vo.ClienteVo(e.cliente.cpf, e.cliente.nome) FROM Endereco e " +
                "WHERE UPPER(e.cidade) = UPPER(:cidade) AND UPPER(e.rua) = UPPER(:rua) ";
    return this.entityManager.createQuery(jpql, ClienteVo.class)
            .setParameter("cidade", cidade).setParameter("rua", rua).getResultList();
    }

    public void atualizar(Endereco endereco){
        this.entityManager.merge(endereco);
    }

    public void remover(Endereco endereco){
        this.entityManager.remove(endereco);
    }
}
