public class Fisica extends Pessoa{

    public Fisica(String endereco, long cpf, String nomeCompleto) {
        super(endereco);
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
    }

    private long cpf;
    private String nomeCompleto;
}
