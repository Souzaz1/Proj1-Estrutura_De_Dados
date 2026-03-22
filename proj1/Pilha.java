package proj1; 

public class Pilha<T> {
    private static final int TAM_DEFAULT = 100;
    private int topoPilha;
    private T elementos[];

    @SuppressWarnings("unchecked")
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

    public void push(T e) throws Exception {
        if (!this.isFull()) {
            this.elementos[++topoPilha] = e;
        } else {
            throw new Exception("Overflow - Estouro de Pilha.");
        }
    }

    public T pop() throws Exception {
        if (!this.isEmpty()) {
            T temp = this.elementos[topoPilha];
            topoPilha--;
            return temp;
        } else {
            throw new Exception("Underflow - Esvaziamento de Pilha.");
        }
    }
    
    public T topo() throws Exception {
        if (!this.isEmpty()) {
            return this.elementos[topoPilha];
        } else {
            throw new Exception("Underflow - Pilha Vazia.");
        }
    }

    public int sizeElements() {
        return topoPilha + 1;
    }

    public T getElemento(int index) {
        if (index >= 0 && index <= topoPilha) {
            return this.elementos[index];
        }
        return null;
    }
}
