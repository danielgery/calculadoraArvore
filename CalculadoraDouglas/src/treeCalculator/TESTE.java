package treeCalculator;

public class TESTE {
	public static void main(String[] args) {
		BinaryTree arvore = new BinaryTree();
		
		arvore.add();
			arvore.add();
				arvore.add("1");
				arvore.addOperador("+");
				arvore.add("2");
			arvore.close();
			arvore.addOperador("/");
			arvore.add("3");
		arvore.close();
		
		arvore.calcular();
		System.out.println(arvore.positionsCentral().toString());
	
		
//		arvore.add();
//		arvore.add("2");
//		arvore.addOperador("+");
//		arvore.add("2");
//		arvore.close();		
//		arvore.calcular();
//		System.out.println(arvore.positionsCentral().toString());
	}

}
