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

    public static void main(String[] args) {

        BinaryTree arvore = new BinaryTree();
        int numLinha = 1;
        Path path1 = Paths.get("expressoes.txt");
        try (Scanner sc = new Scanner(Files.newBufferedReader(path1, Charset.forName("utf8")))) {
            sc.useDelimiter("\r\n|\n");
            while (sc.hasNext()) {
                String linha = sc.next().trim();
                System.out.println("\nCalculando:   "+linha);
                for(int i = 0; i < linha.length(); i++) {
                	
	                switch (linha.charAt(i)) {	                    
	                    case ' ':	                        
	                        break;
	                    case '(':
	                    	arvore.add();
	                        break;
	                    case ')':
	                    	arvore.close();
	                        break;
	                    case '+':
	                    	arvore.addOperador("+");
	                        break;
	                    case '-':
	                    	arvore.addOperador("-");
	                        break;
	                    case '*':
	                    	arvore.addOperador("*");
	                        break;
	                    case '/':
	                    	arvore.addOperador("/");
	                        break;
	                    case '^':
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
	                            arvore.add(valor);
//	                            monta.valor(valor);
	                        } catch (NumberFormatException e) {
	                            JOptionPane.showMessageDialog(null, "CARACTERE NÃO RECONHECIDO '" + linha.charAt(i) + "'  ");
	                        }catch (StringIndexOutOfBoundsException e) {
	                            JOptionPane.showMessageDialog(null, "CARACTERE NÃO RECONHECIDO  '" + linha.charAt(i) + "'   ");
	                        }catch (FaltaDeParentesesException e) {
	                            JOptionPane.showMessageDialog(null, "CARACTERE NÃO RECONHECIDO  '" + linha.charAt(i) + "'   ");
	                        }
	
	                }
                }
                System.out.println("Altura:            " + arvore.altura());
                System.out.println("Média dos números: " + arvore.media());
                arvore.calcular();
                System.out.println("Resultado =        " + arvore.resultado());
//                System.out.println("Altura:     " + arvore.altura());
            }
            
//            JOptionPane.showMessageDialog(null, "Resultado: " + monta.getTop() + "\nTamanho mÃ¡ximo da pilha: " + monta.getMax());
//            if (monta.resto() > 1) {
//                JOptionPane.showMessageDialog(null, "Seu arquivo ainda contÃ©m " + monta.resto() + " elementos");
//            }
        } catch (IOException x) {
            JOptionPane.showMessageDialog(null, "OPS! Seu arquivo n�o foi encontrado");
//        } catch (CalculadoraException c) {
//            JOptionPane.showMessageDialog(null, c.getMessage());
//        }
        }
    }
    public static boolean verificaSeeInteiro(String s) {
		boolean resposta = true;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) { // Verifica caractere por caractere se � um d�gito
				resposta = false;
				break;
			}
		}
		return resposta;
	}

}
