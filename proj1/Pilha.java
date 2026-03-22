public class Pilha <T> { // PILHA GENÉRICA
    // atributos
    private static final int TAM_DEFAULT = 100; // cria uma constante
    private int topoPilha;
    private T elementos[];

    // construtores
    public Pilha(int tamanho) {
        this.elementos = (T[]) new Object[tamanho]; /* Outras classes herdam de Object*/ 
        /* Todo objeto da classe pai pode ser atribuido à ele um objeto da classe filho sendo possível o type casting */ 
        this.topoPilha = -1;
}

    public Pilha() {
        this(TAM_DEFAULT); // chama o outro construtor Pilha(int tamanho) caso o usuário não queira passar o tamanho da pilha.
    }

    // métodos 

    public boolean isEmpty() {
        if (topoPilha == -1) 
            return true; 
        else 
            return false;  
        // poderia usar o return this.topoPilha == -1;      
    }

    public boolean isFull() {
        return topoPilha == elementos.length - 1;
    }

    public void push(T e) throws Exception {
        if (!this.isFull()) {
            //topoPilha++;
            this.elementos[++topoPilha] = e;
        }
        else {
            throw new Exception("Overflow - Estouro de Pilha.");
        }
    }

    public T pop() throws Exception {
        if (!this.isEmpty()) {
            T temp = this.elementos[topoPilha];
            topoPilha--;
            return temp;
        }
        else { 
            throw new Exception("Underflow - Esvaziamento de Pilha.");
        }
    }
    
    public T topo() throws Exception {
        if (!this.isEmpty()) {
            return this.elementos[topoPilha];
        }
        else { 
            throw new Exception("Underflow - Esvaziamento de Pilha.");
        }
    }

    public int sizeElements() {
        return topoPilha + 1;
    }
}
