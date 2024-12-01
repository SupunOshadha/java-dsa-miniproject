
package com.mycompany.miniproject;

public class CharArray {

    private char[] data;
    private int length;

    public CharArray(int size){
        data = new char[size];
    }

    public void add(char c){
      data[length] = c;
      length++;               
    }
    public int indexOf(char c){
        for(int i = 0 ; i < length ; i++){
            if(data[i] == c){
                return i;
            }
        }
        return -1;
    }
}













//    public void printAll(){
//        for(int i = 0 ; i < length ; i++){
//            System.out.println(data[i]);
//        }
//    }