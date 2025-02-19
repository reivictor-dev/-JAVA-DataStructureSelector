import java.util.ArrayList;

public class StackController {
    private int stackData[];
    
    public StackController() {
    }

    public void fillStack(int size, ArrayList<Integer> dataInsert){
        stackData = new int[size];

        
        for(int i = 0; i < size; i++){
            stackData[i] = dataInsert.get(i);
        }           
    }

    public void push(int numberPush){
//sir Bean #beans
        if(isFull()){
            int prevData[] = stackData;
            stackData = new int[stackData.length + 1];

            for (int i = 0; i < stackData.length - 1; i++) {
                stackData[i] = prevData[i];
            }

            stackData[stackData.length - 1] = numberPush;
        }
    }

    public int pop(){
        int prevData[] = stackData;
        int last = prevData[prevData.length - 1];
        stackData = new int[stackData.length - 1];

        for (int i = 0; i < stackData.length; i++) {
            stackData[i] = prevData[i];
        }

        return last;
    }

    public int top(){
        if(isEmpty()){
            System.out.println("Empty stack, check or insert a number!");
        }
        return stackData[stackData.length - 1];
    }

    public boolean isEmpty(){
        boolean empty = false;
        if(stackData.length == 0){
            empty = true;
        }

        return empty;
    }

    public boolean isFull(){
        boolean full = false;
        int counter = 0;
        for(int i = 0;i < stackData.length; i++){
            counter++;
        }
        if(counter > 0 && stackData.length == counter){
            full = true;
        }
        return full;
    }

    public void print(){
        System.out.println("--------TOP--------");
        for(int i = stackData.length - 1; i >= 0 ; i--){
            System.out.println("========" + stackData[i] + "========");
        }
    }
}
