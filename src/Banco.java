import java.util.ArrayList;

public class Banco {
    private String nome;
    private String endereco;
    private int agencia;
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    private double juros;
    private double taxaDeServico;

    public Banco(String nome, String endereco, int agencia, double juros, double taxaDeServico) {
        this.nome = nome;
        this.endereco = endereco;
        this.agencia = agencia;
        this.juros = juros;
        this.taxaDeServico = taxaDeServico;
    }
    public void cadastrarConta(Conta conta){
        contas.add(conta);
    }
    public Conta verificaContasTransferencia(Conta contaVerificacao){
        for (Conta conta : contas){
            if(conta.getNumero() == contaVerificacao.getNumero()) {
                return conta;
            }
        }
        return null;
    }
    public Conta verificaContas(Conta contaVerificacao){
        for (Conta conta : contas){
            if(conta.getNumero() == contaVerificacao.getNumero() && conta.getSenha().equals(contaVerificacao.getSenha())) {
                return conta;
            }
        }
        return null;
    }

    public double taxaDeServico(){
        return this.taxaDeServico;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}
