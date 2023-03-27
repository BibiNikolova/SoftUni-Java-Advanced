package generics.jar;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> content;

    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public void add(T entity){
        this.content.push(entity);
    }

    public T remove(){
        return this.content.pop();
    }

}
