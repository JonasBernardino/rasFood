package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {

        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto de lula e polvo");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho de salmao");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.geEntityManagerRasFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        entityManager.flush();
        cardapioDao.cadastrar(salmao);
        entityManager.flush();
        System.out.println("Prato consultado: "+ cardapioDao.consultar(2));
        cardapioDao.excluir(salmao);
        System.out.println(cardapioDao.consultar(2));
        entityManager.clear();
        risoto.setValor(BigDecimal.valueOf(75.55));
        cardapioDao.atualizar(risoto);
        System.out.println(cardapioDao.consultar(1));

    }
}
