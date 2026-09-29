package part_2_Array_Handling;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static int size;

    public static void main(String[] Args) {
        int[] myArray = null;
        boolean running = true;

        while (running) {
            System.out.println("\n ARRAY CONTROL MENU ");
            System.out.println("1. Create array manually");
            System.out.println("2. Create random array");
            System.out.println("3. Print current array");
            System.out.println("4. Calculate sum of elements");
            System.out.println("5. Find largest number");
            System.out.println("6. Search value in array");
            System.out.println("7. Exit");
            print("Select an option (1-7): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    myArray = getArrayComps();
                    System.out.println("\nArray created: ");
                    printArray(myArray);
                    System.out.println();
                    break;

                case 2:
                    myArray = getRandomArrayComps();
                    System.out.println("\nArray of random elements created: ");
                    printArray(myArray);
                    System.out.println();
                    break;

                case 3:
                    if (myArray == null) {
                        System.out.println("\nNo array created yet! Create an array first.");
                    } else {
                        System.out.println("\nCurrent Array: ");
                        printArray(myArray);
                        System.out.println();
                    }
                    break;

                case 4:
                    if (myArray == null) {
                        System.out.println("\nNo array created yet! Create an array first.");
                    } else {
                        int sumOfElements = sumArray(myArray);
                        print("\nSum of elements is: " + sumOfElements + "\n");
                    }
                    break;

                case 5:
                    if (myArray == null) {
                        System.out.println("\nNo array created yet! Create an array first.");
                    } else {
                        System.out.println("\nLargest number is: " + getLargesNumber(myArray));
                    }
                    break;

                case 6:
                    if (myArray == null) {
                        System.out.println("\nNo array created yet! Create an array first.");
                    } else {
                        System.out.println("Your arguments has index: " + searchInArray(myArray));
                    }
                    break;

                case 7:
                    running = false;
                    System.out.println("\nExiting program...");
                    break;

                default:
                    System.out.println("\nInvalid option! Please enter a number between 1 and 7.");
                    break;
            }
        }
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
            arr[j] = random.nextInt(-100, 100);
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

    public static double getLargesNumber(int[] arrayL) {
        double largestNum = arrayL[0];
        for (int i = 0; i < arrayL.length; i++ ) {
            if (largestNum < arrayL[i]) {
                largestNum = arrayL[i];
            }
        }
        return largestNum;
    }

    public static int searchInArray(int[] arrayS) {
        print("Enter an argument: ");
        int number = scanner.nextInt();

        for (int i = 0; i < arrayS.length; i++) {
            if (arrayS[i] == number) {
                return i;
            }
        }
        return -1;
    }
}