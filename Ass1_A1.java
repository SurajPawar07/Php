1. Accept integers from the user, store them in a collection, and display them in sorted order without duplicates.

import java.util.*;
import java.io.*;

class Q1 {
    public static void main(String[] args) throws Exception {
        int n;
        String search;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> ts = new TreeSet<>();

        System.out.println("\nHow many elements do you want?");
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            ts.add(Integer.parseInt(br.readLine()));
        }

        System.out.println("Elements in sorted order: " + ts);

        System.out.println("Enter the element to search:");
        search = br.readLine();

        if (ts.contains(Integer.parseInt(search))) {
            System.out.println("Element found in the collection.");
        } else {
            System.out.println("Element not found in the collection.");
        }
    }
}
