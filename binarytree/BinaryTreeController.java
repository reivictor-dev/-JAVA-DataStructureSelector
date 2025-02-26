package binarytree;

import java.util.ArrayList;

public class BinaryTreeController {
    private Node root;
    private int nNodes;

    public void insertPreviousNumbers(ArrayList<Integer> numbers){
        if(numbers.isEmpty()) return;

        
        for(int number : numbers){
            insert(number);
        }
    }

    public boolean insert(int numberToInsert){
        if(root == null){
            root = new Node(numberToInsert);
            nNodes++;
            return false;
        }
        
        Node cursor = root;

        while(true){

            if(cursor.value == numberToInsert){
                return false;
            }

            if(cursor.value > numberToInsert){
                if(cursor.getLeft() == null){
                    cursor.setLeft(new Node(numberToInsert));
                    nNodes++;
                    return true;
                }
                cursor = cursor.getLeft();
                
            }

            if(cursor.value < numberToInsert){
                if(cursor.getRight() == null) {
                    cursor.setRight(new Node(numberToInsert));  
                    nNodes++;
                    return true;
                }
                cursor = cursor.getRight();
            }
            
        }
    }

    

    public void deleteANode(int nodeValuetoDelete){
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
    
        Node cursor = root;
        Node parent = null;
    
        System.out.println("Starting search for " + nodeValuetoDelete);
    
        while (cursor != null && cursor.value != nodeValuetoDelete) {
            System.out.println("Visiting node: " + cursor.value);
            parent = cursor;
            if(nodeValuetoDelete < cursor.value){
                cursor = cursor.getLeft();
            } else if(nodeValuetoDelete > cursor.value){
                cursor = cursor.getRight();
            }
        }

        if (cursor == null) {
            System.out.println("Node " + nodeValuetoDelete + " not found in tree");
            return;
        }
    
        System.out.println("Node " + nodeValuetoDelete + " found, proceeding with deletion");

        //Leaves
        if(cursor.getLeft() == null && cursor.getRight() == null){
            if(parent == null){
                root = null;
            } else if(parent.getLeft() == cursor){
                parent.setLeft(null);
            } else if(parent.getRight() == cursor){
                parent.setRight(null);
            }
        }

        //One child on right node
        else if(cursor.getLeft() == null) {
            if(parent == root){
                root = cursor.getRight();
            } else if(parent.getLeft() == cursor){ //here we check if the parent(one step before) is equal cursor, if so
                parent.setLeft(cursor.getRight());
            } else {
                parent.setRight(cursor.getRight());
            }
        }

        else if(cursor.getRight() == null){
            if(parent == root){
                root = cursor.getLeft();
            } else if (parent.getLeft() == cursor){
                parent.setLeft(cursor.getLeft());
            } else if(parent.getRight() == cursor){
                parent.setRight(cursor.getLeft());
            }
        }

        else if(cursor.getRight() != null && cursor.getLeft() != null){
            //change the node for the smallest node on the right subtree
            Node sucessor = cursor.getRight();
            Node sucessorParent = cursor;

            while (sucessor.getLeft() != null){
                sucessorParent = sucessor;
                sucessor = sucessorParent.getLeft();
            }

            cursor.value = sucessor.value;

            if(sucessorParent.getLeft() == sucessor){
                sucessorParent.setLeft(sucessor.getRight());
            }else if(sucessorParent.getRight() == sucessor){
                sucessorParent.setRight(sucessor.getRight());
            }
        }

        nNodes--;
    }    

    public boolean findNodeByValue(int numberToFind){
        Node cursor = root;

        while(cursor != null) {
            if(cursor.value == numberToFind){
                return true;
            }
            cursor = numberToFind < cursor.value ? cursor.getLeft() : cursor.getRight();
        }
        return false;

    }
    
    public void printTreeInAscendingOrder(Node node){
        if(node != null){
            printTreeInAscendingOrder(node.getLeft());
            System.out.println(node.value + "");
            printTreeInAscendingOrder(node.getRight());
        }
    }

    public void printTreeInAscendingOrder(){
        this.printTreeInAscendingOrder(root);
        System.out.println();
    }

    public void printTreeInDescendingOrder(Node node){
        if(node != null){
            printTreeInAscendingOrder(node.getRight());
            System.out.println(node.value + "");
            printTreeInAscendingOrder(node.getLeft());
        }
    }

    public void printTreeInDescendingOrder(){
        this.printTreeInDescendingOrder(root);
    }

    public void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            printTree(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public void printTree(){
        this.printTree(this.root,"",false);
    }


}
