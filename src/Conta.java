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
    public void pagamento(double valor){
        if (valor > saldo){
            System.out.println("Saldo insuficiente");
        }else{
            saldo -= valor;
            qtdTransacoes++;
        }
    }
    public void credito(double valor) {
        if (!(this instanceof Credito)) {

        }
    }
}
