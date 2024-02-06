import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        int count = -1;
        float costGood = 0.0f;
        while (count <= 1) {
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count <= 1) {
                    if (count < 1) {
                        System.out.println("Некорректное значение для подсчёта.");
                    } else {
                        System.out.println("Нет смысла ничего считать и делить на одного человека.");
                    }
                    System.out.println("Введите корректное значение:");
                }
            } else {
                scanner.next();
                System.out.println("Необходимо вводить только цифры!");
            }
        }
        Calculator calc = new Calculator(count);
        System.out.println("Введите название товара, затем его цену:");
        while (true) {
            scanner.nextLine(); // Убираем перенос строки оставшийся от nextInt() или nextFloat()
            String nameGood = scanner.nextLine(); // Может состоять из нескольких слов, например "Горошек зеленый"
            if (nameGood.equalsIgnoreCase("Завершить")) {
                break;
            }
            while (costGood <= 0) {
                if (scanner.hasNextFloat()) {
                    costGood = scanner.nextFloat();
                    if (costGood <= 0) {
                        System.out.println("Стоимость не может быть меньше или равна 0!");
                    }
                } else {
                    scanner.next();
                    System.out.println("Вводите стоимость цифрами, например 140,50!");
                }
            }
            calc.addGood(nameGood, costGood);
            costGood = 0.0f;
            System.out.println("Для того, что бы завершить добавление товаров, наберите \"Завершить\"");
            System.out.println("Или продолжайте ввод товаров.");
        }
        calc.calculate();
        scanner.close();
    }
}