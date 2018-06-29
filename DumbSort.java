package com.company;

import java.util.Scanner;

public class DumbSort {

    public static void main(String args[]) throws  Exception{

        final Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        int arrayLength;
        int[] array;

        for(int i =0; i < tc; i++){
            arrayLength = sc.nextInt();

            //Initilize the array
            array = new int[arrayLength];

            //Read and insert the array elements
            for (int j=0; j < arrayLength; j++){
                array[j] = sc.nextInt();
            }

            for (int m = arrayLength; m >= 0; m--) {
                for(int k=0; k < arrayLength; k++){

                    if(k+2 < arrayLength && array[k] > array[k+2]){
                        swap(array, k);
                    } else {
                        continue;
                    }
                    //System.out.println(Arrays.toString(array));
                }
            }

            //Check is sorted
            int check = arraySortedOrNot(array, arrayLength);
            if(check == 0){
                System.out.println("Case #"+(i+1)+": "+"OK");
            } else {
                System.out.println("Case #"+(i+1)+": "+check);
            }
        }
    }

    public static void swap(int[] array, int k) {
        int temp;
        temp = array[k];
        array[k] = array[k + 2];
        array[k + 2] = temp;
    }

    static int arraySortedOrNot(int arr[], int n)
    {
        // Array has one or no element or the
        // rest are already checked and approved.
        if (n == 1 || n == 0)
            return 0;

        // Unsorted pair found (Equal values allowed)
        if (arr[n-1] < arr[n-2])
            return 1;

        // Last pair was sorted
        // Keep on checking
        return arraySortedOrNot(arr, n-1);
    }
}
