import java.util.IllegalFormatCodePointException;

public class Conta {
    private int numero;
    private String senha;
    private double saldo;
    private int qtdTransacoes;
    private Pessoa titular;

    public Conta(int numero, String senha, double saldo, Pessoa titular) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
        this.titular = titular;
    }
    public void pagamento(double valor, double taxaDeServico){
        if(this instanceof Credito){
            Credito contaDeCredito = (Credito) this;
            if (contaDeCredito.isFaturaPaga()){
                if (valor > contaDeCredito.verificaLimite()){
                    System.out.println("Limite insuficiente");
                }else{
                    if (qtdTransacoes < 5){
                        contaDeCredito.diminuiLimite(valor);
                    }
                    else {
                        contaDeCredito.diminuiLimite(valor + ((taxaDeServico / 100) * valor));
                        qtdTransacoes++;
                    }
                }
            }
            else{
                System.out.println("Fatura não paga");
            }
        }
        else {
            if (valor > saldo){
                System.out.println("Saldo insuficiente");
            }else{
                if (qtdTransacoes < 5){
                    saldo -= valor;
                    qtdTransacoes++;
                }
                else {
                    saldo -= (valor + ((taxaDeServico / 100) * valor));
                    qtdTransacoes++;
                }
            }
        }
    }
    public void credito(double valor, double taxaDeServico) {
        if (!(this instanceof Credito)) {
            if (qtdTransacoes < 5){
                this.saldo += valor;
                qtdTransacoes++;
            }
            else {
                this.saldo += valor - ((taxaDeServico / 100) * valor);
            }
        }
    }
    public double saldo(){
        return this.saldo;
    }

    public void alteraSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void adicionaTransacoes(){
        this.qtdTransacoes++;
    }
    public int verificaQuantidadeTransacoes(){
        return this.qtdTransacoes;
    }

    public int getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }
}
