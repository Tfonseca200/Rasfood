package br.com.rasmo.restaurante.dao;

import br.com.rasmo.restaurante.entity.Categoria;
import br.com.rasmo.restaurante.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

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

    public List<Categoria> consultarTodasCategorias(){
        String jpql = "SELECT categorias FROM Categoria categorias";
        return this.entityManager.createQuery(jpql, Categoria.class).getResultList();
    };

    public void atualizar(Categoria categoria){
        entityManager.merge(categoria);
    }

    public void deletar(Categoria categoria){
        entityManager.remove(categoria);
    }
}
