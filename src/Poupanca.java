public class Poupanca extends Conta{

    public Poupanca(int numero, String senha, double saldo, Pessoa titular, int taxaDeRendimento) {
        super(numero, senha, saldo, titular);
        this.taxaDeRendimento = taxaDeRendimento;
    }
    private int taxaDeRendimento;
    public void saque(double valor, double taxaDeServico) {
        if (valor > saldo()) {
            System.out.println("Saldo insuficiente");
        } else {
            if(this.verificaQuantidadeTransacoes() > 5){
                this.alteraSaldo(saldo() - (valor + ((taxaDeServico / 100) * valor)));
                this.adicionaTransacoes();
            }
            else{
                this.alteraSaldo(saldo()-valor);
                this.adicionaTransacoes();
            }
        }
    }
    public void rendimento(){
        this.alteraSaldo(saldo() + ((taxaDeRendimento/100)*saldo()));
    }
}
