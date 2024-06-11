import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {

    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {

    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }

}

public class Desafio {
    public static void main(String[] args) {
        // Lê o tipo de cofre (primeira linha da entrada)
        Scanner scanner = new Scanner(System.in);
        String tipoCofre = scanner.nextLine();

        // Implementação da lógica para criar e exibir os cofres
        if (tipoCofre.equalsIgnoreCase("digital")) {
            // Se o tipo de cofre for digital, solicita a senha e a confirmação
            int senha = scanner.nextInt();
            int confirmacaoSenha = scanner.nextInt();

            // Verifica se a senha é válida
            CofreDigital cofreDigital = new CofreDigital(senha);
            if (cofreDigital.validarSenha(confirmacaoSenha)) {
                cofreDigital.imprimirInformacoes();
                System.out.println("Cofre aberto!");
            } else {
                cofreDigital.imprimirInformacoes();
                System.out.println("Senha incorreta!");
            }
        } else if (tipoCofre.equalsIgnoreCase("fisico")) {
            // Se o tipo de cofre for físico, cria o cofre físico e exibe suas informações
            CofreFisico cofreFisico = new CofreFisico();
            cofreFisico.imprimirInformacoes();
        }

        scanner.close();
    }
}
