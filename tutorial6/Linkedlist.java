package tutorial6;
import java.util.LinkedList;
import java.util.Scanner;

public class Linkedlist {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        System.out.print("Enter the size of list  : ");
        int size = sc.nextInt();
        System.out.print("Enter a list in ascending order : ");
        for (int i = 0; i < size; i++) {
            int inputval = sc.nextInt();
            list.add(inputval);
        }
        System.out.println("Before: " + list);
        System.out.print("Enter a value to be added into the list : ");
        int val = sc.nextInt();
        addAndSort(list, val);
        System.out.println("After: " + list);

        System.out.println("Before: " + list);
        System.out.println("Enter the pos of the two value to be swapped : ");
        int indexOne = sc.nextInt() - 1;
        int indexTwo = sc.nextInt() - 1;
        swapValues(list, indexOne, indexTwo);
        System.out.println("After: " + list);

        LinkedList<Integer> list2 = new LinkedList<>();
        int max = 9999;
        int min = 1000;
        int range = max - min + 1;
        for (int i = 0; i < 500; i++){
            list2.add((int) ((Math.random() * range) + 1000));
        }

        
        System.out.println("List    : " + list2);
        System.out.println("Search  : " + findValue(list2, (int) ((Math.random() * range) + 1000)));
        sc.close();
    }

    public static void addAndSort(LinkedList<Integer> list, int value){
        list.add(value);
        int j;
        boolean swapped;
        for(int i =0; i < list.size()-1; i++){
            swapped = false;
            for(j =0; j < list.size()-i-1; j++){
                if(list.get(j) > list.get(j+1)){
                    swapValues(list, j, j+1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void swapValues(LinkedList<Integer> list, int indexOne, int indexTwo){
        int valIdxOne = list.get(indexOne);
        int valIdxTwo = list.get(indexTwo);
        list.remove(indexOne);
        list.add(indexOne, valIdxTwo);
        list.remove(indexTwo);
        list.add(indexTwo, valIdxOne);
    }

    public static int findValue(LinkedList<Integer> list, int searchVal){
        if(list.contains(searchVal)) {
            return list.indexOf(searchVal);
        }else {
            return -1;
        }
    }
}
