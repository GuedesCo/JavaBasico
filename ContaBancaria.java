package aula43.labs;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author FernandoGuedes
 */
public class ContaBancaria {

    private String nomeCliente;
    private String numConta;
    private double saldo;

    Scanner t = new Scanner(System.in);

    /**
     * contrutor de Conta Bancária
     *
     * @param nome
     * @param numero
     * @param saldo
     */
    public ContaBancaria() {
    }

    public ContaBancaria(String nm) {
        this.nomeCliente = nm;
    }

    public ContaBancaria(String nm, String num) {
        this.nomeCliente = nm;
        this.numConta = num;
    }

    public ContaBancaria(String nm, String num, double saldo) {
        this.nomeCliente = nm;
        this.numConta = num;
        this.saldo = saldo;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the numConta
     */
    public String getNumConta() {
        return numConta;
    }

    /**
     * @param numConta the numConta to set
     */
    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Método Depositar
     *
     * @param valor
     * @return não há.
     */
    public void Depositar(Double valor) {
        saldo += valor;
    }

    /**
     * Métod Sacar
     *
     * @param valor
     * @return true se depósito efetuado com sucesso
     * @return false se saldo resultar negativo.
     */
    public boolean Sacar(double valor) {
        if (saldo - valor >= 0) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método sobre escrito da classe object()
     *
     * @return string informações da conta do cliente.
     */
    @Override
    public String toString() {
        String s = "Conta Bancária [";
        s += "Nome: " + nomeCliente;
        s += "; Numero: " + numConta;
        s += "; Saldo: " + saldo;
        s += "]";
        return s;
    }

    public void AbrirConta() {
        boolean sair = false;
        while (!sair) {
            System.out.println("*** Tipo da conta ***");
            System.out.println("1 - Para Conta Simples");
            System.out.println("2 - Para Conta Poupança");
            System.out.println("3 - Para Conta Especial\n");
            System.out.print("Escolha o tipo de conta: ");
            int op = t.nextInt();
            switch (op) {
                case 1: {
                    ContaBancaria cb = new ContaBancaria();
                    System.out.println("Dados do Cliente");
                    System.out.print("Nome: ");
                    cb.setNomeCliente(t.next());
                    cb.setNumConta(cb.GerarNumConta());
                    System.out.print("Numero da conta: " + cb.getNumConta());
                    System.out.println("\nobs.: Esta conta pode ser\n"
                            + "aberta sem depósito inicial");
                    System.out.print("Deseja fazer depósito inicial? [s/n]");
                    String a = t.next();
                    if (a.equalsIgnoreCase("s")) {
                        System.out.print("Valor a depositar: ");
                        cb.Depositar(t.nextDouble());
                    }
                    System.out.println("***** Resumo da Conta " + cb.getNumConta() + " *****");
                    System.out.println(cb.toString());

                    //opção de continuar ou sair
                    System.out.print("Deseja abrir outra conta? [s/n] -> ");
                    String resp = t.next();
                    if (resp.equalsIgnoreCase("s")) {
                        sair = false;
                    } else {
                        sair = true;
                    }
                    break;
                }
                case 2: {
                    ContaPoupanca cp = new ContaPoupanca();
                    System.out.println("Dados do cliente");
                    System.out.print("Nome: ");
                    cp.setNomeCliente(t.next());
                    cp.setNumConta(cp.GerarNumConta());
                    System.out.println("Numero do conta: " + cp.getNumConta());
                    int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                    cp.setDiaRendimento(dia);
                    System.out.println("O dia de rendimento desta "
                            + "conta: " + cp.getDiaRendimento());
                    System.out.println("\nPara abrir a poupança é necessário "
                            + "fazer um depósito de no mínimo R$300,00");
                    System.out.print("Fazer um depósito agora? [s/n]");
                    String opcao = t.next();
                    if (opcao.equalsIgnoreCase("s")) {
                        System.out.print("Valor: ");
                        cp.Depositar(t.nextDouble());
                    } else if (opcao.equalsIgnoreCase("n")) {
                        System.out.println("Impossivel continuar a "
                                + "abrir a conta sem depósito.\n");

                        //opção de continuar ou sair
                        System.out.print("Deseja abrir outra conta? [s/n]");
                        String resp = t.next();
                        if (resp.equalsIgnoreCase("s")) {
                            sair = false;
                        } else {
                            sair = true;
                        }
                        break;
                    }
                    System.out.println("***** Resumo da Conta " + cp.getNumConta() + " *****");
                    System.out.println(cp.toString());
                    break;
                }
                case 3: {
                    ContaEspecial ce = new ContaEspecial();
                    System.out.println("Dados da Conta");
                    ce.setNumConta(ce.GerarNumConta());
                    System.out.println("Nome: ");
                    ce.setNomeCliente(t.next());
                    System.out.println("Numero da conta: " + ce.getNumConta());
                    ce.setLimite(1000.00);
                    System.out.println("Limite: " + ce.getLimite());
                    System.out.println("Para abrir conta especial "
                            + "tem de fazer um depósito a partir de R$1500,00");
                    System.out.print("Valor para Depósito: ");
                    ce.Depositar(t.nextDouble());
                    System.out.println("Resumo da Conta");
                    System.out.println(ce.toString());

                    //opção de continuar ou sair
                    System.out.print("Deseja abrir outra conta? [s/n]");
                    String resp = t.next();
                    if (resp.equalsIgnoreCase("s")) {
                        sair = false;
                    } else {
                        sair = true;
                    }
                    break;
                }
            }
        }
    }

    public String GerarNumConta() {
        Random gerador = new Random();
        this.setNumConta(Integer.toString(gerador.nextInt(99999)) + "-" + Integer.toString(gerador.nextInt(9)));
        return this.getNumConta();
    }
}
