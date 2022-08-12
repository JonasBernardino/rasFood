package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.ClienteDao;
import br.com.rasmoo.restaurante.dao.EnderecoDao;
import br.com.rasmoo.restaurante.dao.OrdemDao;
import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;
import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.entity.OrdensCardapio;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endereco= new Endereco("00", "sem teto", "apa", "João Pessoa", "PB");
        Cliente jonas = new Cliente("10266022222", "Jonas", "58028222");
        jonas.addEndereco(endereco);
        Ordem ordem = new Ordem(jonas);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1),2 ));
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(2),3 ));
        clienteDao.cadastrar(jonas);
        ordemDao.cadastrar(ordem);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        System.out.println(enderecoDao.consultarClientesUsandoCriteria("PB", null, null));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
