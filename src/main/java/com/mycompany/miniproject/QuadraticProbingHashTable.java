
package com.mycompany.miniproject;

import java.io.FileWriter;

public class QuadraticProbingHashTable {

    private String[] table;
    private int size;
    private int count;

    // for generate wordsQHKn.txt file
    private String[] words;
    private int[] hashKeys;
    private int[] newHashKeys;
    private int[] qhashKeys;

    public QuadraticProbingHashTable(int size){
        table = new String[size];
        this.size = size;
        this.count = 0;

        words = new String[size];
        hashKeys = new int[size];
        newHashKeys = new int[size];
        qhashKeys = new int[size];
    }

    private int hash(int key){
        return key % size;
    }

    public void put(int key,String value){

        int hashValue = hash(key);
        int temp = key;
        int i = 1;

        do{
            if(table[hashValue] == null){
                table[hashValue] = value;

                words[count] = value;
                hashKeys[count] = key;
                newHashKeys[count] = temp;
                qhashKeys[count] = hashValue;
                count++;
                return;
            }

            temp = key + i*i +i ; // rehash
            hashValue = hash(temp);
            i++;

        }while(hashValue > -1);
    }

    public void printHashTable(){
        for(int i = 0 ; i < table.length ; i++){
            if(table[i] != null){
                System.out.println(i+" "+table[i]);
            }
        }
    }

    public void generateWordsQHKnFile(int n){
        try{
            FileWriter file = new FileWriter("D:\\Supun\\BSE(Hons)\\2 Year (semester 3)\\EEX4465 - Data Structures and Algorithms\\EEX4465_2022-23_MP\\wordsQHK"+n+".txt");

            for(int i = 0 ; i < table.length ; i++){
                file.write(i+1+"\t"+words[i]+"\t\t"+hashKeys[i]+"\t"+newHashKeys[i]+"\t"+qhashKeys[i]+"\n");
            }

            file.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
