import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrutForce {
    private static Alphabet singleAlphabet = new Alphabet("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ");

    // Функция, устанавливающая алфавит(если нам нужен не по умолчанию
    public static void setSingleAlphabet(Alphabet singleAlphabet) {
        BrutForce.singleAlphabet = singleAlphabet;
    }

    public static int brutForce(String input, String output) {
        // для общего алфавита
        List<Character> one = singleAlphabet.makeAlphabet();

        int capacity = singleAlphabet.getCapacity();
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedReader readerOriginal = new BufferedReader(new FileReader(output))) {
            // Читаем 1 строчку для проверки на нужный ключ
            String line = reader.readLine();
            // Читаем строку из оригинального файла
            String origin = readerOriginal.readLine();

            List<String> list = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                list.add(brutForceOne(line, i, one));
            }

            int trueKey = 0;
//            // Выводим все строчки, дабы пользователь сказал, что аж есмь истинна
//            for (int i = 0; i < capacity; i++) {
//                System.out.println("-------------------------------------");
//                System.out.println(i + ". " + list.get(i));
//                keys[i] = i;
//            }

            // Сравниваем массив брутфорс срок с оригинальной строкой
            for (int i = 0; i < capacity; i++) {
                // Если совпадает, выдаем ключ, прерываем цикл
                if (list.get(i).equals(origin)) {
                    trueKey = i;
                    break;
                }
            }

            return trueKey;

        } catch (IOException e) {
            throw new RuntimeException("Ошибка с файлами");
        }
    }

    // Метод преобразования 1 строчки
    public static String brutForceOne(String line, int key, List<Character> one) {
        StringBuilder builder = new StringBuilder();

        for (char ch : line.toCharArray()) {
            if (one.contains(ch)) {
                ch = Encryptor.encrypt(one, ch, key);
            }

            builder.append((ch));
        }
        return String.valueOf(builder);
    }
}
