package pedido;

public class EstadoCancelado implements EstadoDoPedido {
    @Override
    public void aprovarPagamento(Pedido pedido) {
        System.out.println("ERRO: O pedido foi cancelado.");
    }
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERRO: O pedido foi cancelado.");
    }
    @Override
    public void entregarPedido(Pedido pedido) {
        System.out.println("ERRO: O pedido foi cancelado.");
    }
    @Override
    public void cancelarPedido(Pedido pedido) {
        System.out.println("ERRO: O pedido já foi cancelado.");
    }
}