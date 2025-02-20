package binarytree;

import java.util.ArrayList;

public class BinaryTreeController {
    private Node root;

    public void insertPreviousNumbers(ArrayList<Integer> numbers){
        
        for(int number : numbers){
            insert(number);
        }
    }

    public Node insert(Node root, int numberToInsert){
        if(root == null){
            root = new Node(numberToInsert);
            return root;
        }

        if(numberToInsert > root.value){
            root.left = insert(root.left, numberToInsert);
        } else {
            root.right = insert(root.right, numberToInsert);
        }

        return root;
    }

    public void insert(int numberToInsert){
        root = insert(root, numberToInsert);
    }

    public void printInOrder(Node root){
        if(root == null){
            return;
        }
        printInOrder(root.left);

        System.out.println(root.value + " ");

        printInOrder(root.right);
    }

    public void printInOrder(){
        printInOrder(root);
    }
}
