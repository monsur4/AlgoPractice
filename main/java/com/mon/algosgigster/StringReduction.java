package com.mon.algosgigster;

public class StringReduction {

    public static int stringReduction(String str){
        int i = 0; // counter
//        char[] letters = str.toCharArray();
        StringBuilder newString = new StringBuilder(str);
        do{
            if((newString.charAt(i) == 'a' && newString.charAt(i+1)== 'b') || (newString.charAt(i) == 'b' && newString.charAt(i+1)== 'a')){
                newString.replace(i, i+2, "c");
                i = 0;
            }else if((newString.charAt(i) == 'b' &&newString.charAt(i+1)== 'c') || (newString.charAt(i) == 'c' && newString.charAt(i+1)== 'b')){
                newString.replace(i, i+2, "a");
                i = 0;
            }else if((newString.charAt(i) == 'a' && newString.charAt(i+1)== 'c') || (newString.charAt(i) == 'c' && newString.charAt(i+1)== 'a')){
                newString.replace(i, i+2, "b");
                i = 0;
            }else {
                i++;
            }
        }while(i < newString.length() - 1);
        return newString.length();
    }

    public static void main(String[] args) {
        System.out.println(stringReduction("abcabc"));
        System.out.println(stringReduction("cccc"));
        System.out.println(stringReduction("baccabcbc"));
    }
}
