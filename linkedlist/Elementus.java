package linkedlist;

public class Elementus {
    private int number;
    private Elementus next;
    private int pos;
    
    public Elementus(){
        this.next = null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Elementus getNext() {
        return next;
    }

    public void setNext(Elementus next) {
        this.next = next;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    
}
