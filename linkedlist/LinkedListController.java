package linkedlist;

import java.util.ArrayList;

public class LinkedListController {
	private Elementus start;
    
    public void insertPreviousNumber(ArrayList<Integer> numbers){
        
        for(int i = 0; i < numbers.size(); i++){
            Elementus elementus = new Elementus();
            elementus.setNumber(numbers.get(i));
            elementus.setPos(i);
            elementus.setNext(start);
            start = elementus;   
        }
    }

    public void insert (Elementus elementus){
        int counter = 0;
        if(start == null){
            start = elementus;
            start.setPos(counter);
            return;
            
        }

        Elementus cursor = start; //we need to put a variable to not change the start value!!

        while(cursor.getNext() != null){
            counter++;
            if(cursor.getNumber() == elementus.getNumber()){
                return;
            }
            cursor = cursor.getNext();
        }
        counter++;
        elementus.setPos(counter);
        cursor.setNext(elementus);
    }

    public void deleteElementByNumber(int number){
        int counter = 0;
        if(start.getNumber() == number){
            Elementus nextElementus = start.getNext();
            nextElementus.setPos(counter);
            start = nextElementus;
            updatePos();
            return;
        }
        
        if(start == null) return;
        
        Elementus cursor = start;
        while(cursor.getNext() != null){

            if(cursor.getNext().getNumber() == number){ //stop in the previous element
                cursor.setNext(cursor.getNext().getNext()); //here we are still in the prev elementus. so we need to jump 2(the element that will be removed and the element that is the next one.)
                updatePos();
                return;
            }
            counter--;
            cursor.setPos(counter);
            cursor = cursor.getNext();
        }
        System.out.println("Elementus " + number + " not found!");
    }

    public Elementus getElementusByNumber(int number){
        Elementus cursor = start;
        while(cursor != null){
            if(cursor.getNumber() == number){
                return cursor;
            }
            cursor = cursor.getNext();
        }
        return null;
    }

    public void updatePos(){
        int counter = 0;
        Elementus cursor = start;

        while(cursor.getNext() != null){
            cursor.setPos(counter);
            counter++;
            cursor = cursor.getNext();
        }
    }
    
    public boolean isFounded(int number){
        if(start == null){
            return false;
        }

        Elementus cursor = start;

        while(cursor != null){

            if(cursor.getNumber() == number){ 
                return true;
            }
            cursor = cursor.getNext();
        }
        return false;
    }

    public void printLinkedList() {
        Elementus current = start;
        
        if (current == null) {
            System.out.println("EMPTY");
            return;
        }
        while (current != null) {
            System.out.print("[" + current.getNumber() + "] -> ");
            current = current.getNext();
        }
        
        System.out.println("NULL");
    }
    
}
