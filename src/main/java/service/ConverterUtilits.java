package service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OleksiiF on 08.07.2018.
 */
public class ConverterUtilits {

    private static ArrayList<String> specialSymbolsToCompare;

   private static final Map<String, Integer> TRANSLATOR = new HashMap<String, Integer>(){
       {
           put("α", 1);
           put("β", 2);
           put("γ", 3);
           put("δ", 4);
           put("ε", 5);
           put("ζ", 6);
           put("η", 7);
           put("θ", 8);
           put("ι", 9);
       }
   };

    public static ArrayList<String> createSpecialSymbolsToCompareWithQuantityOf(int quantity){
        String xSymbol = "x";
        StringBuilder last = new StringBuilder("+");
        StringBuilder next = new StringBuilder("++");

        specialSymbolsToCompare = new ArrayList<>(Arrays.asList("|"));

        for(int i=0; i<quantity; i++){
            specialSymbolsToCompare.add(last.toString());
            last.append(xSymbol);

            specialSymbolsToCompare.add(next.toString());
            next.append(xSymbol);
        }
        return specialSymbolsToCompare;
    }

    public static ArrayList<String[]> splitTralfamadorianToParts(String tralfamadorianNumber){
        String regex = "([αβγδεζηθι]\\+*x*\\|*)";
        Matcher matcher = Pattern.compile(regex).matcher(tralfamadorianNumber);
        ArrayList<String[]> tralfmadorianPartsArray = new ArrayList<>();
        while (matcher.find()){
            tralfmadorianPartsArray.add(new String[]{matcher.group().substring(0, 1), matcher.group().substring(1)});
        }
        return tralfmadorianPartsArray;
    }

    public static long convertTralfmagorianPartsArrayToLong(ArrayList<String[]> transmadorianPartsArray){
        long answer = 0L;

        for(String[] i: transmadorianPartsArray){
            answer += TRANSLATOR.get(i[0])*Math.pow(10, specialSymbolsToCompare.indexOf(i[1]));
        }
        return answer;
    }
}
