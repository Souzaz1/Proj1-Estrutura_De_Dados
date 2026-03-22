package proj1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a quantidade de discos para iniciar o jogo: ");
        int qtdDiscos = scanner.nextInt();

        try {
            JogoHanoi jogo = new JogoHanoi(qtdDiscos);
            jogo.iniciarSimulacao();
        } catch (Exception e) {
            System.out.println("Erro ao iniciar a aplicacao: " + e.getMessage());
        }
        
        scanner.close();
    }
}
