package pedido;

public class EstadoEnviado implements EstadoDoPedido {

    @Override
    public void aprovarPagamento(Pedido pedido) {
        System.out.println("ERRO: O pagamento já foi aprovado.");
    }

    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERRO: O pedido já foi enviado.");
    }

    @Override
    public void entregarPedido(Pedido pedido) {
        System.out.println("Pedido ENTREGUE ao cliente.");
        // transição de estado: Enviado -> Entregue
        pedido.setEstado(pedido.getEstadoEntregue());
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
        System.out.println("ERRO: Não é possível cancelar um pedido já enviado.");
    }
}