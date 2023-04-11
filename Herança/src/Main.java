public class Main {
    public static void main(String[] args) {
        // Criação de clientes
        Cliente cliente1 = new PessoaFisica("João", "12345678901");
        Cliente cliente2 = new PessoaJuridica("Empresa XYZ", "12345678901234");

        // Criação de contas
        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, 1000.0);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente1, 5000.0);
        ContaEspecial contaEspecial1 = new ContaEspecial(cliente2, 2000.0, 1000.0);

        // Realização de operações nas contas
        contaCorrente1.depositar(500.0);
        contaCorrente1.sacar(200.0);

        contaPoupanca1.depositar(1000.0);
        contaPoupanca1.sacar(1000.0);
        contaPoupanca1.rendimento();

        contaEspecial1.depositar(2000.0);
        contaEspecial1.sacar(3500.0);

        // Exibição dos dados das contas e clientes
        System.out.println("Dados da Conta Corrente:");
        System.out.println("Cliente: " + contaCorrente1.getCliente().getNome());
        System.out.println("Saldo: R$" + contaCorrente1.getSaldo());

        System.out.println("\nDados da Conta Poupança:");
        System.out.println("Cliente: " + contaPoupanca1.getCliente().getNome());
        System.out.println("Saldo: R$" + contaPoupanca1.getSaldo());

        System.out.println("\nDados da Conta Especial:");
        System.out.println("Cliente: " + contaEspecial1.getCliente().getNome());
        System.out.println("Saldo: R$" + contaEspecial1.getSaldo());
    }
}