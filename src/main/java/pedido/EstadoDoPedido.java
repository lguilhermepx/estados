package pedido;


// a interface state
public interface EstadoDoPedido {
    // Cada estado deve saber como lidar com cada ação.

    void aprovarPagamento(Pedido pedido);
    void enviarPedido(Pedido pedido);
    void entregarPedido(Pedido pedido);
    void cancelarPedido(Pedido pedido);
}