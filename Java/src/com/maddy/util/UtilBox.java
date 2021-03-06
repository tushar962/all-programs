package com.maddy.util;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gitanjali on 31/01/17.
 */
public class UtilBox
{
    /*
     * returns index of element in array, if element doesn't exist returns 1
     */
    public static int find(ArrayList<Integer> array, int key)
    {
        if (array != null)
        {
            for (int i = 0; i < array.size(); i++)
            {
                if (array.get(i) == key)
                    return i;
            }
        }

        return -1;
    }

    public static int[] userInputArray()
    {
        Scanner sc = new Scanner(System.in);
        int in;

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter array element: ( -999 to exit)");
        while ((in = sc.nextInt()) != -999)
        {
            list.add(in);
        }

        int a[] = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            a[i] = list.get(i);
        }

        return a;
    }

    public static void printArray(int[] array)
    {
        for (int item : array)
            System.out.print(item + " ");

        System.out.println();
    }

    public static int getMax(int[] array)
    {
        if (array.length < 1)
            return Integer.MAX_VALUE;

        int max = array[0];
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] > max)
                max = array[i];
        }

        return max;
    }

    public static void printMatrix(int[][] matrix)
    {
        if (matrix == null)
            return;

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
