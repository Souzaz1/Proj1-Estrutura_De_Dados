import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Quantos discos deseja? ");
        int discos = entrada.nextInt();
        int menu = 0;
        do {
            System.out.println("1 - Mover discos\n2 - Mostrar torres\n3 - Reiniciar jogo\n4 - Sair\n");
            menu = entrada.nextInt();
            
            

        } while (menu != 4);
        entrada.close();
    }
}


public class Disco {
    private int TamDisco; 


}


public class Torre {

}


public class JogoHanoi {

}
