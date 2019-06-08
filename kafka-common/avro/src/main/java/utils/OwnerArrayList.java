package utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: onemall
 * @description: 自建arrayList
 * @author: Nou
 * @create: 2019-06-07 13:55
 **/
public class OwnerArrayList<E> {

    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPATITY = 10;


    public OwnerArrayList(){
        elementData = new Object[DEFAULT_CAPATITY];
    }

    public OwnerArrayList(int capacity){
        elementData = new Object[DEFAULT_CAPATITY];
    }
    //需要扩容
    private void add(E element){

        if(size == DEFAULT_CAPATITY){
            Object[] arrayNew = new Object[DEFAULT_CAPATITY + (DEFAULT_CAPATITY>>1)];
            System.arraycopy(element, 0, arrayNew, 0,size);
            elementData = arrayNew;
        }
        elementData[size++] = element;
    }

    private void removeElement(E element){
        for (int i = 0; i < size; i++){
            if(element.equals(elementData[i])){
                remove(i);
            }
        }
    }


    private void remove(int index){
        int moveLength = elementData.length - index -1;
        if(moveLength > 0 ){
            System.arraycopy(elementData, index+1, elementData, index, moveLength);
        }
        elementData[--size] = null;
    }

    private E get(int index){
        return (E)elementData[index];
    }

    private int set(E element, int index){

        if(index<0 || index>size -1){
            return -1;
        }
        elementData[index] = element;

        return 1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i =0;i < size; i++){
            sb.append("\t").append(elementData[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        OwnerArrayList list = new OwnerArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());

        list.removeElement(2);
        System.out.println(list.toString());

        List<String> list1 = new LinkedList<>();
    }


}
