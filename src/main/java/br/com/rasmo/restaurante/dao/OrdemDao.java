package br.com.rasmo.restaurante.dao;

import javax.persistence.EntityManager;
import java.util.List;

public class Ordem {

    private EntityManager entityManager;

    public Ordem(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(Ordem ordem){
        this.entityManager.persist(ordem);
    }

    public Ordem consultaPorId(Integer id){
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultaTodos(){
        String jpql = "SELECT ordem FROM Ordem ordem";
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
    }

    public void atualizar(Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void remover(Ordem ordem){
        this.entityManager.remove(ordem);
    }
}
