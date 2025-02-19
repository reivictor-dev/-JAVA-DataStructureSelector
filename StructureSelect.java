
import java.util.ArrayList;
import java.util.Scanner;
import linkedlist.Elementus;
import linkedlist.LinkedListController;

public class StructureSelect {
    private static ArrayList<Integer> userNumbers = new ArrayList<>(); 
        public static void main(String[] args) {
    
            System.out.println("=========WELCOME TO DATA STRUCTURE=======");
            
            Scanner scn = new Scanner(System.in);
            Boolean optVerify = true;

            while(optVerify){

                System.out.println("============MAIN MENU===========");
                System.out.println("Please select:");
                System.out.println("0 - STOP");
                System.out.println("1 - Insert your numbers:");
                System.out.println("2 - Verify inserted numbers");
                System.out.println("3 - Edit a number:");
                System.out.println("4 - Delete a number");
                System.out.println("5 - Array options");
                System.out.println("6 - Stack options");
                System.out.println("7 - Queue options");
                System.out.println("8 - LinkedList options");
                System.out.println("9 - HashTable options");


                System.out.println("99 - Fulfill the array");
    
                int opt = scn.nextInt();
                
                switch (opt) {
                    case 0 -> optVerify = false;
                    
                    case 1 -> {
                        System.out.println("Type a number");
                        int userNumber = scn.nextInt();
                        userNumbers.add(userNumber);
                        continue;
                    }
                        
                    case 2 -> {
                        for (Integer n : userNumbers) {
                            System.out.println(n);
                        }
                        continue;
                    }

                    case 3 -> {
                        System.out.println("Which number do you want to change?");
                        int changeNumber = scn.nextInt();
                        boolean founded = false;

                        for(int i = 0; i < userNumbers.size(); i++){
                            if(userNumbers.get(i) == changeNumber){
                                System.out.println("Type a number to change:");
                                int n = scn.nextInt();
                                founded = true;
                                userNumbers.set(i, n);
                                break;
                            }
                        }
                        if(!founded){
                            System.out.println("Number not found - try again");
                        }
                        continue;
                    }

                    
                    case 4 -> {
                        System.out.println("Which number do you want to remove?");
                        int deletedNumber = scn.nextInt();
                        boolean founded = false;
                        
                        for(int i = 0; i < userNumbers.size(); i++){
                            if(userNumbers.get(i) == deletedNumber){
                                userNumbers.remove(i);
                                founded = true;
                                break;
                            } 
                        }
                        if(!founded){
                            System.out.println("Number not found - try again");
                        }

                        continue;
                    }
                        // ARRAY SECTION
                        case 5 -> {
                            ArrayController arr = new ArrayController();
                            boolean arrVerify = true;

                            while (arrVerify) {
                                System.out.println("=======Array options======");
                                System.out.println("0 - Back to previous menu");
                                System.out.println("1 - Insert your previous numbers inside an Array");
                                System.out.println("2 - Print the complete array");
                                System.out.println("3 - Verify the number position in array");
                                System.out.println("4 - Change a number");
                                System.out.println("5 - Delete a number");
        
                                int arrOpt = scn.nextInt();

                                switch (arrOpt) {
                                    case 0 -> arrVerify = false;

                                    case 1 -> {
                                        arr.arrayInsert(userNumbers.size(), userNumbers);
                                        continue;
                                    }

                                    case 2 -> {
                                        arr.printAll();
                                        continue;
                                    }

                                    case 3 ->{
                                        System.out.println("Insert the number that you want to check: ");
                                        int number = scn.nextInt();

                                        arr.printAIndex(number);
                                        continue;
                                    }

                                    case 4 -> {
                                        System.out.println("Insert the number that you want to change: ");
                                        int oldNumber = scn.nextInt();
                                        System.out.println("Type the new number:");
                                        int newNumber = scn.nextInt();
                                        arr.updateANumber(oldNumber,newNumber);
                                        continue;
                                    }

                                    case 5 -> {
                                        System.out.println("Insert the number that you want to delete: ");
                                        int number = scn.nextInt();

                                        arr.deleteNumber(number);
                                        continue;
                                    }

                                    
                                }
                                
                            }
                        }
                        //STACK SECTION

                        case 6 ->{
                            StackController stk = new StackController();
                            boolean stkVerify = true;

                            while (stkVerify) {
                                System.out.println("=======Stack options======");
                                System.out.println("0 - Back to previous menu");
                                System.out.println("1 - Insert your previous numbers inside an Stack");
                                System.out.println("2 - Print the complete stack");
                                System.out.println("3 - Insert an element in the top of the stack");
                                System.out.println("4 - Remove an element from the of the stack");
                                System.out.println("5 - Show the top number");
        
                                int arrOpt = scn.nextInt();

                                switch (arrOpt) {
                                    case 0 -> stkVerify = false;

                                    case 1 -> {
                                        stk.fillStack(userNumbers.size(), userNumbers);
                                        continue;
                                    }

                                    case 2 -> {
                                        stk.print();
                                        continue;
                                    }

                                    case 3 ->{
                                        System.out.println("Insert the number that you want to check: ");
                                        int number = scn.nextInt();

                                        stk.push(number);
                                        continue;
                                    }

                                    case 4 -> {
                                        int pp = stk.pop();
                                        System.out.println("The element " + pp + " removed from stack!");
                                        continue;
                                    }

                                    case 5 -> {
                                        int tp = stk.top();
                                        System.out.println("Element " + tp + "is the top of the stack!");
                                        continue;
                                    }

                                    
                                }
                                
                            }
                        }
                        //QUEUE SECTION
                        case 7 ->{
                            QueueController queue = new QueueController();
                            boolean queueVerify = true;

                            while (queueVerify) {
                                System.out.println("=======Queue options======");
                                System.out.println("0 - Back to previous menu");
                                System.out.println("1 - Insert your previous numbers in a Queue");
                                System.out.println("2 - Print the complete Queue");
                                System.out.println("3 - Queue a number");
                                System.out.println("4 - Dequeue a number");
                                System.out.println("5 - Show the First number in the Queue");
                                System.out.println("6 - Show the Last number in the Queue");

        
                                int arrOpt = scn.nextInt();

                                switch (arrOpt) {
                                    case 0 -> queueVerify = false;

                                    case 1 -> {
                                        queue.fillQueue(userNumbers.size(), userNumbers);
                                        continue;
                                    }

                                    case 2 -> {
                                        queue.print();
                                        continue;
                                    }

                                    case 3 ->{
                                        System.out.println("Insert the number that you want to queue: ");
                                        int number = scn.nextInt();

                                        queue.queueNumber(number);
                                        continue;
                                    }

                                    case 4 -> {
                                        int pp = queue.dequeue();
                                        System.out.println("The element " + pp + " removed from stack!");
                                        continue;
                                    }

                                    case 5 -> {
                                        int tp = queue.front();
                                        System.out.println("Element " + tp + " is the front in the Queue");
                                        continue;
                                    }

                                    case 6 ->{
                                        int bc = queue.back();
                                        System.out.println("Element " + bc + " is the front in the Queue");
                                        continue;
                                    }
                                }
                                
                            }
                        }

                        //LinkedList SECTION
                        case 8 ->{
                            LinkedListController lkd = new LinkedListController();
                            boolean lkdVerify = true;
                            

                            while (lkdVerify) {
                                System.out.println("=======LinkedList options======");
                                System.out.println("0 - Back to previous menu");
                                System.out.println("1 - Insert your previous numbers in a LinkedList");
                                System.out.println("2 - Print the complete LinkedList");
                                System.out.println("3 - Insert a number");
                                System.out.println("4 - Delete a number");
        
                                int arrOpt = scn.nextInt();

                                switch (arrOpt) {
                                    case 0 -> lkdVerify = false;

                                    case 1 -> {
                                        lkd.insertPreviousNumber(userNumbers);
                                        continue;
                                    }

                                    case 2 -> {
                                        lkd.printLinkedList();
                                        continue;
                                    }

                                    case 3 -> {
                                        System.out.println("Insert the number:");
                                        int nb = scn.nextInt();
                                        Elementus elementus = new Elementus();
                                        elementus.setNumber(nb);

                                        lkd.insert(elementus);

                                    }

                                    case 4 -> {
                                        System.out.println("Which number you want to delete?");
                                        int nb = scn.nextInt();
                                        lkd.deleteElementByNumber(nb);
                                    } 
                                }
                                
                            }
                        }

                        //LinkedList SECTION
                        case 9 ->{
                            HashTableController hashSec = new HashTableController();
                            boolean hashSecVerify = true;
                            

                            while (hashSecVerify) {
                                System.out.println("=======HashTable options======");
                                System.out.println("0 - Back to previous menu");
                                System.out.println("1 - Insert your previous numbers in a Hashtable");
                                System.out.println("2 - Print the complete HashTable");
                                System.out.println("3 - Insert a number");
                                System.out.println("4 - Delete a number");
                                System.out.println("5 - Get number position");

        
                                int arrOpt = scn.nextInt();

                                switch (arrOpt) {
                                    case 0 -> hashSecVerify = false;

                                    case 1 -> {
                                        hashSec.insertWithPrevData(userNumbers);
                                        continue;
                                    }

                                    case 2 -> {
                                        hashSec.printHash();
                                        continue;
                                    }

                                    case 3 -> {
                                        System.out.println("Type your new number to insert:");
                                        int newNumber = scn.nextInt();
                                        hashSec.insertANewNumber(newNumber);
                                        continue;
                                    }

                                    case 4 -> {
                                        System.out.println("Which number you want to delete");
                                        int numberToDelete = scn.nextInt();
                                        hashSec.deleteNumber(numberToDelete);
                                        continue;
                                    }

                                    case 5 -> {
                                        System.out.println("Which number you want to find the position");
                                        int numberToFind = scn.nextInt();
                                        int i = hashSec.getIndexByNumber(numberToFind);
                                        int pos = hashSec.getPosInHashTable(numberToFind);
                                        if(pos == -1){
                                            System.out.println("Number not founded!");
                                            continue;
                                        }
                                        System.out.println("Your number is on index " + i + " on the position " + pos);
                                        continue;
                                    }
                                }
                                
                            }
                        }

                    case 99 -> {
                        int[] arrF = new int[]{23,28,32,34,45,48,50,15,1548,122,145,198,178,148,158,133,2669,1574};
    
                        for (int ff : arrF) {
                            userNumbers.add(ff);
                        }
                        continue;
                    }

            }
        }
    }
}
