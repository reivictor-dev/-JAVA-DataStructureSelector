import java.util.ArrayList;
import linkedlist.Elementus;
import linkedlist.LinkedListController;

public class HashTableController {
    private final int PRIMAL_NUMBER = 11;
    private LinkedListController hashTable[];

    private int hash(int key, int size){
        return key % size;
    } 

    public void insertWithPrevData(ArrayList<Integer> numberArr){
        hashTable = new LinkedListController[PRIMAL_NUMBER];
        int tSize = PRIMAL_NUMBER;

        for (int nbr : numberArr) {
            int index = hash(nbr, tSize);
            Elementus eachElementus = new Elementus();
            eachElementus.setNumber(nbr);
            if(hashTable[index] == null){
                hashTable[index] = new LinkedListController();
            }
            hashTable[index].insert(eachElementus);
        }
    }

    public void insertANewNumber(int number){
        if(hashTable == null){
            hashTable = new LinkedListController[PRIMAL_NUMBER];
        }
        int tSize = PRIMAL_NUMBER;
        int index = hash(number, tSize);

        Elementus elementus = new Elementus();
        elementus.setNumber(number);

        if(hashTable[index] == null){
            hashTable[index] = new LinkedListController();
        }

        hashTable[index].insert(elementus);
    }

    public void deleteNumber(int numberToDelete) {
        
        for (LinkedListController hashTable1 : hashTable) {
            
            if (hashTable1 != null && hashTable1.isFounded(numberToDelete)) {
                hashTable1.deleteElementByNumber(numberToDelete);
                return;
            }
        }
    }

    public int getIndexByNumber(int numberToSearch){
        if(hashTable == null){
            System.out.println("Empty HashTable insert some value!");
        }
        int i = 0;
        for (LinkedListController hashTableN : hashTable) {
            
            if (hashTableN != null && hashTableN.isFounded(numberToSearch)) {
                
                return i;
            }
            i++;
        }
        
        return i;
    }

    public int getPosInHashTable(int numberToFindPos){
        for (LinkedListController hashTableN : hashTable) {
            
            if (hashTableN != null && hashTableN.isFounded(numberToFindPos)) {
                
                return hashTableN.getElementusByNumber(numberToFindPos).getPos();
            }
            
        }
        return -1;
        
    }

    public void printHash() {
        if(hashTable == null){
            System.out.println("Empty HashTable insert some value!");
        }
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) { //Check for null before calling methods
                System.out.print("Index " + i + ": "); // Print index for clarity
                hashTable[i].printLinkedList();
            } else {
                System.out.println("Index " + i + ": EMPTY"); // Indicate empty slots
            }
        }
    }

}
