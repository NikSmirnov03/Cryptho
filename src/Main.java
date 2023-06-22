import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("Меню");
        System.out.println("Выберите пункт меню: ");
        System.out.println("1. Шифрование / расшифровка.");
        System.out.println("2. Криптоанализ методом brute force.");
        try (Scanner sc = new Scanner(System.in)) {
            int punkt = sc.nextInt();
            switch (punkt) {
                case 1:
                    System.out.println("Вы выбрали пункт 1");
                    System.out.println("Введите ключ");
                    int key = sc.nextInt();
                    // Шифруем
                    Encryptor.encryption(".\\src\\original.txt",
                            ".\\src\\encrypto.txt", key);
                    // Дешифруем
                    Encryptor.encryption(".\\src\\encrypto.txt",
                            ".\\src\\decrypto.txt", -key);
                    break;
                case 2:
                    System.out.println("Вы выбрали пункт 2");
                    // Брутфорсим, получаем массив ключей
                    int[] keys = BrutForce.brutForce(".\\src\\encrypto.txt");    // ToDo: решить нужно ли делать проверку, что в диапазоне keys
                    System.out.println("Выберите правильный вариант(Введите цифру)");
                    int trueKey = sc.nextInt();
                    Encryptor.encryption(".\\src\\encrypto.txt",
                            ".\\src\\decryptoBrutforce.txt", trueKey);
                    break;
                default:
                    System.out.println("Такого пункта нету");
            }

        } catch (Exception e) {
            System.out.println("Ошибка, скорее всего вы ввели не цифру");
        }
    }

}