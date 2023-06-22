import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    // Мощность алфавита
    private int capacity;

    // Алфавит в виде строки
    private String alphabet;

    public Alphabet(String alphabet) {
        this.alphabet = alphabet;
        this.capacity = alphabet.length();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getAlphabet() {
        return alphabet;
    }

    // Преобразоване из строки в лист
    public  List<Character> makeAlphabet() {
        List<Character> listAlphabet = new ArrayList<>(capacity);
        for (char ch :  alphabet.toCharArray()) {
            listAlphabet.add(ch);
        }
        return listAlphabet;
    }
}
