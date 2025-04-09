package br.com.rasmo.restaurante.dao;

import br.com.rasmo.restaurante.entity.Endereco;
import br.com.rasmo.restaurante.entity.Ordem;

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

    public void atualizar(Endereco endereco){
        this.entityManager.merge(endereco);
    }

    public void remover(Endereco endereco){
        this.entityManager.remove(endereco);
    }
}
