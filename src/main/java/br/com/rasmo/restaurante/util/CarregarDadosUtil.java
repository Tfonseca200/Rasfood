package br.com.rasmo.restaurante.util;

import br.com.rasmo.restaurante.dao.CardapioDao;
import br.com.rasmo.restaurante.dao.CategoriaDao;
import br.com.rasmo.restaurante.entity.Cardapio;
import br.com.rasmo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CarregarDados {


    public void cadastrarCategoria(EntityManager entityManager){

        entityManager.getTransaction().begin();
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

    public void cadastrarCardapio(EntityManager entityManager, Categoria categoria){
        entityManager.getTransaction().begin();
        Cardapio cardapio1 = new Cardapio("Macarrão", "Macarrão ao molho italiano", true, BigDecimal.valueOf(100), categoria);
        Cardapio cardapio2 = new Cardapio("Picanha", "Picanha do lula", true, BigDecimal.valueOf(50.99), categoria  );
        Cardapio cardapio3 = new Cardapio("Largatixa", "Largatixa da malasia", true, BigDecimal.valueOf(79.00), categoria  );
        Cardapio cardapio4 = new Cardapio("Linguiça", "Linguiça do boi", true, BigDecimal.valueOf(100), categoria  );
        Cardapio cardapio5 = new Cardapio("Cordeiro", "Cordeiro da africa", true, BigDecimal.valueOf(90), categoria  );

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        cardapioDao.cadastra(cardapio1);
        cardapioDao.cadastra(cardapio2);
        cardapioDao.cadastra(cardapio3);
        cardapioDao.cadastra(cardapio4);
        cardapioDao.cadastra(cardapio5);
        entityManager.flush();
        entityManager.clear();
    }
}
