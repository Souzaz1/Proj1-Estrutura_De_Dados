
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

    private int movimentos;
    private int qtdDiscos;

    public JogoHanoi(int qtdDiscos) {
        this.qtdDiscos = qtdDiscos;
        iniciarJogo();
    }

    // Inicializa as torres e empilha a primeira torre com os discos
    public void iniciarJogo() {
        t1 = new Torre("T1", qtdDiscos);
        t2 = new Torre("T2", qtdDiscos);
        t3 = new Torre("T3", qtdDiscos);

        movimentos = 0;

        for (int i = qtdDiscos; i >= 1; i--) {
            t1.empilhar(new Disco(i));
        }
    }

    // Valida e move o disco entre as torres seguindo as regras da Torre de Hanoi
    public void mover(int origem, int destino) {
        Torre tOrigem = escolherTorre(origem);
        Torre tDestino = escolherTorre(destino);

        if (tOrigem == null || tDestino == null) {
            System.out.println("Torre inválida!");
            return;
        }

        if (tOrigem == tDestino) {
            System.out.println("Movimento inválido!");
            return;
        }

        if (tOrigem.estaVazia()) {
            System.out.println("Torre de origem vazia!");
            return;
        }

        Disco discoOrigem = tOrigem.topo();

        // Valida a regra: disco maior não pode ficar sobre um menor
        if (!tDestino.estaVazia() && 
            discoOrigem.getTamanho() > tDestino.topo().getTamanho()) {
            System.out.println("Movimento inválido!");
            return;
        }

        tDestino.empilhar(tOrigem.desempilhar());
        movimentos++;
    }

    // Converte o número para o objeto Torre correspondente
    private Torre escolherTorre(int num) {
        if (num == 1) return t1;
        if (num == 2) return t2;
        if (num == 3) return t3;
        return null;
    }

    // Mostra as torres na vertical
    public void mostrarTorres() {
        System.out.println("\n--- Estado Atual ---");
        System.out.println("Movimentos: " + movimentos + "\n");

        // Define o espaçamento entre as torres 
        int larguraColuna = qtdDiscos + 4; 

        // Loop do topo até a base para imprimir 
        for (int nivel = qtdDiscos - 1; nivel >= 0; nivel--) {
            imprimirNivel(t1, nivel, larguraColuna);
            imprimirNivel(t2, nivel, larguraColuna);
            imprimirNivel(t3, nivel, larguraColuna);
            System.out.println(); // Pula linha após imprimir o andar das 3 torres
        }
        
        // Imprime a base com os nomes (T1, T2, T3) alinhados
        System.out.printf("%-" + larguraColuna + "s", "T1");
        System.out.printf("%-" + larguraColuna + "s", "T2");
        System.out.printf("%-" + larguraColuna + "s", "T3");
        System.out.println("\n--------------------\n");
    }

    // Imprime o andar da torre específica
    private void imprimirNivel(Torre t, int nivel, int largura) {
        Disco d = t.getDisco(nivel);
        
        // Se tiver disco, pega os asteriscos. Se não, deixa em branco 
        String desenho = (d != null) ? d.toString() : ""; 
        
        System.out.printf("%-" + largura + "s", desenho);
    }

    public void reiniciar() {
        iniciarJogo();
    }

    // Vence o jogo quando todos os discos chegam na última torre T3 
    public boolean venceu() {
        return t3.tamanho() == qtdDiscos;
    }

    public int getMovimentos() {
        return this.movimentos; 
    }
}
