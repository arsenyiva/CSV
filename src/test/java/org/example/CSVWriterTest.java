package org.example;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CSVWriterTest {
    @Test
    public void testWriteToFile() {
        CSVConfig config = new CSVConfig(",", true);
        CSVWriter writer = new CSVWriter(config);
        List<BusinessObject> list = Arrays.asList(new BusinessObject("value1", "value2"));
        writer.writeToFile(list, "test.csv");

        File file = new File("test.csv");
        assertTrue(file.exists());
    }
}