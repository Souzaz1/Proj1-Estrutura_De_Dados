package proj1; 

public class Torre {
    private Pilha<Disco> pilhaDeDiscos;

    public Torre(int capacidade) {
        this.pilhaDeDiscos = new Pilha<Disco>(capacidade);
    }

    public void empilhar(Disco d) throws Exception {
        pilhaDeDiscos.push(d);
    }

    public Disco desempilhar() throws Exception {
        return pilhaDeDiscos.pop();
    }

    public Disco verTopo() throws Exception {
        return pilhaDeDiscos.topo();
    }

    public boolean isVazia() {
        return pilhaDeDiscos.isEmpty();
    }
    
    // Método que repassa a chamada para o getElemento da pilha
    public Disco getDiscoNaPosicao(int index) {
        return pilhaDeDiscos.getElemento(index);
    }
}
