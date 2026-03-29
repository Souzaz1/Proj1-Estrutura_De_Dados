import java.util.Scanner;

/* 
-------- Projeto Torre de Hanoi -------- 
Lucas dos Santos Bartolomeu RA: 10747984
Gabriel Pereira de Souza    RA: 10440766
Joaquim Lange Lima Amaral   RA: 10738376
*/


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a quantidade de discos: ");
        int n = sc.nextInt();

        JogoHanoi jogo = new JogoHanoi(n);

        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n1 - Mover disco");
            System.out.println("2 - Mostrar torres");
            System.out.println("3 - Reiniciar jogo");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Origem (1,2,3): ");
                    int origem = sc.nextInt();

                    System.out.print("Destino (1,2,3): ");
                    int destino = sc.nextInt();

                    jogo.mover(origem, destino);
                    if (jogo.venceu()) {
                        System.out.print("--- VOCÊ VENCEU! ---");
                        System.out.println("\nMovimentos realizados até vencer: " + jogo.movimentos);
                        opcao = 4;
                    } 
                    break;

                case 2:
                    jogo.mostrarTorres();
                    break;

                case 3:
                    jogo.reiniciar();
                    System.out.println("Jogo reiniciado!");
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}