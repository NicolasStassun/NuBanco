public class Juridica extends Pessoa{
    public Juridica(String endereco, long cnpj, String razaoSocial) {
        super(endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    private long cnpj;
    private String razaoSocial;
}
