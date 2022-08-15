package com.sparta.leanne;

import java.util.Arrays;

import static com.sparta.leanne.BinaryTree.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BinaryTree tree = new BinaryTree(5);
        tree.addElementToTree(1);
        tree.addElementToTree(5);
        tree.addElementToTree(10);
        tree.addElementToTree(3);
        tree.addElementToTree(6);
        tree.addElementToTree(11);
        System.out.println(tree.findElement(11));
        System.out.println(tree.getRootElement());
        int[] elements = {2,4,7};
        tree.addElements(elements);
        System.out.println(tree.getNumberOfElements());
        System.out.println(Arrays.toString(tree.getSortedTreeAsc()));
        System.out.println(Arrays.toString(tree.getSortedTreeDesc()));

    }
}
