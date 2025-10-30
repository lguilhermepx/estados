package pedido;

public class Pedido {

    // referências para todos os estados
    private final EstadoDoPedido estadoPendente;
    private final EstadoDoPedido estadoAprovado;
    private final EstadoDoPedido estadoEnviado;
    private final EstadoDoPedido estadoEntregue;
    private final EstadoDoPedido estadoCancelado;

    // estado atual
    private EstadoDoPedido estadoAtual;

    public Pedido() {
        // inicializa os estados
        this.estadoPendente = new EstadoPendente();
        this.estadoAprovado = new EstadoAprovado();
        this.estadoEnviado = new EstadoEnviado();
        this.estadoEntregue = new EstadoEntregue();
        this.estadoCancelado = new EstadoCancelado();

        // estado inicial, sempre pendente
        this.estadoAtual = estadoPendente;
        System.out.println("Novo pedido criado. Estado atual: PENDENTE");
    }

    // a classe Pedido delega a ação para o estado atual
    public void aprovarPagamento() {
        estadoAtual.aprovarPagamento(this);
    }

    public void enviarPedido() {
        estadoAtual.enviarPedido(this);
    }

    public void entregarPedido() {
        estadoAtual.entregarPedido(this);
    }

    public void cancelarPedido() {
        estadoAtual.cancelarPedido(this);
    }

    public EstadoDoPedido getEstadoAtual() {
        return this.estadoAtual;
    }

    // Getters e Setters
    public void setEstado(EstadoDoPedido estado) {
        this.estadoAtual = estado;
    }

    public EstadoDoPedido getEstadoPendente() {
        return estadoPendente;
    }

    public EstadoDoPedido getEstadoAprovado() {
        return estadoAprovado;
    }

    public EstadoDoPedido getEstadoEnviado() {
        return estadoEnviado;
    }

    public EstadoDoPedido getEstadoEntregue() {
        return estadoEntregue;
    }

    public EstadoDoPedido getEstadoCancelado() {
        return estadoCancelado;
    }
}