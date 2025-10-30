package pedido;


public class EstadoAprovado implements EstadoDoPedido {

    @Override
    public void aprovarPagamento(Pedido pedido) {
        System.out.println("ERRO: O pagamento já foi aprovado.");
    }

    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("Pedido ENVIADO para a transportadora.");
        // transição de estado: Aprovado -> Enviado
        pedido.setEstado(pedido.getEstadoEnviado());
    }

    @Override
    public void entregarPedido(Pedido pedido) {
        System.out.println("ERRO: O pedido ainda não foi enviado.");
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
        System.out.println("Pedido CANCELADO. Reembolsando pagamento.");
        // transição de estado: Aprovado -> Cancelado
        pedido.setEstado(pedido.getEstadoCancelado());
    }
}