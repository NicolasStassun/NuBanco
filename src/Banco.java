import java.util.ArrayList;

public class Banco {
    private String nome;
    private String endereco;
    private int agencia;
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    private double juros;
    private double tacaDeServico;

    public Banco(String nome, String endereco, int agencia, double juros, double tacaDeServico) {
        this.nome = nome;
        this.endereco = endereco;
        this.agencia = agencia;
        this.juros = juros;
        this.tacaDeServico = tacaDeServico;
    }
    public void cadastrarConta(Conta conta){
        contas.add(conta);
    }
}
