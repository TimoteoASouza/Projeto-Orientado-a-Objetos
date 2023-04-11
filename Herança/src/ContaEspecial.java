class ContaEspecial extends Conta {
    private double chequeEspecial;

    public ContaEspecial(Cliente cliente, double saldo, double chequeEspecial) {
        super(cliente, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + chequeEspecial - valor < 0) {
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