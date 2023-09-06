public class Credito extends Conta{
    public Credito(int numero, String senha, double saldo, Pessoa titular, double limiteDaConta) {
        super(numero, senha, saldo, titular);
        this.limiteDaConta = limiteDaConta;
    }
    private int diaDaFatura = 10;
    private double limiteDaConta;
    private double limiteAtual;
    private boolean faturaPaga = true;

    public double verificaLimite(){
        return this.limiteAtual;
    }
    public void diminuiLimite(double valor){
        limiteAtual -= valor;
    }
    public void calcularFatura(){
        if (Main.dia % 30 == diaDaFatura){
            alteraSaldo(limiteDaConta - limiteAtual);
        }
    }
    public void pagarFatura(){
            limiteAtual = limiteDaConta;
            faturaPaga = true;
            alteraSaldo(0);
    }
    public boolean isFaturaPaga() {
        return faturaPaga;
    }
    //Saldo na conta de credito é o saldo devedor, ou seja, o quanto ele deve pagar
}
