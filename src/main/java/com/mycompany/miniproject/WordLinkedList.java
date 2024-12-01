
package com.mycompany.miniproject;

import java.io.FileWriter;

public class WordLinkedList {

    //node class
    private class Node{
        private String word;
        private int value;
        private Node nextNode;

        public Node(String word,int value){
            this.word = word;
            this.value = value;
        }
    }

    private Node firstNode;
    private Node lastNode;

    // add the node at the end
    public void add(String word, int value){
        Node node = new Node(word,value);

        if(firstNode == null){
            firstNode = lastNode = node;
        }else{
            lastNode.nextNode = node;
            lastNode = node;
        }
    }

    // generate wordsHKn.txt file
    public void generateWordsHKnFile(int n){
        try{
            FileWriter file = new FileWriter("D:\\Supun\\BSE(Hons)\\2 Year (semester 3)\\EEX4465 - Data Structures and Algorithms\\EEX4465_2022-23_MP\\wordsHK"+n+".txt");

            Node currentNode = firstNode;
            int j = 1;
            while(currentNode != null){
                file.write(j+"\t"+currentNode.word+"\t\t"+currentNode.value+"\n");
                currentNode = currentNode.nextNode;
                j++;
            }

            file.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // remove duplicate elements
    public void removeDuplicate(){
        Node currentNode = firstNode;
        Node tempNode = null;
        Node nextNode = null;

        while(currentNode != null){
            tempNode = currentNode;
            nextNode = currentNode.nextNode;

            while(nextNode != null){
                if(currentNode.word.equals(nextNode.word)){
                    tempNode.nextNode = nextNode.nextNode;
                }else{
                    tempNode = nextNode;
                }
                nextNode = nextNode.nextNode;
            }

            currentNode = currentNode.nextNode;
        }
    }

    public int size(){
        int count = 0;

        Node currentNode = firstNode;
        while(currentNode != null){
            count++;
            currentNode = currentNode.nextNode;
        }
        return count;
    }
}








//  public void printAll(){
//        Node currentNode = firstNode;
//
//        while(currentNode != null){
//            System.out.println(currentNode.word+" "+currentNode.value);
//            currentNode = currentNode.nextNode;
//        }
//    }