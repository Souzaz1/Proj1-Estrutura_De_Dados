
/* 
-------- Projeto Torre de Hanoi -------- 
Lucas dos Santos Bartolomeu RA: 10747984
Gabriel Pereira de Souza    RA: 10440766
Joaquim Lange Lima Amaral   RA: 10738376
*/

public class JogoHanoi {

    private Torre t1;
    private Torre t2;
    private Torre t3;

    public int movimentos;
    private int qtdDiscos;

    public JogoHanoi(int qtdDiscos) {
        this.qtdDiscos = qtdDiscos;
        iniciarJogo();
    }

    public void iniciarJogo() {
        t1 = new Torre("T1", qtdDiscos);
        t2 = new Torre("T2", qtdDiscos);
        t3 = new Torre("T3", qtdDiscos);

        movimentos = 0;

        for (int i = qtdDiscos; i >= 1; i--) {
            t1.empilhar(new Disco(i));
        }
    }

    public void mover(int origem, int destino) {
        Torre tOrigem = escolherTorre(origem);
        Torre tDestino = escolherTorre(destino);

        if (tOrigem == null || tDestino == null) {
            System.out.println("Torre inválida!");
            return;
        }

        if (tOrigem.estaVazia()) {
            System.out.println("Torre de origem vazia!");
            return;
        }

        Disco discoOrigem = tOrigem.topo();

        if (!tDestino.estaVazia() && 
            discoOrigem.getTamanho() > tDestino.topo().getTamanho()) {
            System.out.println("Movimento inválido!");
            return;
        }

        tDestino.empilhar(tOrigem.desempilhar());
        movimentos++;
    }

    private Torre escolherTorre(int num) {
        if (num == 1) return t1;
        if (num == 2) return t2;
        if (num == 3) return t3;
        return null;
    }

    public void mostrarTorres() {
        System.out.println("\n--- Estado Atual ---");
        System.out.println("Movimentos: " + movimentos);
        System.out.println("T1: " + t1.toString());
        System.out.println("T2: " + t2.toString());
        System.out.println("T3: " + t3.toString());
        System.out.println("--------------------\n");
    }

    public void reiniciar() {
        iniciarJogo();
    }

    public boolean venceu() {
        return t3.tamanho() == qtdDiscos;
    }
}