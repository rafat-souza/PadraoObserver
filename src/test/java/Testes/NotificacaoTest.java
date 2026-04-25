package Testes;

import org.junit.jupiter.api.Test;
import padraoObserver.Cliente;
import padraoObserver.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NotificacaoTest {

    @Test
    void deveNotificarUmCliente() {
        Produto produto = new Produto("Notebook", "Eletrônicos");
        Cliente cliente = new Cliente("João");

        cliente.assinarAlerta(produto);
        produto.reporEstoque();

        String notificacaoEsperada = "João, o item que você deseja está disponível: Produto{nome='Notebook', categoria='Eletrônicos', emEstoque=true}";
        assertEquals(notificacaoEsperada, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVariosClientes() {
        Produto produto = new Produto("Smartphone", "Eletrônicos");
        Cliente cliente1 = new Cliente("Maria");
        Cliente cliente2 = new Cliente("José");

        cliente1.assinarAlerta(produto);
        cliente2.assinarAlerta(produto);

        produto.reporEstoque();

        String notificacaoEsperadaMaria = "Maria, o item que você deseja está disponível: Produto{nome='Smartphone', categoria='Eletrônicos', emEstoque=true}";
        String notificacaoEsperadaJose = "José, o item que você deseja está disponível: Produto{nome='Smartphone', categoria='Eletrônicos', emEstoque=true}";

        assertEquals(notificacaoEsperadaMaria, cliente1.getUltimaNotificacao());
        assertEquals(notificacaoEsperadaJose, cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteSemAssinatura() {
        Produto produto = new Produto("Tablet", "Eletrônicos");
        Cliente cliente = new Cliente("Ana");

        produto.reporEstoque();

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteProdutoA() {
        Produto produtoA = new Produto("Notebook", "Eletrônicos");
        Produto produtoB = new Produto("Cadeira Gamer", "Móveis");
        Cliente cliente1 = new Cliente("Carlos");
        Cliente cliente2 = new Cliente("Ana");

        cliente1.assinarAlerta(produtoA);
        cliente2.assinarAlerta(produtoB);

        produtoA.reporEstoque();

        String notificacaoEsperadaA = "Carlos, o item que você deseja está disponível: Produto{nome='Notebook', categoria='Eletrônicos', emEstoque=true}";

        assertEquals(notificacaoEsperadaA, cliente1.getUltimaNotificacao());
        assertNull(cliente2.getUltimaNotificacao());
    }

}
