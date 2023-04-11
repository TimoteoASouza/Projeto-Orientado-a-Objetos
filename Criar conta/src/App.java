import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Conta> contas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Criar uma nova conta");
            System.out.println("2 - Exibir o saldo ou extrato de uma conta");
            System.out.println("3 - Sacar um valor de uma conta");
            System.out.println("4 - Depositar um valor em uma conta");
            System.out.println("5 - Transferir valores de uma conta para outra");
            System.out.println("6 - Exibir as contas criadas");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Encerrando o programa...");
                break;
            } else if (opcao == 1) {
                scanner.nextLine();
                System.out.println("Informe o nome do titular:");
                String nome = scanner.nextLine();
                System.out.println("Informe o CPF do titular:");
                String cpf = scanner.nextLine();
                System.out.println("Informe o número da conta:");
                int numero = scanner.nextInt();
                System.out.println("Informe o saldo inicial da conta:");
                double saldo = scanner.nextDouble();

                Titular titular = new Titular(nome, cpf);
                Conta conta = new Conta(numero, saldo, titular);
                contas.add(conta);

                System.out.println("Conta criada com sucesso!");
            } else if (opcao == 2) {
                System.out.println("Informe o número da conta:");
                int numero = scanner.nextInt();
                scanner.nextLine(); // Descarta a quebra de linha pendente
            
                boolean encontrou = false;
            
                for (Conta conta : contas) {
                    if (conta.getNumero() == numero) {
                        System.out.println("Número da conta: " + conta.getNumero());
                        System.out.println("Nome do titular: " + conta.getTitular().getNome());
                        System.out.println("Saldo: " + conta.getSaldo());
                        encontrou = true;
                        break;
                    }
                }
            
                if (!encontrou) {
                    System.out.println("Conta não encontrada!");
                
            }
            } else if (opcao == 3) {
                System.out.println("Informe o número da conta:");
                int numero = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Informe o valor do saque:");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                boolean encontrou = false;

                for (Conta conta : contas) {
                    if (conta.getNumero() == numero) {
                        if (conta.sacar(valor)) {
                            System.out.println("Saque efetuado com sucesso!");
                        } else {
                            System.out.println("Não foi possível realizar o saque!");
                        }

                        encontrou = true;
                        break;
                    }
                }

                if (!encontrou) {
                    System.out.println("Conta não encontrada!");
                }
            } else if (opcao == 4) {
                System.out.println("Informe o número da conta:");
                int numero = scanner.nextInt();
                System.out.println("Informe o valor do depósito:");
                double valor = scanner.nextDouble();
                boolean encontrou = false;

                for (Conta conta : contas) {
                    if (conta.getNumero() == numero) {
                        conta.depositar(valor);
                        System.out.println("Depósito efetuado com sucesso!");
                        encontrou = true;
                        break;
                    }
                }

                if (!encontrou) {
                    System.out.println("Conta não encontrada!");
                }
            } else if (opcao == 5) {
                System.out.println("Informe o número da conta de origem:");
                int numeroOrigem = scanner.nextInt();
                System.out.println("Informe o número da conta de destino:");
                int numeroDestino = scanner.nextInt();
                System.out.println("Informe o valor da transferência:");
                double valor = scanner.nextDouble();boolean encontrouOrigem = false;
                boolean encontrouDestino = false;
    
                
                Conta contaOrigem = null;
                Conta contaDestino = null;

                
    
                for (Conta conta : contas) {
                    if (conta.getNumero() == numeroOrigem) {
                        encontrouOrigem = true;
                        contaOrigem = conta;
                    }
    
                    if (conta.getNumero() == numeroDestino) {
                        encontrouDestino = true;
                        contaDestino = conta;
                    }
    
                    if (encontrouOrigem && encontrouDestino) {
                        break;
                    }
                }
    
                if (!encontrouOrigem || !encontrouDestino) {
                    System.out.println("Uma das contas não foi encontrada!");
                } else {
                    if (contaOrigem.transferir(valor, contaDestino)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar a transferência!");
            }
        }
    } else if (opcao == 6) {
            System.out.println("Contas criadas:");

            for (Conta conta : contas) {
                System.out.println("Número da conta: " + conta.getNumero());
                System.out.println("Nome do titular: " + conta.getTitular().getNome());
                System.out.println("Saldo: " + conta.getSaldo());
                System.out.println("----------------------");
            }
        } else {
            System.out.println("Opção inválida! Tente novamente!");
        }

        System.out.println();
    }
}
}
    
    
    
