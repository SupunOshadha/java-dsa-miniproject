
package com.mycompany.miniproject;

public class EnglishAlphabet {

    CharArray englishAlphabet = new CharArray(52);

    public EnglishAlphabet(){
        insertChar();
    }

    public void insertChar(){
      
        //lower cases
        for(char c = 97 ; c <= 122 ;c++){
            englishAlphabet.add(c); 
        }
        // 65-90 - Capital 
     
        //upper cases
        for(char c = 65 ; c <= 90 ; c++){
            englishAlphabet.add(c);
        }

    }
    public int getValue(Character c){
        return englishAlphabet.indexOf(c);
    }
}

