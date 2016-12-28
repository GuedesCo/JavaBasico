package aula43.labs;

/**
 *
 * @author fernando
 */
public class ContaEspecial extends ContaBancaria {

    private double limite;

    /**
     * @return the limite
     */
    public double getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        String s = "Conta Especial [";
        s += " Limite :" + limite;
        s += "; " + super.toString();
        s += "]";

        return s;
    }

    @Override
    public boolean Sacar(double valor) {
        if ((limite + this.getSaldo() - valor) >= 0) {
            this.setSaldo(limite + this.getSaldo() - valor);
            System.out.println("Saque Realizado com Sucesso!\nSaldo: " + this.getSaldo());
            return true;
        } else {
            System.out.println("Saldo Insuficiente!");
            return false;
        }
    }
}
