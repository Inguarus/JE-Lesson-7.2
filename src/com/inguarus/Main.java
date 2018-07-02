package com.inguarus;

public class Main {

    public static void main(String[] args) {

        MySet<String> countries = new MyHashSet<>(15);

        countries.add("USA");
        countries.add("England");
        countries.add("Scotland");
        countries.add("Sweden");
        countries.add("Ukraine");
        countries.add("Croatia");
        countries.add("Denmark");
        countries.add("Brazil");
        countries.add("Russia");
        countries.add("Spain");
        countries.add("Germany");
        countries.add("Portugal");
        countries.add("Nigeria");

        System.out.println("Number of items in the list: " + countries.size() + " elements");
        System.out.println("Countries list: ");
        System.out.println(countries);
        System.out.println(countries.contains("USA"));
        System.out.println(countries.contains("USSR"));
        System.out.println();
        countries.remove("USA");
        countries.remove("England");
        countries.remove("Scotland");
        System.out.println(countries);
        System.out.println(countries.isEmpty());
        System.out.println();

        Object[] objArray = countries.toArray();
        System.out.println("Array countries: ");
        for (int index = 0; index < objArray.length; index++)
            System.out.println(objArray[index]);

        System.out.println("Countries list cleared: ");
        countries.clear();
        System.out.println(countries);

    }
}
