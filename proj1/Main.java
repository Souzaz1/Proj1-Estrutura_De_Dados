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
        int n = 0;
        boolean nValido = false; 

        // Entrada e validação da quantidade de discos
        while (!nValido) {
            System.out.print("Digite a quantidade de discos: "); 
            if (sc.hasNextInt()) { 
                n = sc.nextInt(); 
                if (n > 0 && n <= 100) { 
                    nValido = true;
                } else { 
                    System.out.println("Erro, por favor escolha um número entre 1 a 100 no máximo (recomendado entre 1 a 20).");
                }
            } else { 
                System.out.println("Erro, isso não é um número inteiro. ");
                sc.next(); 
            }
        }

        JogoHanoi jogo = new JogoHanoi(n);
    
        int opcao = 0;

        // Loop para o menu e chamadas de métodos 
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
                        System.out.print("Parabéns Você Venceu!");
                        jogo.mostrarTorres(); 
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
