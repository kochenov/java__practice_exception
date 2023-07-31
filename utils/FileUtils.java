package utils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Утилитарный класс для работы с файлами.
 */
public class FileUtils {
    /**
     * Метод для записи данных в файл.
     *
     * @param filename Имя файла.
     * @param data     Данные для записи.
     * @throws IOException Исключение при ошибке записи в файл.
     */
    public static void writeToFile(String filename, String data) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            fileWriter.write(data);
        }
    }
}
