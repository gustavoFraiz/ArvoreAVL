public class ArvoreAVL {
    Node raiz;

    public ArvoreAVL(){
        this.raiz = null;
    }

    public int altura(Node node){
        if(node == null){return -1;}
        int esquerda = altura(node.filhoEsquerda);
        int direita = altura(node.filhoDireita);
        if(esquerda > direita){return 1 + esquerda;}
        else{
            return 1 + direita;
        }
    }
    private int alturaMaxima(int alturaEsquerda, int alturaDireita)
    {
        return alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;
    }


    public void inserir(int informacao){
        inserir(raiz, informacao);
    }

    public Node inserir(Node node, int informacao){
        if(node == null){
            node = new Node();
            node.informacao = informacao;
        }
        else if(informacao < node.informacao){
            node.filhoEsquerda = inserir(node.filhoEsquerda, informacao);
            if(altura(node.filhoEsquerda) - altura(node.filhoDireita) == 2){
                if(informacao < node.filhoEsquerda.informacao){node = rotacaoEsquerda(node);}
                else{node = rotacaoDuplaEsquerda(node);}
            }
        }
        else if(informacao > node.informacao){
            node.filhoDireita = inserir(node.filhoDireita, informacao);
            if(altura(node.filhoEsquerda) - altura(node.filhoDireita) == 2){
                if(informacao > node.filhoDireita.informacao){node = rotacaoDireita(node);}
                else{node = rotacaoDuplaDireita(node);}
            }
        }
        node.altura = alturaMaxima(altura(node.filhoEsquerda), altura(node.filhoDireita)) + 1;
        return node;
    }

    private Node rotacaoEsquerda(Node raiz){

        Node novaRaiz = raiz.filhoEsquerda;
        raiz.filhoEsquerda = novaRaiz.filhoDireita;
        novaRaiz.filhoDireita = raiz;
        return novaRaiz;
    }

    private Node rotacaoDuplaEsquerda(Node raiz){
        raiz.filhoEsquerda = rotacaoDireita(raiz.filhoEsquerda);
        return rotacaoEsquerda(raiz);
    }

    private Node rotacaoDireita(Node raiz){
        Node novaRaiz = raiz.filhoDireita;
        raiz.filhoDireita = novaRaiz.filhoEsquerda;
        novaRaiz.filhoEsquerda = raiz;
        return novaRaiz;
    }

    private Node rotacaoDuplaDireita(Node raiz){
        raiz.filhoDireita = rotacaoEsquerda(raiz.filhoDireita);
        return rotacaoDireita(raiz);
    }


    public void imprimirEmOrdem(Node node) {
        if (node != null) {
            imprimirEmOrdem(node.filhoEsquerda); // Visita o filho esquerdo
            System.out.print(node.informacao + " "); // Imprime o valor do nó
            imprimirEmOrdem(node.filhoDireita); // Visita o filho direito
        }
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
        System.out.println(); // Adicione uma quebra de linha para melhorar a formatação
    }
}
