import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrutForce {

    public static int[] brutForce(String input) throws FileNotFoundException {
        // для общего алфавита
        Alphabet singleAlphabet = new Alphabet("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ");
        List<Character> one = singleAlphabet.makeAlphabet();

        int capacity = singleAlphabet.getCapacity();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            // Читаем 1 строчку для проверки на нужный ключ
            String line = reader.readLine();

            List<String> list = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                list.add(brutForceOne(line, i, one));
            }

            int[] keys = new int[capacity];
            // Выводим все строчки, дабы пользователь сказал, что аж есмь истинна
            for (int i = 0; i < capacity; i++) {
                System.out.println("-------------------------------------");
                System.out.println(i + ". " + list.get(i));
                keys[i] = i;
            }

            return keys;

        } catch (IOException e) {
            throw new RuntimeException(e);
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
