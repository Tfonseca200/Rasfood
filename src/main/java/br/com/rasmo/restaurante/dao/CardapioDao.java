package br.com.rasmo.restaurante.dao;

import br.com.rasmo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio prato){
        this.entityManager.persist(prato);
    }

    public Cardapio consultarPorId(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE LOWER(c.valor) = LOWER(:valor) ";
            return this.entityManager.createQuery(jpql).setParameter("valor", filtro).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Convetendo para minusculos
    public Cardapio consultarPorNome(String filtro){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE LOWER(c.nome) = LOWER(:nome) ";
            return (Cardapio) this.entityManager.createQuery(jpql).setParameter("nome", filtro).getSingleResult();
        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }

    public List<Cardapio> consutarTodos(){
        try {
            String jpql = "SELECT c FROM Cardapio c";
            List<Cardapio> cardapios = new ArrayList<>();
            return this.entityManager.createQuery(jpql).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };

    public void atualizar(Cardapio prato){
        this.entityManager.merge(prato);
    }

    public void delete(final Cardapio prato){
        this.entityManager.remove(prato);
    }
}
