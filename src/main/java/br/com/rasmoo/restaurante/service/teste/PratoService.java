package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.PratoDao;
import br.com.rasmoo.restaurante.entity.Prato;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        Prato risoto = new Prato();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto de lula e polvo");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        EntityManager entityManager = JPAUtil.geEntityManagerRasFood();
        PratoDao pratoDao = new PratoDao(entityManager);
        pratoDao.cadastrar(risoto);
        entityManager.getTransaction().begin();
        entityManager.persist(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
