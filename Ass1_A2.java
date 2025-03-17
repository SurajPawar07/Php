//2. Construct a linked list containing names of colors and perform operations.

import java.util.*;

class Ass1SetA2 {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("yellow");
        colors.add("orange");

        System.out.println("Colors: " + colors);

        System.out.println("\nContents of List using an Iterator:");
        Iterator<String> itr = colors.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("\nReverse Contents of list using ListIterator:");
        ListIterator<String> listItr = colors.listIterator(colors.size());
        while (listItr.hasPrevious()) {
            System.out.println(listItr.previous());
        }

        LinkedList<String> newColors = new LinkedList<>();
        newColors.add("pink");
        newColors.add("green");

        ListIterator<String> listItr2 = colors.listIterator();
        while (listItr2.hasNext()) {
            if (listItr2.next().equals("blue")) {
                for (String color : newColors) {
                    listItr2.add(color);
                }
            }
        }

        System.out.println("\nUpdated Colors: " + colors);
    }
}
