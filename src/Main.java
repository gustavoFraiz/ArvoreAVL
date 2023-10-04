public class Main {
    public static void main(String[] args) {
        ArvoreAVL tree =  new ArvoreAVL();

        tree.inserir(7);
        tree.inserir(12);
        tree.inserir(3);
        tree.inserir(13);
        tree.inserir(11);
        tree.inserir(5);
        tree.imprimirEmOrdem();
//        tree.delete(tree.raiz, 13);
//        tree.delete(tree.raiz, 5);
//        tree.delete(tree.raiz, 11);
//        tree.imprimirEmOrdem();
//        tree.ImprimirBusca(tree.busca(123));
    }
}