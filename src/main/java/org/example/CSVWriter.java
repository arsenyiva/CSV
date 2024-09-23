package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * Класс для записи данных в CSV файл.
 * Предоставляет метод для записи списка объектов в файл в формате CSV.
 */
public class CSVWriter {
    private final CSVConfig config;

    public CSVWriter(CSVConfig config) {
        this.config = config;
    }

    /**
     * Записывает список объектов в файл в формате CSV.
     *
     * @param <T>      Тип объектов в списке.
     * @param data     Список объектов, которые будут записаны в файл.
     * @param filePath Путь к файлу, в который будут записаны данные.
     */
    public <T> void writeToFile(List<T> data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withDelimiter(config.getDelimiter().charAt(0)))) {

            if (config.isIncludeHeaders() && !data.isEmpty()) {
                csvPrinter.printRecord(CSVUtil.getHeaderLine(data.get(0), config));
            }

            for (T obj : data) {
                csvPrinter.printRecord(CSVUtil.convertObjectToCSVLine(obj, config));
            }
            System.out.println("Файл успешно записан");
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}