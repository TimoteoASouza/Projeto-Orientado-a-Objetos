import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void criarConta(int numero, Titular titular, double saldoInicial) {
        Conta conta = new Conta(numero, saldoInicial, titular);
        contas.add(conta);
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Banco{" +"contas=" + contas +'}';
    }
}