package treeCalculator;



/**
 *
 * @author Doug
 */
public class BinaryTree {

	private Node root;
	private int count;
	private boolean opExterna;
	private Node ref;
	private int altura = 0;
	private double total = 0;
	private int numFolhas = 0;

	public BinaryTree() {
		root = null;
		count = 0;
		opExterna = false;
	}

	private class Node {

		private Node father;
		private Node left;
		private Node right;
		private String element;

		public Node() {
			father = null;
			left = null;
			right = null;
			element = null;
		}

		public Node(String s) {
			father = null;
			left = null;
			right = null;
			element = s;
		}

		public void set(String s) {			
			element = s;			
		}
	}

	/////////////////////// |||||||||||||||||||||||||||||||||||||||||||||||||||||||\\\\\\\\\\\\\\\\\\\\\
	// #################### Métodos TAD padrão de BinaryTree
	/////////////////////// ####################\\
	// Add Root boole
	// Add Left boole
	// Add Right boole
	// Has Left boole ---------- ok
	// Has Right boole ---------- ok
	// Get Parent(e) num ---------- ok
	// Get Left (e) num ---------- ok
	// Get Right (e) num ---------- ok
	// Get Root num ---------- ok
	// Set Root(e) void ---------- ok
	// Is External (e) boole ---------- ok
	// Is Internal (e) boole (REDUNDANTE)
	// Remove Branch (e) boole (ADAPTADO) ---------- ok
	// Constains (e) boole ---------- ok
	// Is Empty boole ---------- ok
	// clear void ---------- ok
	// size int ---------- ok
	// Positions Pre linkedList ---------- ok
	// Positions Pos linkedList ---------- ok
	// Positions Central linkedList ---------- ok
	// Positions Width linkedList
	/////////////////////// |||||||||||||||||||||||||||||||||||||||||||||||||||||||\\\\\\\\\\\\\\\\\\\\\
	// #################### Métodos auxiliares aos métodos padrão
	/////////////////////// ####################\\

	public Node search(String element) {
		return searchNode(root, element);
	}

	private Node searchNode(Node root, String element) {
		if (root != null) {
			if (root.element.equals(element)) {
				return root;
			} else {
				Node busca = searchNode(root.left, element);

				if (busca == null) {
					busca = searchNode(root.right, element);
				}
				return busca;
			}
		} else {
			return null;
		}
	}

	private int countNodes(Node s) {
		if (s == null) {
			return 0;
		} else {
			int C = 1;
			C += countNodes(s.left);
			C += countNodes(s.right);
			return C;
		}
	}

	/////////////////////// |||||||||||||||||||||||||||||||||||||||||||||||||||||||\\\\\\\\\\\\\\\\\\\\\
	public void add() {
		Node n = new Node();
		if (root == null) {
			root = n;
			ref = root;			
			count++;
			return;
		}
		if(ref == null) {//unica vez que o root � alterado
			ref = n;
			ref.left = root;
			root.father = ref;
			root = ref;
			count++;
			return;
		}
		if (ref.left == null) {
			ref.left = n;			
			n.father = ref;
			ref = ref.left;
			count++;
			return;
		}
		if (ref.right == null) {
			ref.right = n;
			n.father = ref;
			ref = ref.right;			
			count++;
			return;
		}
		ref = ref.father;
		add();
	}

	public void add(String s) {
		Node n = new Node(s);

		if (ref.left == null) {
			ref.left = n;
			n.father = ref;
			count++;
		} else {
			if (ref.right == null) {
				ref.right = n;
				n.father = ref;
				count++;
			}
		}
	}
	
	public void calcular() {
		if(ref != root) {
			System.out.println("ERRO: FALTAM ')' PARA FECHAR! ");
			return;
		}
		while(!ehFolha(root))
			calcular(root);
	}
	
	private void calcular(Node n) {
		if(n == null) {
			return;
		}
		if(filhosFolhas(n)) {
			double elemento1 = Double.parseDouble(n.left.element);
			double elemento2 = Double.parseDouble(n.right.element);
			double resultado = 0;
			switch (n.element) {
            case "+":
                resultado = elemento1 + elemento2;
                break;
            case "-":
            	resultado = elemento1 - elemento2;
                break;
            case "*":
            	resultado = elemento1 * elemento2;
                break;
            case "/":
            	resultado = elemento1 / elemento2;
                break;
            case "^":
            	resultado = Math.pow(elemento1, elemento2);
                break;
			}
			n.left = null;count--;
			n.right = null;count--;
			n.set(""+resultado);
			close();
		}else {
			if(!ehFolha(n.left)) {
				calcular(n.left);
			}else {
				if(!ehFolha(n.right)) {
					calcular(n.right);
				}
			}
		}
	}

