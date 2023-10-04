public class Node {
    int informacao;
    Node filhoDireita;
    Node filhoEsquerda;

    int altura;

    public Node(){
        this.informacao = 0;
        this.filhoDireita = null;
        this.filhoEsquerda = null;
        this.altura = 0;
    }
}
