package stringbasic;

public class StringCreator {

    public String createStringForHeap(){
        return new String("apple");
    }

    public String createStringForPool(){
        return "apple";
    }
}
