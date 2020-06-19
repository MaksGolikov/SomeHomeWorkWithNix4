package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StringLogic implements GeneralMethods {

    public StringLogic(File file) throws FileNotFoundException {

        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        this.text = sb.toString();
    }

    private final String text;

    public void countAllSymbolsAndSortAscending() {

        System.out.println("The count of symbols: " + text.length());

        List<Character> allList = new ArrayList<>();
        Set<Character> uniqueSet = new LinkedHashSet<>();
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            allList.add(arr[i]);
            uniqueSet.add(arr[i]);
        }
        printMap(sortAscendingAndPrint(countOfSomething(allList, uniqueSet)));
    }

    public void countAllWordsAndSortAscending() {
        String[] arr = text.split("$|\\.|,|!|\\?|;|:|\\s|\n");

        List<String> allList = new ArrayList<>();
        Set<String> uniqueSet = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            allList.add(arr[i]);
            uniqueSet.add(arr[i]);
        }

        Map<String, Integer> map = sortAscendingAndPrint(countOfSomething(allList, uniqueSet));
        map.remove("");
        printMap(map);

        int countOfWords = 0;
        for (Map.Entry<String, Integer> me: sortAscendingAndPrint(countOfSomething(allList, uniqueSet)).entrySet()) {
            countOfWords+=me.getValue();
        }
        System.out.println("The count of words: " + countOfWords);
    }

    public void reverseAllWordsInEachSentence() {
        String[] arr = text.split("\\. |! |\\? |\\.");

        List<String> listOfSentences = new ArrayList<>(Arrays.asList(arr));
        for (int i = 0; i < listOfSentences.size(); i++) {
            String []arr1 = listOfSentences.get(i).split(" ");
            Collections.reverse(Arrays.asList(arr1));
            listOfSentences.set(i, String.join(" ", arr1));
            System.out.println(listOfSentences.get(i));
        }

    }


    public void countAllTheRootsInTextAndSortWithWriteInFile() {
        System.out.println("Oopss... :)");
    }

    private static <T> Map<T, Integer> countOfSomething(List<T> allList, Set<T> uniqueSet) {
        List<T> uniqueList = new ArrayList<>(uniqueSet);
        Map<T, Integer> unsortedMap = new LinkedHashMap<>();
        int counter = 0;
        for (int i = 0; i < uniqueList.size(); i++) {
            for (int j = 0; j < allList.size(); j++) {
                if (uniqueList.get(i).equals(allList.get(j))) {
                    counter++;
                }
                unsortedMap.put(uniqueList.get(i), counter);
            }
            counter = 0;
        }
        return unsortedMap;
    }

    private static <T> Map<T, Integer> sortAscendingAndPrint(Map<T, Integer> unsortedMap) {
        List<Map.Entry<T, Integer>> list = new LinkedList<>(unsortedMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<T, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<T, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    private static <T> void printMap(Map<T, Integer> map) {
        for (Map.Entry<T, Integer> me : map.entrySet()) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }
    }


}
