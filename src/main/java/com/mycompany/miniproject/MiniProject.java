
package com.mycompany.miniproject;

import java.io.File;
import java.util.Scanner;

public class MiniProject {
    public static void main(String[] args) {

        EnglishAlphabet alphabet = new EnglishAlphabet();
        WordLinkedList wordList = new WordLinkedList();

        try{

            Scanner input = new Scanner(System.in);  // TASK 1 //
            System.out.print("Enter the first digit of your Registration number: ");
            int n = input.nextInt();

            File inputFile = new File("D:\\Supun\\BSE(Hons)\\2 Year (semester 3)\\EEX4465 - Data Structures and Algorithms\\EEX4465_2022-23_MP\\file"+n+".txt");
            Scanner file = new Scanner(inputFile);

            while(file.hasNext()){
                String word = file.next();  
                String validWord = "";  
                int wordValue = 0;

                for(int i = 0 ; i < word.length() ; i++){
                    if(word.charAt(i) >= 65 && word.charAt(i) <=90 || word.charAt(i) >= 97 && word.charAt(i) <= 122 ){
                        validWord = validWord + word.charAt(i);
                        wordValue = wordValue + alphabet.getValue(word.charAt(i));
                        //System.out.println(validWord +" "+wordValue);
                    }
                }

                if(validWord.length() > 0){
                    wordList.add(validWord,wordValue);
                }
            }
            
            wordList.removeDuplicate();  // remove duplicates
            // create wordsHKn.txt file
            wordList.generateWordsHKnFile(n);

           //TASK 2 //
            int hashTableSize = wordList.size();
            QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable(hashTableSize);

            inputFile = new File("D:\\Supun\\BSE(Hons)\\2 Year (semester 3)\\EEX4465 - Data Structures and Algorithms\\EEX4465_2022-23_MP\\wordsHK"+n+".txt");
            file = new Scanner(inputFile);

            String line = null;
            String[] words = null;
            while(file.hasNext()){
                line = file.nextLine();
                words = line.split("\\W+");
                hashTable.put(Integer.parseInt(words[2]),words[1]);
            }

            // generate wordsQHKn.txt file
            hashTable.generateWordsQHKnFile(n);


            // Task 3 //

            inputFile = new File("D:\\Supun\\BSE(Hons)\\2 Year (semester 3)\\EEX4465 - Data Structures and Algorithms\\EEX4465_2022-23_MP\\wordsQHK"+n+".txt");
            file = new Scanner(inputFile);

            QuadraticProbingHashTable table = new QuadraticProbingHashTable(wordList.size());

            while(file.hasNext()){
                line = file.nextLine();
                words = line.split("\\W+");
                table.put(Integer.parseInt(words[4]),words[1]);
            }

            table.printHashTable();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
