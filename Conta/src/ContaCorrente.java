import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ContaCorrente {
    private int saldo;
    private int agencia;
    private String nome;
    private String cpf;
    private String numeroConta;
    private Map<String, ContaCorrente> listaContas = new HashMap<>();

    public void cadastrarConta(int saldo, String numeroConta, int agencia, String nome, String cpf) {
        ContaCorrente novaConta = new ContaCorrente();
        novaConta.setSaldo(saldo);
        novaConta.setAgencia(agencia);
        novaConta.setCpf(cpf);
        novaConta.setNome(nome);
        novaConta.setNumeroConta(numeroConta);
        listaContas.put(novaConta.getNumeroConta(), novaConta);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean conferirSaldo(int valor) {
        return getSaldo() >= valor;
    }

    public void sacar() {
        String numeroConta = JOptionPane.showInputDialog(null, "Digite o número da conta para sacar:");

        if (listaContas.containsKey(numeroConta)) {
            ContaCorrente usuario = listaContas.get(numeroConta);

            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor para sacar:"));

            if (usuario.conferirSaldo(valor)) {
                usuario.setSaldo(usuario.getSaldo() - valor);
                System.out.println("Saque de " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Não é possível sacar, saldo insuficiente!");
            }
        } else {
            System.out.println("Conta inexistente.");
        }
    }

    public void depositar() {
        String numeroConta = JOptionPane.showInputDialog(null, "Digite o número da conta para depositar:");

        if (listaContas.containsKey(numeroConta)) {
            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor para depositar:"));
            listaContas.get(numeroConta).setSaldo(listaContas.get(numeroConta).getSaldo() + valor);
            System.out.println("O valor de " + valor + " foi depositado com sucesso.");
        } else {
            System.out.println("Não foi possível depositar. Conta inexistente.");
        }
    }


    public void trasferir() {

        String contaSaida = JOptionPane.showInputDialog(null, "Digite a conta de saida");
        
        String contaEntrada = JOptionPane.showInputDialog(null, "Digite a conta de entrada");

        
        if (listaContas.containsKey(contaEntrada) && listaContas.containsKey(contaSaida)) {
            ContaCorrente contaE = listaContas.get(contaEntrada);
            ContaCorrente contaS = listaContas.get(contaSaida);
            
            int valorTransf = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de transferencia"));
            
            if (contaS.conferirSaldo(valorTransf)) {
                contaS.setSaldo(contaS.getSaldo() - valorTransf);
                contaE.setSaldo(valorTransf + contaE.getSaldo());
                System.out.println("O valor de " + valorTransf + " foi trnasferido com sucesso!!");
            }
        }
    }
}
