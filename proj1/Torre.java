
/* 
-------- Projeto Torre de Hanoi -------- 
Lucas dos Santos Bartolomeu RA: 10747984
Gabriel Pereira de Souza    RA: 10440766
Joaquim Lange Lima Amaral   RA: 10738376
*/

public class Torre {

    private String nome;
    private Pilha<Disco> pilha;

    public Torre(String nome, int capacidade) {
        this.nome = nome;
        this.pilha = new Pilha<>(capacidade);
    }

    public String getNome() {
        return nome;
    }

    public void empilhar(Disco disco) {
        pilha.push(disco);
    }

    public Disco desempilhar() {
        return pilha.pop();
    }

    public Disco topo() {
        return pilha.topo();
    }

    public boolean estaVazia() {
        return pilha.isEmpty();
    }

    public int tamanho() {
        return pilha.sizeElements();
    }

    public String toString() {
        return pilha.toString();
    }
}
