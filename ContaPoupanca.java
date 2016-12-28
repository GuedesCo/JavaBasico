package aula43.labs;

import java.util.Calendar;

/**
 *
 * @author fernando
 */
public class ContaPoupanca extends ContaBancaria{
    private int diaRendimento;

    /**
     * @return the diaRendimento
     */
    public int getDiaRendimento() {
        return diaRendimento;
    }

    /**
     * @param diaRendimento the diaRendimento to set
     */
    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }
    
    @Override
    public String toString(){
        String s = "Conta Poupança [";
        s += "Dia Rendimento: "+diaRendimento;
        s += "; "+super.toString();
        s += "]";
        return s;
    }
    
    /**
     * Calcular novo saldo
     * @param tx
     * baseado na taxa, se for o dia de aniversário da poupança
     * o saldo é acrescido da taxa passada para o dia.
     * @return calculo efetuado [sim/não]
     */
    public boolean calcularNovoSaldo(double tx){
        Calendar hoje = Calendar.getInstance();
        
        if(diaRendimento == hoje.get(Calendar.DAY_OF_MONTH)){
            this.setSaldo(this.getSaldo()+ this.getSaldo()*tx);
            return true;
        }
        return false;
    }
}
