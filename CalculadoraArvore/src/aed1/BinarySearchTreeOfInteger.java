package aed1;

import java.util.Queue;

public class BinarySearchTreeOfInteger {
    
    // Classe interna privada
    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        public Integer element;
        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    
    // Atributos        
    private int count; //contagem do numero de nodos
    private Node root; //referencia para o nodo raiz


    // Metodos
    public BinarySearchTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;      
    }
    
    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }
    
	// Conta o numero de nodos da arvore	
    public int count() {
        return count(root);
    }

	// Conta o numero de nodos a partir da subarvore cuja referencia  
	// para a raiz esta sendo passada por parametro
    private int count(Node n) {// TODO
		// Implemente este metodo
        return 0;
    }

    public void add(Integer element) {
        root = add(root, element, null);
        count++;
    }
    private Node add(Node n, Integer e, Node father) {// TODO
        // Implemente este método
        return null;
    }

    private Node searchNodeRef(Integer element, Node n) {// TODO
        // Implemente este metodo 
        return null;
    }        
    
    public Integer getLeft(Integer element) {
        Integer res = null;
        Node nAux = searchNodeRef(element, root);
        if (nAux != null) {
            if (nAux.left != null) {
                res = nAux.left.element;
            }
        }
        return res;
    }

    public Integer getRight(Integer element) {// TODO
        // Implemente este metodo 
        return 0;
    }

    public Integer getParent(Integer element) {// TODO
        // Implemente este metodo         
        return 0;
    }

    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }
    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a subarvore esquerda
            positionsPreAux(n.right, res); //Visita a subarvore direita
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }
    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left, res); //Visita a subarvore esquerda
            positionsPosAux(n.right, res); //Visita a subarvore direita
            res.add(n.element); //Visita o nodo
        }
    }

    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }
    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subarvore esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subarvore direita
        }
    }

    public LinkedListOfInteger positionsWidth() {// TODO
//        Queue<Node> fila = new Queue<>();
        LinkedListOfInteger res = new LinkedListOfInteger();
        // Implemente este metodo         
        return res;
    }

    public String strTraversalPre() {
        return strTraversalPre(root);
    }
    private String strTraversalPre(Node n) {// TODO
        String res = "";
        // Implemente este metodo
        return res;
    }

    public String strTraversalPos() {
        return strTraversalPos(root);
    }
    private String strTraversalPos(Node n) {// TODO
        String res = "";
        // Implemente este metodo
        return res;
    }

    public String strTraversalCentral() {
        return strTraversalCentral(root);
    }
    private String strTraversalCentral(Node n) {// TODO
        String res = "";
        // Implemente este metodo
        return res;
    }

    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }


    public boolean remove(Integer element) {// TODO
        // Implemente este metodo
        return true;
    }

    private Node smallest(Node n) {// TODO
        // Implemente este metodo sabendo que ele deve
        // retornar o menor elemento da subarvore 
        // passada por parametro.
        return null;
    }

    public boolean removeBranch(Integer element) {// TODO
        // Implemente este metodo
        return false;
    }

    public int height() {// TODO
        //Implemente este metodo (de preferencia de forma recursiva)
        return 0;
    }
     
    public Integer set(Integer old, Integer element) {// TODO
        // Implemente este metodo lembrando que a arvore
        // deve continuar ordenada
        return 0;
    }

    public boolean isRoot(Integer element) {
        if (root != null) {
            if (root.element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int level(Integer element) {// TODO
        //Implemente este metodo
        return 0;
    }    
    
}
