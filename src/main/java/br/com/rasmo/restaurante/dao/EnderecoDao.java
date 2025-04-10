package br.com.rasmo.restaurante.dao;

import br.com.rasmo.restaurante.entity.Endereco;
import br.com.rasmo.restaurante.vo.ClienteVo;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

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


/*
                                Consulta dinamica com cidade e rua


    public List<ClienteVo> consultaClientes(String cidade, String rua){
        String jpql = "SELECT new br.com.rasmo.restaurante.vo.ClienteVo(e.cliente.cpf, e.cliente.nome) FROM Endereco e " +
                "WHERE UPPER(e.cidade) = UPPER(:cidade) AND UPPER(e.rua) = UPPER(:rua) ";
        return this.entityManager.createQuery(jpql, ClienteVo.class)
                .setParameter("cidade", cidade).setParameter("rua", rua).getResultList();
    }

 */


    // Consulta dinamica com cidade e rua mesmo seum um deles for nulo //
    public List<ClienteVo> consultaClientes(String cidade, String rua) {
        String jpql = "SELECT new br.com.rasmo.restaurante.vo.ClienteVo(e.cliente.clienteId.cpf, e.cliente.nome) FROM Endereco e " +
                "WHERE 1=1";
        if (Objects.nonNull(cidade)) {
            jpql = jpql.concat("AND UPPER(e.cidade) = UPPER(:cidade)");
        }
        if (Objects.nonNull(rua)) {
            jpql = jpql.concat("AND UPPER(e.rua) = UPPER(:rua)");
        }
        TypedQuery typedQuery = this.entityManager.createQuery(jpql, ClienteVo.class);

        if (Objects.nonNull(cidade)) {
            typedQuery.setParameter("cidade", cidade);
        }
        if (Objects.nonNull(rua)) {
            typedQuery.setParameter("rua", rua);
        }

        return typedQuery.getResultList();
    }

    public List<ClienteVo> consultaClientesUsandoCliteria(String cidade, String rua){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteVo> criteriaQuery = builder.createQuery(ClienteVo.class);
        Root<Endereco> root = criteriaQuery.from(Endereco.class);
        criteriaQuery.multiselect(root.get("cliente").get("clienteId").get("cpf"), root.get("cliente").get("nome"));
        Predicate predicate = builder.and();

        if (Objects.nonNull(cidade)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("cidade")), cidade.toUpperCase()));
        }
        if (Objects.nonNull(rua)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("rua")), rua.toUpperCase()));
        }

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void atualizar(Endereco endereco){
        this.entityManager.merge(endereco);
    }

    public void remover(Endereco endereco){
        this.entityManager.remove(endereco);
    }
}
