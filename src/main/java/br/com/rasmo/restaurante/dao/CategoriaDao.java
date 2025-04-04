package br.com.rasmo.restaurante.dao;

import br.com.rasmo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        entityManager.persist(categoria);
    }

    public Categoria consultar (int id){
       return entityManager.find(Categoria.class, id);
    }

    public void atualizar(Categoria categoria){
        entityManager.merge(categoria);
    }

    public void deletar(Categoria categoria){
        entityManager.remove(categoria);
    }
}
