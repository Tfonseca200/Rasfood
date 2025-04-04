package br.com.rasmo.restaurante.service.test;

import br.com.rasmo.restaurante.dao.CardapioDao;
import br.com.rasmo.restaurante.dao.CategoriaDao;
import br.com.rasmo.restaurante.entity.Cardapio;
import br.com.rasmo.restaurante.entity.Categoria;
import br.com.rasmo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioService {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.entityManagerRasfood();
        cadastrarProdutoCardapio(entityManager, cadastraCategoria(entityManager));

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        // List<Cardapio> cardapiosRetorno = cardapioDao.consultarPorValor(BigDecimal.valueOf(100.00));
        //cardapiosRetorno.stream().forEach(res -> System.out.println("Lista de produtos de valor" + res));

        Cardapio cardapio = cardapioDao.consultarPorNome("saLma");
        System.out.println("O resulta da consulta do nome: " + cardapio);
        entityManager.close();

    }

    private static Categoria cadastraCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }

    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria){

        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto");
        risoto.setDecricao("Melhor risoto do mundo, acompanhado de lula e mariscos do mar");
        risoto.setDisponibilidade(true);
        risoto.setValor(BigDecimal.valueOf(100.00));
        risoto.setCategoria(categoria);

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao");
        salmao.setDecricao("Salmao diretamente da china xigilingue");
        salmao.setDisponibilidade(true);
        salmao.setValor(BigDecimal.valueOf(45.00));
        salmao.setCategoria(categoria);

        Cardapio feijoada = new Cardapio();
        feijoada.setNome("Feijoada");
        feijoada.setDecricao("Feijoada completa da avenida paulista");
        feijoada.setDisponibilidade(true);
        feijoada.setValor(BigDecimal.valueOf(100.00));
        feijoada.setCategoria(categoria);

        Cardapio coca = new Cardapio();
        coca.setNome("Coca-cola");
        coca.setDecricao("Coquinha gelada");
        coca.setDisponibilidade(true);
        coca.setValor(BigDecimal.valueOf(10.00));
        coca.setCategoria(categoria);


        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastra(risoto);
        entityManager.flush();
        cardapioDao.cadastra(salmao);
        entityManager.flush();
        cardapioDao.cadastra(feijoada);
        entityManager.flush();
        cardapioDao.cadastra(coca);
        entityManager.flush();
        //System.out.println("Prato um : " + cardapioDao.consultar(1));
        //System.out.println("Prato dois: " + cardapioDao.consultar(2));
        //cardapioDao.consutarTodos().forEach(elemento -> System.out.println("O prato consultado foi:" + elemento));

        entityManager.getTransaction().commit();
        entityManager.clear();






    }
}
