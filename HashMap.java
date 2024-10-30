import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class HashMap {
    public static void main(String[] args){
        System.out.println("Hello World");
    }

    
}

class MyHashMap{
    private final int MAX_VALUE = 1000000;
    private final int ARRAY_SIZE = 10001;
    private List<List<keyPoints>> parenList;
    public void HashMap(){
        parenList = new ArrayList<>();
        for (int i = 0; i < ARRAY_SIZE; i++ ) {
            parenList.add(null);
        }
    }

    public void put(int key, int value){
        int index = key % ARRAY_SIZE;
        List<keyPoints> childList = parenList.get(index);

        if(childList == null){
            childList = new LinkedList<>();
            
        }
    }
}

class keyPoints{
    public int key;
    public int value;

    public keyPoints(int key, int value){
        this.key = key;
        this.value = value;
    }

}


