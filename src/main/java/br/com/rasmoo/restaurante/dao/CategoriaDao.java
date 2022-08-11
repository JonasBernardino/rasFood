package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Categoria> consultarTodos() {
        String jpql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(jpql,Categoria.class).getResultList();
    }

    public void cadastrar(final Categoria categoria) {
        entityManager.persist(categoria);
    }

    public Categoria consultar(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public void atualizar(final Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria) {
        this.entityManager.remove(categoria);
    }
}
