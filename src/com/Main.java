package com;

import java.util.*;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter in a string: "); // Request user input for the string

        String userInput = sc.nextLine().toLowerCase();
        wordFrequency(userInput);
    }

    public static void wordFrequency(String input) {
        Map<String,Integer> unsortedMap=new TreeMap<>(); //Create map to store words and count from string

        String arr[]=input.split(" "); //Parse words on space to an array

        for(int i=0;i<arr.length;i++) // Iterate over the array to check if word is contained in the map
        {
            if(unsortedMap.containsKey(arr[i]))
            {
                unsortedMap.put(arr[i], unsortedMap.get(arr[i])+1);
            }
            else
            {
                unsortedMap.put(arr[i],1);
            }
        }

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>(); //Map created to sort

        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), Integer.valueOf(x.getValue().toString())));

        BiConsumer<String, Integer> countAndWord = (word, count) -> { //Format printed map
            System.out.println(count + " " + word);
        };

        sortedMap.forEach(countAndWord);

    }
}
