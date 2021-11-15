/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Do_Do
 */
public class SyntaxCheck {
    String txtString;

    public SyntaxCheck() {
    }
    boolean checkEmpty(String txt){
        return txt.isEmpty();
    }
    boolean checkNumberOfCharactor(String txt){
        int wordCount = 0;
        String [] str = txt.split("");
        for (String word : str) {
            if (!word.isEmpty()) 
                wordCount++;         
        }
        return wordCount<8;
    }
    boolean checkName(String txt){
        for(char c : txt.toCharArray()){
            if(Character.isDigit(c)){
                return false;
            }           
        }
        return true;
    }
    boolean checkPhoneNumber(String txt){
        for(int c : txt.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }           
        }
        if ((txt.toCharArray().length)<10 ||(txt.toCharArray().length)>10 ) {
            return false;
        }
        return true;
    }
}
