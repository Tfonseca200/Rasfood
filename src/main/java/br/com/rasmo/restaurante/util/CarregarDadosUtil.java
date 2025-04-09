package br.com.rasmo.restaurante.util;

import br.com.rasmo.restaurante.dao.CardapioDao;
import br.com.rasmo.restaurante.dao.CategoriaDao;
import br.com.rasmo.restaurante.entity.Cardapio;
import br.com.rasmo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarregarDadosUtil {


    public static void cadastrarCategoria(EntityManager entityManager){
        //entityManager.getTransaction().begin();
        Categoria categoria1 = new Categoria("Prato principal");
        Categoria categoria2 = new Categoria("Sobremesa");
        Categoria categoria3 = new Categoria("Sobremesa");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        categoriaDao.cadastrar(categoria1);
        categoriaDao.cadastrar(categoria2);
        categoriaDao.cadastrar(categoria3);
        entityManager.flush();
        entityManager.clear();
    }

    public static List<Cardapio> cadastrarProdutosCardapio(){

        Categoria categoria = new Categoria("Prato principal"); //categoriaDao.consultarTodasCategorias();
        List<Cardapio> cardapios = new ArrayList<>();
        Cardapio cardapio1 = new Cardapio("Macarrão", "Macarrão ao molho italiano", true, categoria);
        Cardapio cardapio2 = new Cardapio("Picanha", "Picanha do lula", true, categoria);
        Cardapio cardapio3 = new Cardapio("Largatixa", "Largatixa da malasia", true, categoria);
        Cardapio cardapio4 = new Cardapio("Linguiça", "Linguiça do boi", true, categoria);
        Cardapio cardapio5 = new Cardapio("Cordeiro", "Cordeiro da africa", true, categoria);

        cardapios.add(cardapio1);
        cardapios.add(cardapio2);
        cardapios.add(cardapio3);
        cardapios.add(cardapio4);
        cardapios.add(cardapio5);

        return cardapios;
    }
}
