import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;

/**
 * Created by Andrew on 11/22/2015.
 */
public class MyMergeSort {



    public static void main (String args[]) {

        int[] inputArray = {7, 3, 8, 2, 1, 9, 5, 6, 4};

        for (int i:inputArray) {
            System.out.print(i);
        }

        System.out.println();

        sort(inputArray);

        for (int i:inputArray) {
            System.out.print(i);
        }

    }

    public static void sort(int[] inputArray) {

        if (inputArray.length <= 1) {

            return;

        }

        int mid = (inputArray.length/2);
        int[] left = new int[mid];
        int[] right = new int[inputArray.length-mid];

        for (int i=0; i<mid; i++) {
            left[i] = inputArray[i];
        }
        for (int i=0; i<(inputArray.length-mid); i++) {
            right[i] = inputArray[mid+i];
        }

        sort(left);
        sort(right);
        merge(left, right, inputArray);

    }

    public static void merge(int[] left, int[] right, int[] outputArray) {

        int leftStart = 0;
        int rightStart = 0;

        for (int outputIndex=0; outputIndex<outputArray.length; outputIndex++) {
            if (leftStart >= left.length) {
                outputArray[outputIndex] = right[rightStart++];

            }

            else if (rightStart >= right.length) {
                outputArray[outputIndex] = left[leftStart++];

            }

            else if (left[leftStart] <= right[rightStart]) {
                outputArray[outputIndex] = left[leftStart++];

            }

            else {
                outputArray[outputIndex] = right[rightStart++];


            }

        }

    }

}
