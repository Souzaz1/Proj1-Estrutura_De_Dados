public class Pilha <T> {
    private static final int TAM_DEFAUL = 200;
    private T elementos[];
    private int topoPilha;

    public Pilha(int tamanho) {
        this.elementos = (T[]) new Object[tamanho];
        this.topoPilha = -1;
    }

    public Pilha() {
        this(TAM_DEFAUL);
    }

    public boolean isEmpty() {
        return this.topoPilha == -1;
    }

    public boolean isFull() {
        return this.topoPilha == this.elementos.length-1;
    }

    public void push(T e) throws Exception {
        if (!this.isFull()) {
            topoPilha++;
            this.elementos[topoPilha] = e;
        } else {
            throw new Exception("Overflow - Estouro de Pilha");
        }
    }

    public T pop() throws Exception {
        if (!this.isEmpty()) {
            return this.elementos[this.topoPilha--];
        } else {
            throw new Exception("Underflow - Esvaziamento de Pilha");
        }
    }

    public T topo() throws Exception {
        if(!this.isEmpty()) {
            return this.elementos[this.topoPilha];
        } else {
            throw new Exception("Underflow - Esvaziamento de Pilha");
        }
    }

    public int sizeElementos() {
        return topoPilha +1;
    }
    
}

