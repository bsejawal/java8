package com.bsejawal.generics;

interface Printable{
    void print();
}
 class MyNumber extends Number implements Printable{
    private final int value;

     MyNumber(int value) {
         this.value = value;
     }

     @Override
    public void print() {
        System.out.println(value);
    }

     @Override
     public int intValue() {
         return value;
     }

     @Override
     public long longValue() {
         return value;
     }

     @Override
     public float floatValue() {
         return value;
     }

     @Override
     public double doubleValue() {
         return value;
     }
 }


 class Boxx<T extends Number & Printable>{
    private final T item;
    public Boxx(T item){
        this.item = item;
    }
    public void display(){
        item.print();
    }
    public T getItem(){
        return item;
    }

 }
 enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}
public class Test {
    public static void main(String[] args) {

    }

}
