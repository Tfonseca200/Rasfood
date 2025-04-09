package br.com.rasmo.restaurante.dao;

import br.com.rasmo.restaurante.entity.Ordem;
import br.com.rasmo.restaurante.vo.ItensPrincipaisVo;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {

    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Ordem ordem){
        this.entityManager.persist(ordem);
    }

    public Ordem consultaPorId(Integer id){
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultaTodos(){
        String jpql = "SELECT ordem FROM Ordem ordem";
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
    }

    public Ordem joinFetchCliente(final Integer id){
        String jpql = "SELECT o FROM Ordem o JOIN FETCH o.cliente WHERE o.id = :id";
        return this.entityManager.createQuery(jpql, Ordem.class).setParameter("id", id ).getSingleResult();
    }

    public void atualizar(Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void remover(Ordem ordem){
        this.entityManager.remove(ordem);
    }

    public List<ItensPrincipaisVo> consultarItemsMaisVendidos(){
        String jpql = "SELECT new br.com.rasmo.restaurante.vo.ItensPrincipaisVo(" +
                "c.nome, SUM(oc.quantidade)) " +
                "FROM Ordem ordem " +
                "JOIN OrdensCardapio oc ON ordem.id = oc.ordem.id " +
                "JOIN Cardapio c ON oc.cardapio.id = c.id " +
                "GROUP BY c.nome " +
                "ORDER BY SUM(oc.quantidade) DESC";
        return this.entityManager.createQuery(jpql,ItensPrincipaisVo.class).getResultList();
    }
}
