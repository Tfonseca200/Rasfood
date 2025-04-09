package br.com.rasmo.restaurante.service.test;

import br.com.rasmo.restaurante.dao.*;
import br.com.rasmo.restaurante.entity.*;
import br.com.rasmo.restaurante.util.CarregarDadosUtil;
import br.com.rasmo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrdemService {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.entityManagerRasfood();
        entityManager.getTransaction().begin();

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        List<Cardapio> cardapios = CarregarDadosUtil.cadastrarProdutosCardapio();
        Endereco endereco = new Endereco("73643872", "casa", "Avenida paulista", "São Paulo");
        Cliente thiago = new Cliente("839749378", "Thiago F");
        clienteDao.cadastrar(thiago);
        thiago.addEndereco(endereco);
        Ordem ordem = new Ordem(thiago);


        categoriaDao.cadastrar(cardapios.get(1).getCategoria());
        categoriaDao.cadastrar(cardapios.get(2).getCategoria());
        cardapioDao.cadastrar(cardapios.get(1));
        cardapioDao.cadastrar(cardapios.get(2));

        OrdensCardapio ordensCardapio1 = new OrdensCardapio(cardapios.get(1), BigDecimal.valueOf(90), 6);
        OrdensCardapio ordensCardapio2 = new OrdensCardapio(cardapios.get(2), BigDecimal.valueOf(150),  5);

        ordem.addOrdemCardapio(ordensCardapio1);
        ordem.addOrdemCardapio(ordensCardapio2);
        ordemDao.cadastrar(ordem);


        System.out.println(ordem);
        System.out.println(ordemDao.consultarItemsMaisVendidos());
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
