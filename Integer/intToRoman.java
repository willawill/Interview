import java.util.*;
public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num < 0||num>3999) 
            return null;
        if (num==0) return "N";
        int[] numerals = {
        1000,
        900,
        500,
        400,
        100,
        90,
        50,
        40,
        10,
        9,
        5,
        4,
        1
        };
        String[] romans = {
            "M",
            "CM",
            "D",
            "CD",
            "C",
            "XC",
            "L",
            "XL",
            "X",
            "IX",
            "V",
            "IV",
            "I"
        
        
        };
        StringBuffer bf = new StringBuffer();
        for(int i=0; i< numerals.length;i++){
            while (num >= numerals[i]){
                bf.append(romans[i]);
                num -= numerals[i];
            }
        }
        return new String(bf);
        
    }
}