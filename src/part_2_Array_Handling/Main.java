package part_2_Array_Handling;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static int size;

    public static void main(String[] Args) {
        int[] myArray = getArrayComps();

        System.out.println();
        System.out.println("Array created: ");
        int sumOfElements = sumArray(myArray);
        printArray(myArray);
        print("\nSum of elements is: " + sumOfElements);

        System.out.println("\n");

        int[] myArrayRan = getRandomArrayComps();

        System.out.println();
        System.out.println("Array of random elements created: ");
        printArray(myArrayRan);

        System.out.println("\n");
    }

    public static void print(String prompt) {
        System.out.print(prompt);
    }

    public static int[] getArrayComps() {
        print("\nPlease input size of an array: ");
        size = scanner.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            print("Enter element #" + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        return arr;
    }

    public static int[] getRandomArrayComps() {
        System.out.print("Please input size of random elements array: ");
        size = scanner.nextInt();

        int[] arr = new int[size];

        for (int j = 0; j < size; j++) {
            arr[j] = random.nextInt(-10000, 10000);
        }

        return arr;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}