package org.example;

import java.lang.reflect.Field;
import java.util.StringJoiner;

/**
 * Класс для работы с CSV файлами.
 * Предоставляет методы для преобразования объектов в строки CSV и получения заголовков.
 */
public class CSVUtil {

    /**
     * Преобразует объект в строку CSV, используя заданный разделитель.
     *
     * @param obj    Объект, который необходимо преобразовать в строку CSV.
     * @param config Конфигурация, содержащая параметры, такие как разделитель.
     * @return Строка, представляющая объект в формате CSV.
     * @throws IllegalAccessException Если доступ к полям объекта невозможен.
     */
    public static String convertObjectToCSVLine(Object obj, CSVConfig config) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringJoiner joiner = new StringJoiner(config.getDelimiter());

        for (Field field : fields) {
            field.setAccessible(true);
            joiner.add(field.get(obj) != null ? field.get(obj).toString() : "");
        }
        return joiner.toString();
    }

    /**
     * Получает строку заголовков для объекта, используя имена полей.
     *
     * @param obj    Объект, из которого будут получены имена полей.
     * @param config Конфигурация, содержащая параметры, такие как разделитель.
     * @return Строка заголовков в формате CSV.
     */
    public static String getHeaderLine(Object obj, CSVConfig config) {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringJoiner joiner = new StringJoiner(config.getDelimiter());

        for (Field field : fields) {
            joiner.add(field.getName());
        }
        return joiner.toString();
    }
}

