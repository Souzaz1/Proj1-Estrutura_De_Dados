package proj1;

import java.util.Scanner;

public class JogoHanoi {
    private Torre[] torres;
    private int quantidadeDiscos;
    private int jogadas;

    public JogoHanoi(int quantidadeDiscos) {
        this.quantidadeDiscos = quantidadeDiscos;
        this.torres = new Torre[3];
        
        // Inicializa as 3 torres
        for (int i = 0; i < 3; i++) {
            torres[i] = new Torre(quantidadeDiscos);
        }
    }

    public void inicializarJogo() {
        try {
            // Esvazia as torres (caso seja um reinício)
            for (int i = 0; i < 3; i++) {
                while (!torres[i].isVazia()) {
                    torres[i].desempilhar();
                }
            }
            
            this.jogadas = 0;

            // Empilha os discos na Torre 1 (índice 0), do maior para o menor
            for (int i = quantidadeDiscos; i >= 1; i--) {
                torres[0].empilhar(new Disco(i));
            }
            System.out.println("\nJogo inicializado com " + quantidadeDiscos + " discos.");
        } catch (Exception e) {
            System.out.println("Erro ao inicializar: " + e.getMessage());
        }
    }

    public void iniciarSimulacao() {
        inicializarJogo();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- TORRE DE HANOI ---");
            System.out.println("1 - Mover disco");
            System.out.println("2 - Mostrar torres");
            System.out.println("3 - Reiniciar jogo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opcao: ");
            
            // Verificação simples para evitar quebra se o usuário digitar letras
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                scanner.next(); // Limpa o buffer
                System.out.println("Por favor, digite um numero valido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    realizarMovimento(scanner);
                    verificarVitoria();
                    break;
                case 2:
                    mostrarTorres();
                    break;
                case 3:
                    inicializarJogo();
                    break;
                case 4:
                    System.out.println("Saindo do jogo... Ate mais!");
                    break;
                default:
                    System.out.println("Opcao invalida! Escolha entre 1 e 4.");
            }
        }
        scanner.close();
    }

    private void realizarMovimento(Scanner scanner) {
        System.out.print("Mover da Torre (1, 2 ou 3): ");
        int origem = scanner.nextInt() - 1;
        System.out.print("Para a Torre (1, 2 ou 3): ");
        int destino = scanner.nextInt() - 1;

        if (origem < 0 || origem > 2 || destino < 0 || destino > 2) {
            System.out.println("Erro: Torre invalida. Escolha 1, 2 ou 3.");
            return;
        }

        try {
            Torre tOrigem = torres[origem];
            Torre tDestino = torres[destino];

            // Regra: Não pode mover de uma torre vazia
            if (tOrigem.isVazia()) {
                System.out.println("Erro: A torre de origem esta vazia.");
                return;
            }

            Disco discoMovido = tOrigem.verTopo();

            // Regra: Um disco maior nunca pode ficar sobre um disco menor
            if (!tDestino.isVazia()) {
                Disco discoDestino = tDestino.verTopo();
                if (discoMovido.getTamanho() > discoDestino.getTamanho()) {
                    System.out.println("Erro: Movimento invalido! Um disco maior (" + discoMovido.getTamanho() + 
                                       ") nao pode ficar sobre um menor (" + discoDestino.getTamanho() + ").");
                    return;
                }
            }

            // Se passou nas regras, faz o movimento
            tDestino.empilhar(tOrigem.desempilhar());
            jogadas++;
            System.out.println("Disco movido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro inesperado ao mover: " + e.getMessage());
        }
    }

    private void mostrarTorres() {
        System.out.println();
        
        // Garante que a coluna tenha pelo menos o tamanho da palavra "TORRE_X" (7 letras) + 2 de espaçamento
        int larguraColuna = Math.max(quantidadeDiscos, 7) + 2; 

        // Imprime os discos de cima para baixo
        for (int linha = quantidadeDiscos - 1; linha >= 0; linha--) {
            for (int t = 0; t < 3; t++) {
                Disco d = torres[t].getDiscoNaPosicao(linha);
                String espacoColuna = String.format("%-" + larguraColuna + "s", gerarAsteriscos(d));
                System.out.print(espacoColuna);
            }
            System.out.println();
        }
        
        // Imprime os nomes das torres perfeitamente alinhados com as colunas acima
        for (int t = 1; t <= 3; t++) {
            System.out.print(String.format("%-" + larguraColuna + "s", "TORRE_" + t));
        }
        System.out.println("\n");
    }

    private String gerarAsteriscos(Disco d) {
        if (d == null) return "";
        return "*".repeat(d.getTamanho()); // Usando o método repeat do Java 11+
    }

    private void verificarVitoria() {
        try {
            // Se a Torre 3 tiver a quantidade total de discos, o jogo acabou
            // (Poderia ser a Torre 2 também, dependendo da interpretação, mas a 3 é o padrão)
            if (torres[2].isVazia() == false) {
                // Checa o tamanho da pilha iterando, ou se a quantidade no array for igual ao total
                int count = 0;
                for(int i=0; i < quantidadeDiscos; i++){
                    if(torres[2].getDiscoNaPosicao(i) != null) count++;
                }
                
                if (count == quantidadeDiscos) {
                    System.out.println("\nPARABENS! Voce resolveu a Torre de Hanoi!");
                    System.out.println("Total de movimentacoes: " + jogadas);
                    mostrarTorres();
                    System.out.println("Reiniciando o jogo automaticamente...\n");
                    inicializarJogo();
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar vitoria.");
        }
    }
}
