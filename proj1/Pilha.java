
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
        String resultado = "[";
        for (int i = 0; i < sizeElements(); i++) {
            resultado += elementos[i].toString();
            if (i < sizeElements() - 1) {
                resultado += ", "; 
            }
        }
        resultado += "] ";
        return resultado;
    }
}
