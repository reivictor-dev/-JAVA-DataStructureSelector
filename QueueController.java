import java.util.ArrayList;

public class QueueController {
    private int  queueData[];
    
    public QueueController() {
    }

    public void fillQueue(int size, ArrayList<Integer> dataInsert){
        queueData = new int[size];

        
        for(int i = 0; i < size; i++){
            queueData[i] = dataInsert.get(i);
        }           
    }

    public void queueNumber(int number) {
        int copy[] = queueData;
        queueData = new int[queueData.length + 1];
        for (int i = 0; i < copy.length; i++){
            queueData[i] = copy[i]; 
        }
        queueData[queueData.length -1] = number;
    }

    public int dequeue(){
        int copy[] = queueData;

        int dequeNumber = queueData[0];
        queueData = new int[queueData.length - 1];
        for (int i = queueData.length - 1; i >= 0; i--){
            queueData[i] = copy[i + 1];
        }
        return dequeNumber;
    }

    public void print(){
        System.out.print("<--START-- ");
        for(int i = 0; i < queueData.length ; i++){
            System.out.print(" << " + queueData[i] + " << ");
        }
        System.out.println("<--END--");
    }

    public int front(){
        return queueData[0];
    }

    public int back(){
        return queueData[queueData.length - 1];
    }
}
