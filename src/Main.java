public class Main {
    public static void main(String[] args) {
        ArvoreAVL tree =  new ArvoreAVL();

        tree.inserir(1);
        tree.inserir(12);
        tree.inserir(3);
        tree.inserir(13);
        tree.inserir(11);
        tree.inserir(5);
        tree.imprimirEmOrdem();
        tree.delete(5);
        tree.imprimirEmOrdem();
        tree.ImprimirBusca(tree.busca(5));
    }
}