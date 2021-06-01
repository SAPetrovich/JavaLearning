package HomeworkAfterLesson;

import java.io.*;
import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String srcFileName = "HomeworkAfterLesson4.TestData.txt";
        String dstFileName = "HomeworkAfterLesson4.Result.txt";
        char oldChar = 'я';
        char newChar = ' ';

        System.out.printf("Программа заменяет символы '%c' на символы '%c' в текстовом файле.\n\n", oldChar, newChar);

        srcFileName = getFileName("Имя входного файла", srcFileName);
        dstFileName = getFileName("Имя выходного файла", dstFileName);

        System.out.printf("Преобразования файла '%s' в файл '%s' ...\n", srcFileName, dstFileName);
        try {
            processFile(srcFileName, dstFileName, oldChar, newChar);
            System.out.println("Преобразование выполнено.");
        } catch (IOException e) {
            System.out.printf("Ошибка преобразования файла '%s' в файл '%s':\n\t%s\n", srcFileName, dstFileName, e.getMessage());
        }
    }

    private static String getFileName(String prompt, String defaultValue) {
        System.out.printf("%s [%s] ? ", prompt, defaultValue);
        String inputValue = scanner.nextLine();
        return (inputValue.isEmpty() ? defaultValue : inputValue);
    }

    private static void processFile(String srcFileName, String dstFileName, char oldChar, char newChar) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(srcFileName))) {
            try (BufferedWriter writter = new BufferedWriter(new FileWriter(dstFileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // TODO : Уточнить у преподавателя. Как правильно обеспечить формат разделителя соответствующий формату исходного файла.
                    writter.write(line.replace(oldChar, newChar) + "\r\n");
                }
            }
            catch (IOException e) {
                // нет уверенности что выходной файл корректен, удалим его.
                if (! new File(dstFileName).delete()) {
                    // TODO : Уточнить у преподавателя. Как правильно добавить что-то еще к e. В данном случае, сообщение что выходной файл некорректен, и не удален.
                }
                throw e;
            }
        }
    }

}
