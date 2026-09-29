package part_1_Array_Syntax;

public class Main {
    public static void main(String[] Args) {

        //part.1
        int[] arr1 = new int[10];

        int var = 5;
        int[] arr2 = new int[var];

        int[] arr3 = {1, 2, 3, 4};

        int[] intArray = {10, 20, 30};
        double[] doubleArray = {1.5, 2.75, 3.14159};
        String[] stringArray = {"Java", "Python", "C++"};
        char[] charArray = {'A', 'B', 'C', 'D'};
        boolean[] booleanArray = {true, false, true};

        System.out.println(stringArray.length);

        //part.2
        arr1[4] = 45;

        System.out.println(booleanArray[2]);

        //part.3
        System.out.println("\nFor loop:");
        for (int i = 0; i < 3; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println("");

        System.out.println("\nEnhanced for loop:");
        for (double arr : doubleArray) {
            System.out.print(arr + " ");
        }
        System.out.println("");

        System.out.println("\nWhile loop:");
        int index = 0;
        while (index < charArray.length) {
            System.out.print(charArray[index] + " ");
            index++;
        }


    }
}
