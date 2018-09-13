package stackOfStrings;

import java.util.ArrayList;

public class StackOfStrings extends ArrayList {

    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        String result = this.data.get(this.data.size() - 1);
        this.data.remove(this.data.size()-1);
        return result;
    }

    public String peek(){
        return this.data.get(this.data.size()-1);
    }

    @Override
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
