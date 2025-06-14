package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomStack() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t){
        T object = (T) t;
        list.addLast(object);
        return true;
    }

    @Override
    public boolean offer(Object o){
        T t = (T) o;
        if (add(t) == true){
            return true;
        }
        else return false;
    }

    @Override
    public T remove(){
        if (list.isEmpty()){
            throw new NoSuchElementException();
        }
        T t = list.getFirst();
        list.removeFirst();
        return t;
    }

    @Override
    public T poll(){
        if (list.isEmpty()){
            return null;
        }
        T t = list.getFirst();
        list.removeFirst();
        return t;
    }

    @Override
    public T element(){
        if (list.isEmpty()){
            throw new NoSuchElementException();
        }
        return list.getFirst();
    }

    @Override
    public T peek(){
        if (list.isEmpty()){
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty(){
        if (list.size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public int size(){
        return list.size();
    }

}