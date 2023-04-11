
class App {
    public static void main(String[] args) {
        ContaCorrente banco = new ContaCorrente();
        banco.cadastrarConta(10000, "1", 2, "Joao da silva", "123.321.123-45");
        banco.cadastrarConta(30000, "2", 2, "Serjao Berranteiro", "333.333.221.11");

        banco.sacar();
        banco.depositar();
        banco.trasferir();
    }
}