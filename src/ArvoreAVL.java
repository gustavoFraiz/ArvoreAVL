public class ArvoreAVL {
    Node raiz;
    Node atual;

    public ArvoreAVL(){
        this.raiz = null;
        this.atual = null;
    }

    private int altura(Node node )
    {
        return node == null ? -1 : node.altura;
    }
    private int alturaMaxima(int alturaEsquerda, int alturaDireita)
    {
        return alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;
    }


    public void inserir(int informacao){
        raiz = inserir(raiz, informacao);
    }

    public Node inserir(Node node, int informacao){
        if(node == null){
            node = new Node(informacao);
        } // certo
        else if(informacao < node.informacao){
            node.filhoEsquerda = inserir(node.filhoEsquerda, informacao);
            if(altura(node.filhoEsquerda) - altura(node.filhoDireita) == 2){
                if(informacao < node.filhoEsquerda.informacao){node = rotacaoEsquerda(node);}
                else{node = rotacaoDuplaEsquerda(node);}
            }
        } // certo
        else if(informacao > node.informacao){
            node.filhoDireita = inserir(node.filhoDireita, informacao);
            if(altura(node.filhoDireita) - altura(node.filhoEsquerda) == 2){
                if(informacao > node.filhoDireita.informacao){node = rotacaoDireita(node);}
                else{node = rotacaoDuplaDireita(node);}
            }
        }
        else{;}
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


    public Node busca(int informacao){
        if(this.raiz == null){
            return null;
        }
        else{
            return busca(raiz, informacao);
        }
    }

    public Node busca(Node node, int informacao){
        if(node.informacao == informacao){return node;}
        else if(node.informacao > informacao){
            if(node.filhoEsquerda != null){return busca(node.filhoEsquerda, informacao);}
            else{return null;}
        }
        else{
            if(node.filhoDireita != null){return busca(node.filhoDireita, informacao);}
            else{return null;}
        }
    }

    public void ImprimirBusca(Node node){
        if(node == null){
            System.out.println("Nao foi achado esse elemento na arvore");
        }
        else{
            System.out.println(node.informacao);
        }
    }

    public void imprimirEmOrdem()
    {
        imprimirEmOrdem(raiz);
    }
    private void imprimirEmOrdem(Node head)
    {
        if (head != null)
        {
            imprimirEmOrdem(head.filhoEsquerda);
            System.out.print(head.informacao+" ");
            imprimirEmOrdem(head.filhoDireita);
        }
    }
}

