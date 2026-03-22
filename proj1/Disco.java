public class Disco {

    private int tamanho;

    public Disco(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return String.valueOf(tamanho);
    }
}