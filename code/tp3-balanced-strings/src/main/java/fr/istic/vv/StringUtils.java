package main.java.fr.istic.vv;

import java.util.ArrayList;

public class StringUtils {
    private ArrayList<Character> characters;

    private StringUtils() {

    }

    private static void print(ArrayList<Character> chars, int step){
        String s = "";
        for(char c:chars){
            s+=c;
        }
        System.out.println(s+" "+step);
    }

    public static boolean isBalanced(String str) {
        ArrayList<Character> characters = getCharacters(str);
        if(characters.size()%2==1){
            return false;
        }
        for(int i = 0; i<characters.size()-1; i++) {
            print(characters, i);
            if (match(characters.get(i), characters.get(i + 1))) {
                characters.remove(i);
                characters.remove(i);
                i = -1;
            }
        }
        return characters.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isBalanced("[]"));
        System.out.println(isBalanced("{[][]}({})"));

        System.out.println(isBalanced("]["));

        System.out.println(isBalanced("{(}{}"));
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced("{"));




    }

    private static ArrayList<Character> getCharacters(String str){
        ArrayList<Character> characters = new ArrayList<>();
        for(int i = 0; i<str.length(); i++){
            char currentCharacter = str.charAt(i);
            if(isOpening(currentCharacter) || isClosing(currentCharacter)){
                characters.add(currentCharacter);
            }
        }
        return characters;
    }

    private static boolean match(char a, char b){
        return isOpening(a) && b == getClosingCounterpart(a);
    }

    private static boolean isOpening(char c){
        return c=='(' || c=='{' || c=='[';
    }

    private static boolean isClosing(char c){
        return c==')' || c=='}' || c==']';
    }

    private static char getClosingCounterpart(char c){
        return switch (c) {
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            default -> throw new IllegalArgumentException();
        };
    }

    private static char getOpeningCounterpart(char c){
        return switch (c) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            default -> throw new IllegalArgumentException();
        };
    }

}
