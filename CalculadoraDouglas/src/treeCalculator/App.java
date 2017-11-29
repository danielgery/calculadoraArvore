/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeCalculator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Doug
 */
public class App {

    public static void main(String[] args) throws IOException {

        TreeAssembly monta = new TreeAssembly();
        BinaryTree arvore = new BinaryTree();
//        String arquivo = JOptionPane.showInputDialog("Informe o nome do arquivo a ser lido:");

        Path path1 = Paths.get("primeira");
        try (Scanner sc = new Scanner(Files.newBufferedReader(path1, Charset.forName("utf8")))) {
            sc.useDelimiter("\r\n|\n");
            while (sc.hasNext()) {
                String linha = sc.next().trim();
                System.out.println(linha);
                for(int i = 0; i < linha.length(); i++) {
                	System.out.println(linha.charAt(i));
	                switch (linha.charAt(i)) {
	                    case '\r':
	                        sc.next();
	                        break;
	                    case ' ':
	                        System.out.println("espaço em brnco");
	                        break;
	                    case '(':
//	                        monta.criaNodo();
	                    	arvore.add();System.out.println("add (");
	                        break;
	                    case ')':
//	                        monta.volta();
	                    	arvore.close();
	                        break;
	                    case '+':
//	                        monta.operador();
	                    	arvore.addOperador("+");
	                        break;
	                    case '-':
//	                        monta.operador();
	                    	arvore.addOperador("-");
	                        break;
	                    case '*':
//	                        monta.operador();
	                    	arvore.addOperador("*");
	                        break;
	                    case '/':
//	                        monta.operador();
	                    	arvore.addOperador("/");
	                        break;
	                    case '^':
//	                        monta.operador();
	                    	arvore.addOperador("^");
	                        break;
	                    default:
	                        try {
	                            String valor = ""+linha.charAt(i);
	                            int j = 1;
	                            while(verificaSeeInteiro(""+linha.charAt(i+j))) {
	                            	valor += ""+linha.charAt(i+j);
	                            	j++;
	                            	i++;
	                            }
	                            arvore.add(valor);System.out.println("add "+valor );
//	                            monta.valor(valor);
	                        } catch (NumberFormatException e) {
	                            JOptionPane.showMessageDialog(null, "CARACTERE NÃƒÆ’O RECONHECIDO ||> " + linha + " <||  ");
	                        }
	
	                }
                }
            }
            arvore.calcular();
            System.out.println(arvore.resultado());
//            JOptionPane.showMessageDialog(null, "Resultado: " + monta.getTop() + "\nTamanho mÃƒÂ¡ximo da pilha: " + monta.getMax());
//            if (monta.resto() > 1) {
//                JOptionPane.showMessageDialog(null, "Seu arquivo ainda contÃƒÂ©m " + monta.resto() + " elementos");
//            }
        } catch (IOException x) {
            JOptionPane.showMessageDialog(null, "OPS! Seu arquivo não foi encontrado");
//        } catch (CalculadoraException c) {
//            JOptionPane.showMessageDialog(null, c.getMessage());
//        }
        }
    }
    public static boolean verificaSeeInteiro(String s) {
		boolean resposta = true;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) { // Verifica caractere por caractere se é um dígito
				resposta = false;
				break;
			}
		}
		return resposta;
	}

}
