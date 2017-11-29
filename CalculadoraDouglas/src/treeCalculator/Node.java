/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeCalculator;

/**
 *
 * @author Doug
 */
public class Node {

    private Node father;
    private Node left;
    private Node right;
    private double element;

    public Node() {
        father = null;
        left = null;
        right = null;
        element = 0;
    }

    public Node(double n) {
        father = null;
        left = null;
        right = null;
        element = n;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public double getElement() {
        return element;
    }

    public void setElement(double element) {
        this.element = element;
    }

}
