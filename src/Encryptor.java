import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Encryptor {
    private static Alphabet singleAlphabet = new Alphabet("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ");

    // Функция, устанавливающая алфавит(если нам нужен не по умолчанию
    public static void setSingleAlphabet(Alphabet singleAlphabet) {
        Encryptor.singleAlphabet = singleAlphabet;
    }

    // Метод шифровки/дешифровки с записью в файл
    public static void encryption(String source, String dest, int key) {
        try (FileReader input = new FileReader(source);
             FileWriter output = new FileWriter(dest)) {
            while (input.ready()) {

                int oldChar = input.read();

                // для общего алфавита
                List<Character> one = singleAlphabet.makeAlphabet();
                if (one.contains((char) oldChar)) {
                    oldChar = Encryptor.encrypt(one, oldChar, key);
                }
                // Если символ, который надо пропустить
                output.write((int) oldChar);

            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка с файлами");
        }
    }

    // Мудрим с перестановкой используя ключ
    public static char encrypt(List<Character> alphabet, int oldChar, int key) {
        int index = alphabet.indexOf((char) oldChar);
        // Если новый index будет за пределами
        if (index + key > alphabet.size() - 1) {
            index = (index + key) % alphabet.size();
        } else if (index + key < 0) {
            index = ((index + key) % alphabet.size()) + alphabet.size(); // Взять модуль?
            if (index == alphabet.size()) {
                index = 0;
            }
        } else {
            index = index + key;
        }

        return alphabet.get(index);

    }
}
