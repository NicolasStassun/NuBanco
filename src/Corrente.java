public class Corrente extends Conta {
    public Corrente(int numero, String senha, double saldo, Pessoa titular, double limite) {
        super(numero, senha, saldo, titular);
        this.limite = limite;
    }
    private double limite;

    public void saque(double valor, double taxaDeServico) {
        if (valor > saldo() && limite-valor <= 0) {
            System.out.println("Saldo insuficiente");
        } else {
            if(this.verificaQuantidadeTransacoes() > 5){
                    limite -= (valor + ((taxaDeServico / 100) * valor));
                    this.alteraSaldo(saldo() - (valor + ((taxaDeServico / 100) * valor)));
                    this.adicionaTransacoes();
            }
            else{
                limite -= valor;
                this.alteraSaldo(saldo()-valor);
                this.adicionaTransacoes();
            }
        }
    }
    public void transferencia(Conta contaQueRecebeATransferencia, double valor, double taxaDeServico){
        this.saque(valor, taxaDeServico);
        contaQueRecebeATransferencia.credito(valor, taxaDeServico);
    }
}
