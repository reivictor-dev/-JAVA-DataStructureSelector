
import java.util.ArrayList;

public class ArrayController {
    private int[] arrData;


    public ArrayController() {
    }

    public void arrayInsert(int size, ArrayList<Integer> dataInsert){
        arrData = new int[size];

        
        for(int i = 0; i < size; i++){
            arrData[i] = dataInsert.get(i);
        }           
    }

    public void printAll(){
        System.out.print("[");
        for(int i = 0; i < arrData.length; i++){
            System.out.print(arrData[i]);
            if(i < arrData.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void printAIndex(int n){
        if(arrData.length == 0){
            System.out.println("No data! Please insert some data.");
            return;
        }
        boolean founded = false;
        for (int i = 0; i < arrData.length; i++){
            if(arrData[i] == n){
                System.out.println("The index number is this:" + i);
                founded = true;
                break;
            }
        }

        if(!founded){
            System.out.println("Number not founded!");
        }
    }

    public void updateANumber(int oldNumber, int newNumber){
        if(arrData.length == 0){
            System.out.println("No data! Please insert some data.");
            return;
        }
        boolean founded = false;
        for (int i = 0; i < arrData.length; i++) {
            if(arrData[i] == oldNumber){
                arrData[i] = newNumber;
                founded = true;
                break;
            }
        }
        if(!founded){
            System.out.println("Number not founded!");
        }
    }

    public void deleteNumber(int deleteNumber){
        if(arrData.length == 0){
            System.out.println("No data! Please insert some data.");
            return;
        }
        int copy[] = new int[arrData.length-1];

        boolean founded = false;
        for (int i = 0, j=0; i < arrData.length; i++) {
            if(arrData[i] != deleteNumber){
                copy[j] = arrData[i];
                founded = true;
                j++;
            }
        }
        
        arrData = copy;

        if(!founded){
            System.out.println("Number not founded!");
        }
    }

    
}
