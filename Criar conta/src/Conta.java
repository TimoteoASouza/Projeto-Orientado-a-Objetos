public class Conta {
    private int numero;
    private Titular titular;
    private double saldo;

    public Conta(int numero, double saldo, Titular titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public Titular getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean transferir(double valor, Conta outraConta) {
        if (this.sacar(valor)) {
            outraConta.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta{" +"numero=" + numero +", titular=" + titular +", saldo=" + saldo +'}';
    }
}