package aula43.labs;

import java.util.Scanner;

/**
 *
 * @author fernando
 */
public class Teste {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

        /*
        System.out.println("***Teste Conta Simples ***\n");
        ContaBancaria contaSimples = new ContaBancaria();
        System.out.println("Cadastro Cliente");
        System.out.print("Nome: ");
        contaSimples.setNomeClinente(t.next());
        System.out.print("Numero da conta: ");
        contaSimples.setNumConta(t.next());
        System.out.println("Primeiro depósito");
        System.out.print("Valor de depósito para abertura de conta: ");
        contaSimples.Depositar(t.nextDouble());
        System.out.println("Informações da conta");
        System.out.println(contaSimples.toString());
        
        System.out.println("Realizar um saque");
        System.out.print("Valor a Sacar: ");
        RealizarSaque(contaSimples, t.nextDouble());
         */
 /*
        //teste Conta Poupança
        ContaPoupanca cp = new ContaPoupanca();
        System.out.println("******************");
        System.out.println("* Teste Poupança *");
        System.out.println("******************");
        
        cp.setNomeCliente("Fernando");
        cp.setNumConta("12345");
        cp.Depositar(70.00);
        System.out.println("Depósito realizado com sucesso! \nSaldo: "+cp.getSaldo());
        cp.setDiaRendimento(27);
        System.out.println(cp.toString());
        
        RealizarSaque(cp, 50.00);
        
        
        System.out.println(" ***** Conta Especial ***** ");
        ContaEspecial ce = new ContaEspecial();
        ce.setNomeCliente("Antonio Fernando");
        ce.setLimite(1000);
        ce.setNumConta("32113-9");
        ce.Depositar(5000.00);
        ce.Sacar(900.00);
        System.out.println(ce.toString());
         */
 
         /**
          * Abrir conta
          * Necessário escolher o tipo de conta
          * Cadastrar os dados do cliente
          */
        ContaBancaria cb = new ContaBancaria();
        cb.AbrirConta();
    }

    private static void RealizarSaque(ContaBancaria conta, double valor) {
        if (conta.Sacar(valor)) {
            System.out.println("Saque realizado com sucesso.\nSaldo: " + conta.getSaldo());;
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }
}
