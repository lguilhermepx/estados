package pedidoteste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pedido.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTeste {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        // Cria um novo pedido antes de CADA teste.
        // Isso garante que cada teste comece do estado inicial "Pendente".
        pedido = new Pedido();
    }

    @Test
    @DisplayName("Deve criar um novo pedido no estado Pendente")
    void testeEstadoInicial() {
        // Verifica se o estado inicial está correto
        assertEquals(pedido.getEstadoPendente(), pedido.getEstadoAtual(),
                "Um novo pedido deve começar no estado Pendente.");
    }

    @Test
    @DisplayName("Deve seguir o fluxo feliz: Pendente -> Aprovado -> Enviado -> Entregue")
    void testeFluxoFelizCompleto() {
        // 1. De Pendente para Aprovado
        pedido.aprovarPagamento();
        assertEquals(pedido.getEstadoAprovado(), pedido.getEstadoAtual(),
                "Após aprovar, o estado deve ser Aprovado.");

        // 2. De Aprovado para Enviado
        pedido.enviarPedido();
        assertEquals(pedido.getEstadoEnviado(), pedido.getEstadoAtual(),
                "Após enviar, o estado deve ser Enviado.");

        // 3. De Enviado para Entregue
        pedido.entregarPedido();
        assertEquals(pedido.getEstadoEntregue(), pedido.getEstadoAtual(),
                "Após entregar, o estado deve ser Entregue.");
    }

    @Test
    @DisplayName("Deve permitir cancelar um pedido Pendente")
    void testeCancelarPedidoPendente() {
        pedido.cancelarPedido();
        assertEquals(pedido.getEstadoCancelado(), pedido.getEstadoAtual(),
                "Um pedido Pendente deve poder ser Cancelado.");
    }

    @Test
    @DisplayName("Deve permitir cancelar um pedido Aprovado")
    void testeCancelarPedidoAprovado() {
        // Primeiro, muda o estado para Aprovado
        pedido.aprovarPagamento();
        assertEquals(pedido.getEstadoAprovado(), pedido.getEstadoAtual());

        // Agora, cancela
        pedido.cancelarPedido();
        assertEquals(pedido.getEstadoCancelado(), pedido.getEstadoAtual(),
                "Um pedido Aprovado deve poder ser Cancelado.");
    }

    @Test
    @DisplayName("NÃO deve permitir enviar um pedido Pendente")
    void testeAcaoInvalidaEnviarPendente() {
        pedido.enviarPedido();
        // O estado NÃO deve mudar
        assertEquals(pedido.getEstadoPendente(), pedido.getEstadoAtual(),
                "Não deve ser possível enviar um pedido Pendente. O estado deve permanecer Pendente.");
    }

    @Test
    @DisplayName("NÃO deve permitir cancelar um pedido Enviado")
    void testeAcaoInvalidaCancelarEnviado() {
        // Leva o pedido até o estado Enviado
        pedido.aprovarPagamento();
        pedido.enviarPedido();
        assertEquals(pedido.getEstadoEnviado(), pedido.getEstadoAtual());

        // Tenta cancelar
        pedido.cancelarPedido();
        // O estado NÃO deve mudar
        assertEquals(pedido.getEstadoEnviado(), pedido.getEstadoAtual(),
                "Não deve ser possível cancelar um pedido Enviado. O estado deve permanecer Enviado.");
    }

    @Test
    @DisplayName("NÃO deve permitir nenhuma ação após ser Entregue")
    void testeAcoesInvalidasEmPedidoEntregue() {
        // Leva o pedido até o estado Entregue
        pedido.aprovarPagamento();
        pedido.enviarPedido();
        pedido.entregarPedido();
        assertEquals(pedido.getEstadoEntregue(), pedido.getEstadoAtual());

        // Tenta todas as outras ações
        pedido.aprovarPagamento();
        assertEquals(pedido.getEstadoEntregue(), pedido.getEstadoAtual());

        pedido.enviarPedido();
        assertEquals(pedido.getEstadoEntregue(), pedido.getEstadoAtual());

        pedido.cancelarPedido();
        assertEquals(pedido.getEstadoEntregue(), pedido.getEstadoAtual());
    }

    @Test
    @DisplayName("NÃO deve permitir nenhuma ação após ser Cancelado")
    void testeAcoesInvalidasEmPedidoCancelado() {
        // Leva o pedido até o estado Cancelado
        pedido.cancelarPedido();
        assertEquals(pedido.getEstadoCancelado(), pedido.getEstadoAtual());

        // Tenta todas as outras ações
        pedido.aprovarPagamento();
        assertEquals(pedido.getEstadoCancelado(), pedido.getEstadoAtual());

        pedido.enviarPedido();
        assertEquals(pedido.getEstadoCancelado(), pedido.getEstadoAtual());

        pedido.entregarPedido();
        assertEquals(pedido.getEstadoCancelado(), pedido.getEstadoAtual());
    }
}