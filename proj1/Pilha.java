
/* 
-------- Projeto Torre de Hanoi -------- 
Lucas dos Santos Bartolomeu RA: 10747984
Gabriel Pereira de Souza    RA: 10440766
Joaquim Lange Lima Amaral   RA: 10738376
*/

public class Pilha<T> {
    private static final int TAM_DEFAULT = 100;
    private int topoPilha;
    private T elementos[];

    public Pilha(int tamanho) {
        this.elementos = (T[]) new Object[tamanho];
        this.topoPilha = -1;
    }

    public Pilha() {
        this(TAM_DEFAULT);
    }

    public boolean isEmpty() {
        return topoPilha == -1;
    }

    public boolean isFull() {
        return topoPilha == elementos.length - 1;
    }

    public void push(T e) {
        if (!this.isFull()) {
            this.elementos[++topoPilha] = e;
        } else {
            System.out.println("Overflow - Estouro de Pilha.");
        }
    }

    public T pop() {
        if (!this.isEmpty()) {
            return this.elementos[topoPilha--];
        } else {
            System.out.println("Underflow - Esvaziamento de Pilha.");
            return null;
        }
    }

    public T topo() {
        if (!this.isEmpty()) {
            return this.elementos[topoPilha];
        } else {
            System.out.println("Underflow - Esvaziamento de Pilha.");
            return null;
        }
    }

    public int sizeElements() {
        return topoPilha + 1;
    }

    public String toString() {
        if (isEmpty()) {
            return "[ Vazia ]";
        }
        
        String resultado = "\n"; // Começa com uma quebra de linha para alinhar melhor
        
        // Percorre do topo (sizeElements - 1) até a base (0)
        for (int i = sizeElements() - 1; i >= 0; i--) {
            resultado += elementos[i].toString() + "\n";
        }
        
        return resultado;
    }

    public T getElemento(int index) {
        if (index >= 0 && index <= topoPilha) {
            return elementos[index];
        }
        return null; // Retorna nulo se não tiver disco nessa altura
    }
}