	private boolean estaCompleto(Node n) {
		return (n.left != null && n.right != null);
	}

	private boolean ehFolha(Node n) {
		if(n != null)
			return (n.left == null && n.right == null);
		return false;
	}
	
	public boolean filhosFolhas(Node n) {
		if(n != null)
			if(n.left != null && n.right != null)
				return (ehFolha(n.left) && ehFolha(n.right));
		return false;
	}

	public void addOperador(String operador) throws FaltaDeParentesesException {
		Node n = new Node(operador);
			if (ref == null) {			
				ref = n;
				root.father = n;
				root = n;			
				
				count++;
				return;
			}else {
				if(ref.element == null) {
					ref.set(operador);
				}else {
					throw new FaltaDeParentesesException();
				}
			}
		}

	public void close() {
		if (ref == root) {
			return;
		}else
			ref = ref.father;
	}

	public boolean addLeft(String s) {
		return false;
	}

	public boolean addRight(String s) {
		return false;
	}

	public boolean hasLeft(String element) {
		if (search(element) == null) {
			return false;
		}
		return search(element).left.element != null;
	}

	public boolean hasRight(String element) {
		if (search(element) == null) {
			return false;
		}
		return search(element).right.element != null;
	}

	public String getParent(String element) {
		if (search(element) == null) {
			return null;
		} else {
			return search(element).element;
		}
	}

	public String getLeft(String element) {
		if (search(element) == null) {
			return null;
		} else {
			return search(element).left.element;
		}
	}

	public String getRight(String element) {
		if (search(element) == null) {
			return null;
		} else {
			return search(element).right.element;
		}
	}

	public String getRoot() {
		return root.element;
	}

	public void setRoot(String n) {
		root.element = n;
	}

	public boolean isExternal(Node s) {
		return s.right == null && s.left == null;
	}

	public boolean removeNodeBranch(Node s) {
		s.father = null;
		return true;
	}

	public boolean contains(String element) {
		Node nAux = searchNode(root, element);
		return (nAux != null);
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public void clear() {
		count = 0;
		root = null;
	}

	public int size() {
		return count;
	}

	public LinkedList positionsPre() {
		LinkedList res = new LinkedList();
		positionsPreAux(root, res);
		return res;
	}

	private void positionsPreAux(Node n, LinkedList res) {
		if (n != null) {
			res.add(n.element); // Visita o nodo
			positionsPreAux(n.left, res); // Visita a subarvore esquerda
			positionsPreAux(n.right, res); // Visita a subarvore direita
		}
	}

	public LinkedList positionsPos() {
		LinkedList res = new LinkedList();
		positionsPosAux(root, res);
		return res;
	}

	private void positionsPosAux(Node n, LinkedList res) {		
		if (n != null) {
			
			positionsPosAux(n.left, res); // Visita a subarvore esquerda
			positionsPosAux(n.right, res); // Visita a subarvore direita
			res.add(n.element); // Visita o nodo
		}
	}

	public LinkedList positionsCentral() {
		LinkedList res = new LinkedList();
		positionsCentralAux(root, res);
		return res;
	}

	private void positionsCentralAux(Node n, LinkedList res) {
		if (n != null) {
			positionsCentralAux(n.left, res); // Visita a subarvore esquerda
			res.add(n.element); // Visita o nodo
			positionsCentralAux(n.right, res); // Visita a subarvore direita
		}
	}

	public LinkedList positionsWidth() {
		Queue<Node> fila = new Queue<>();
		LinkedList res = new LinkedList();
		if (root != null) {
			fila.enqueue(root);
			while (!fila.isEmpty()) {
				Node n = fila.dequeue();
				res.add(n.element);
				if (n.left != null) {
					fila.enqueue(n.left);
				}
				if (n.right != null) {
					fila.enqueue(n.right);
				}
			}
		}
		return res;
	}

	public String resultado() {
		if(root == ref) {
			return root.element;
		}
		return null;
	}

	public int altura() {		
		altura(root);
		return altura;
		
	}
	
	private void altura(Node n){
		if(n == null){
			return;
		}else{
			
				altura(n.left);				
			
				altura(n.right);
			if(ehFolha(n)){
				numFolhas++;
				total += Double.parseDouble(n.element);
				int i = 1;
				while(n.father != root){
					i++;
					n = n.father;
				}if(i > altura)				
					altura = i;
				}
			}
	}

	public double media() {
		return total/numFolhas;
		
	}
	
}
