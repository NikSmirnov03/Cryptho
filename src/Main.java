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
                case 1 -> {
                    System.out.println("Вы выбрали пункт 1");
                    System.out.println("Введите ключ");
                    int key = sc.nextInt();
                    // Шифруем
                    Encryptor.encryption(".\\src\\original.txt",
                            ".\\src\\encrypto.txt", key);
                    // Дешифруем
                    Encryptor.encryption(".\\src\\encrypto.txt",
                            ".\\src\\decrypto.txt", -key);
                    System.out.println("Готово, имя расшифрованного файла decrypto.txt, зашифрованного encrypto.txt");
                }
                case 2 -> {
                    System.out.println("Вы выбрали пункт 2");
                    // Брутфорсим, получаем ключ
                    int trueKey = BrutForce.brutForce(".\\src\\encrypto.txt", ".\\src\\original.txt");
                    // Дешифруем, полученным ключом файл
                    Encryptor.encryption(".\\src\\encrypto.txt",
                            ".\\src\\decryptoBrutforce.txt", trueKey);
                    System.out.println("Готово, имя расшифрованного файла decryptoBrutforce.txt");
                }
                default -> System.out.println("Такого пункта нету");
            }

        } catch (Exception e) {
            System.out.println("Ошибка, скорее всего вы ввели не цифру");
        }
    }

}