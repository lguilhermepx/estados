package pedido;

public class EstadoPendente implements EstadoDoPedido {

    @Override
    public void aprovarPagamento(Pedido pedido) {
        System.out.println("Pagamento APROVADO.");
        // transição de estado: Pendente -> Aprovado
        pedido.setEstado(pedido.getEstadoAprovado());
    }

    @Override
    public void enviarPedido(Pedido pedido) {
        System.out.println("ERRO: Não pode enviar um pedido pendente.");
    }

    @Override
    public void entregarPedido(Pedido pedido) {
        System.out.println("ERRO: Não pode entregar um pedido pendente.");
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
        System.out.println("Pedido CANCELADO com sucesso.");
        // transição de estado: Pendente -> Cancelado
        pedido.setEstado(pedido.getEstadoCancelado());
    }
}