// 3. Create a Hash table containing student names and percentages, and search for a specific student.

import java.io.*;
import java.util.*;

class AssiSetA3 {
    public static void main(String[] args) throws IOException {
        Hashtable<String, Double> HT = new Hashtable<>();
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HT.put("Nagesh", 77.88);
        HT.put("Anmir", 37.87);
        HT.put("Pallavi", 88.67);
        HT.put("Ramash", 80.58);

        System.out.println(HT + "\n");

        System.out.println("Enter student name to search:");
        str = br.readLine();

        if (HT.containsKey(str)) {
            System.out.println("Name: " + str + ", Percentage: " + HT.get(str));
        } else {
            System.out.println("Student information not found.");
        }
    }
}
