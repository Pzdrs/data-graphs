package me.pzdrs.dataGraphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<Person> parseCVS(File file) throws FileNotFoundException {
        List<Person> data = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        for (String values : scanner.nextLine().split(",")) {
            String[] splitValues = values.split(" ");
            data.add(new Person(splitValues[0], new Double(splitValues[1])));
        }
        return data;
    }
}
