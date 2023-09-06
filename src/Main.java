import java.net.CookieHandler;
import java.util.Scanner;

public class Main {
    static int dia = 1;
    static Banco nuBanco = new Banco("NuBank", "Rua dos Bobos", 123, 0.05, 0.01);
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        geraDados();
        do {
            System.out.printf("1 - Login\n2 - Sair\n");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    login();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while (true);
    }
    public static void login(){
        Conta contaVerificada = null;
        do {
            System.out.println("Digite o numero da conta");
            int numeroDaConta = sc.nextInt();
            System.out.println("Digite a senha");
            String senha = sc.next();
            Conta contaPraSerVerificada = new Conta(numeroDaConta,senha,0,null);
            contaVerificada = nuBanco.verificaContas(contaPraSerVerificada);
            if (contaVerificada != null){
                menu(contaVerificada);
            }
            else {
                System.out.println("Conta não encontrada tente novamente");
            }
        }while (contaVerificada == null);
    }
    public static void menu(Conta contaLogada) {
        boolean saida = false;
        do {
            if (contaLogada instanceof Corrente) {
                Corrente contaCorrente = (Corrente) contaLogada;
                int opcoesMenuContaCorrente;
                System.out.println("""
                        1 - Realizar pagamento
                        2 - Creditar valor a conta
                        3 - Verifica saldo
                        4 - Realizar saque
                        5 - Transferencia
                        6 - Sair
                        """);
                opcoesMenuContaCorrente = sc.nextInt();
                double valor;
                switch (opcoesMenuContaCorrente) {
                    case 1:
                        System.out.println("Digite o valor a ser pago");
                        valor = sc.nextDouble();
                        contaCorrente.pagamento(valor, nuBanco.taxaDeServico());
                        break;
                    case 2:
                        System.out.println("Digite o valor a ser creditado");
                        valor = sc.nextDouble();
                        contaCorrente.credito(valor, nuBanco.taxaDeServico());
                        break;
                    case 3:
                        System.out.println("Seu saldo é: " + contaCorrente.saldo());
                        break;
                    case 4:
                        System.out.println("Digite o valor a ser sacado");
                        valor = sc.nextDouble();
                        contaCorrente.saque(valor, nuBanco.taxaDeServico());
                        break;
                    case 5:
                        System.out.println("Digite o valor a ser transferido");
                        valor = sc.nextDouble();
                        System.out.println("Digite o numero da conta a ser transferida");
                        int numeroDaConta = sc.nextInt();
                        Conta contaPraTransferir = new Conta(numeroDaConta, null, 0, null);
                        Conta contaTransferida = nuBanco.verificaContasTransferencia(contaPraTransferir);
                        if (contaTransferida != null) {
                            contaCorrente.transferencia(contaTransferida, valor, nuBanco.taxaDeServico());
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                        break;
                    case 6:
                        saida = true;
                        break;
                }
            }
        }while (!saida) ;
    }

    public static void passarDias(){
        System.out.printf("Escolha quantos dias você quer passar: ");
        int diasAPassar = sc.nextInt();
        for (int i = dia; i < dia + diasAPassar; i++) {
            for (Conta conta:
                 nuBanco.getContas()) {
                if (conta instanceof Credito){
                    Credito contaCredito = (Credito) conta;
                    contaCredito.calcularFatura();
                }
                if (conta instanceof Poupanca){
                    Poupanca contaPoupanca = (Poupanca) conta;
                    contaPoupanca.rendimento();
                }
            }
        }
    }
    public static void geraDados(){
        Pessoa pessoaFisica1 = new Fisica("Rua Garcia", 123456789, "João da Silva");
        Pessoa pessoaFisica2 = new Fisica("Rua Marcio", 987654321, "Maria da Silva");
        Pessoa pessoaJuridica1 = new Juridica("Rua Leopoldo", 123456789, "Matheus da Cunha");
        Pessoa pessoaJuridica2 = new Juridica("Rua Polonia", 987654321, "Mario do Salvo");
        Conta contaCorrente1 = new Corrente(123, "123", 200, pessoaFisica1, 1000);
        Conta contaCorrente2 = new Corrente(222, "222", 2000, pessoaFisica2, 2000);
        Conta contaCredito1 = new Credito(456, "456", 0, pessoaJuridica1, 1000);
        Conta contaCredito2 = new Credito(654, "654", 0, pessoaJuridica2,3000);
        Conta contaPoupanca1 = new Poupanca(789, "789", 1000, pessoaFisica1, 2);
        Conta contaPoupanca2 = new Poupanca(987, "987", 100, pessoaFisica2,1);

        nuBanco.cadastrarConta(contaCorrente1);
        System.out.println("Conta Corrente 1 cadastrada com sucesso");
        nuBanco.cadastrarConta(contaCorrente2);
        System.out.println("Conta Corrente 2 cadastrada com sucesso");
        nuBanco.cadastrarConta(contaCredito1);
        System.out.println("Conta Credito 1 cadastrada com sucesso");
        nuBanco.cadastrarConta(contaCredito2);
        System.out.println("Conta Credito 2 cadastrada com sucesso");
        nuBanco.cadastrarConta(contaPoupanca1);
        System.out.println("Conta Poupanca 1 cadastrada com sucesso");
        nuBanco.cadastrarConta(contaPoupanca2);
        System.out.println("Conta Poupanca 2 cadastrada com sucesso");
    }
}
