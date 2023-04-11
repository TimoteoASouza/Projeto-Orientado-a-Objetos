class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() - valor < 0) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }
}