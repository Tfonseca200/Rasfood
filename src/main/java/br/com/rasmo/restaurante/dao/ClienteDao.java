package br.com.rasmo.restaurante.dao;

import br.com.rasmo.restaurante.entity.Categoria;
import br.com.rasmo.restaurante.entity.Cliente;
import br.com.rasmo.restaurante.entity.ClienteId;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class ClienteDao {

    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente){
        this.entityManager.persist(cliente);
    }

    public Cliente consultarPorId(ClienteId id){
        return this.entityManager.find(Cliente.class,id);
    };

    public List<Cliente> consultarTodosClientes(){
      String jpql = "SELECT clientes FROM Cliente clientes";
      return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
    };


    public List<Cliente> consultarPorNome(String nome){
        String jpql = "SELECT clientes FROM Cliente clientes WHERE LOWER(clientes.nome) LIKE LOWER(:nome)";
        return this.entityManager.createQuery(jpql, Cliente.class).setParameter("nome","%" + nome + "%").getResultList();
    };

    public void atualizar(Cliente cliente){
         this.entityManager.merge(cliente);
    }

    public void deletar(Cliente cliente){
        this.entityManager.remove(cliente);
    }




}
