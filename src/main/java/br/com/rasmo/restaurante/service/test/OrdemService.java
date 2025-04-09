package br.com.rasmo.restaurante.service.test;

import br.com.rasmo.restaurante.dao.CardapioDao;
import br.com.rasmo.restaurante.dao.ClienteDao;
import br.com.rasmo.restaurante.dao.EnderecoDao;
import br.com.rasmo.restaurante.dao.OrdemDao;
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
        CarregarDadosUtil.cadastrarCategoria(entityManager);
        CarregarDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);


        Endereco endereco = new Endereco("73643872", "casa", "Avenida paulista", "São Paulo");
        Cliente thiago = new Cliente("839749378", "Thiago F");
        thiago.addEndereco(endereco);
        Ordem ordem = new Ordem(thiago);

        ordem.addOrdemCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1), BigDecimal.valueOf(134), 6 ));
        ordem.addOrdemCardapio(new OrdensCardapio(cardapioDao.consultarPorId(2), BigDecimal.valueOf(80), 3 ));
        ordem.addOrdemCardapio(new OrdensCardapio(cardapioDao.consultarPorId(3), BigDecimal.valueOf(300), 10 ));
        clienteDao.cadastrar(thiago);
        ordemDao.cadastrar(ordem);
        System.out.println(ordem);

        ordemDao.consultarItemsMaisVendidos().forEach(item -> System.out.println("Nome: " + item[0] + "\tQuantidade: " + item[1]));
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
