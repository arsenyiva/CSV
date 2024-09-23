package org.example;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        CSVConfig config = new CSVConfig(",", true);
        CSVWriter writer = new CSVWriter(config);

        List<BusinessObject> list = new ArrayList<>();
        list.add(new BusinessObject("value_1","value_2"));
        list.add(new BusinessObject("value_3","value_4"));
        writer.writeToFile(list, "output.csv");
    }
}