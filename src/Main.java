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
                    System.out.println("Введите путь к файлу оригиналу: ");
                    sc.nextLine();
                    String origin = sc.nextLine();
                    System.out.println("Введите путь к файлу, который будет зашифрован: ");
                    String encrypt = sc.nextLine();
                    System.out.println("Введите путь к файлу, где будет расшифрованный текст: ");
                    String decrypt = sc.nextLine();
                    System.out.println("Введите ключ");
                    int key = sc.nextInt();
                    // Шифруем
                    Encryptor.encryption(origin,
                            encrypt, key);
                    // Дешифруем
                    Encryptor.encryption(encrypt,
                            decrypt, -key);
                    System.out.println("Готово, имя расшифрованного файла " + decrypt +
                            ", зашифрованного "+ encrypt);
                }
                case 2 -> {
                    System.out.println("Вы выбрали пункт 2");
                    sc.nextLine();
                    System.out.println("Введите путь к файлу оригиналу: ");
                    String origin = sc.nextLine();
                    System.out.println("Введите путь к зашифрованному файлу: ");
                    String encrypt = sc.nextLine();
                    System.out.println("Введите путь к файлу, где будет расшифрованный текст: ");
                    String decrypt = sc.nextLine();
                    // Брутфорсим, получаем ключ
                    int trueKey = BrutForce.brutForce(encrypt, origin);
                    // Дешифруем, полученным ключом файл
                    Encryptor.encryption(encrypt,
                            decrypt, trueKey);
                    System.out.println("Готово, имя расшифрованного файла " + decrypt);
                }
                default -> System.out.println("Такого пункта нету");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Ошибка, скорее всего вы ввели не цифру");
        }
    }

}