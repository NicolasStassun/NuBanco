public class Credito extends Conta{
    public Credito(int numero, String senha, double saldo, Pessoa titular) {
        super(numero, senha, saldo, titular);
    }
    //Saldo na conta de credito é o saldo devedor, ou seja, o quanto ele deve pagar
}
