package pedido;

public class EstadoEntregue implements EstadoDoPedido {
    @Override
    public void aprovarPagamento(Pedido pedido) {
        System.out.println("ERRO: O pedido já foi entregue.");
    }
    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERRO: O pedido já foi entregue.");
    }
    @Override
    public void entregarPedido(Pedido pedido) {
        System.out.println("ERRO: O pedido já foi entregue.");
    }
    @Override
    public void cancelarPedido(Pedido pedido) {
        System.out.println("ERRO: O pedido já foi entregue.");
    }
}