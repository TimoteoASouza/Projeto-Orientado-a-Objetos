class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (saldo - valor < 0) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    public void rendimento() {
        saldo *= 1.005;
    }
}