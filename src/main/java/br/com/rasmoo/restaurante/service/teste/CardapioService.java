package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.geEntityManagerRasFood();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));

    }
    private static Categoria cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;

    }
    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto de lula e polvo");
        risoto.setDisponivel(true);
        risoto.setCategoria(categoria);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho de salmao");
        salmao.setDisponivel(true);
        salmao.setCategoria(categoria);
        salmao.setValor(BigDecimal.valueOf(60.00));

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(risoto);
        entityManager.flush();
        cardapioDao.cadastrar(salmao);
        entityManager.flush();
        System.out.println( cardapioDao.consultar(1));
        System.out.println(cardapioDao.consultar(2));
        entityManager.close();

    }
}
