import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        while (count <= 1) {
            if (count < 1) {
                System.out.println("Некорректное значение для подсчёта.");
            } else {
                System.out.println("Нет смысла ничего считать и делить на одного человека.");
            }
            System.out.println("Введите корректное значение:");
            count = scanner.nextInt();
        }
        Calculator calc = new Calculator(count);
        System.out.println("Введите название товара, затем его цену:");
        while (true) {
            System.out.println("Для того, что бы завершить добавление товаров, наберите \"Завершить\"");
            System.out.println("Или продолжайте ввод товаров.");
            String nameGood = scanner.next();
            if (nameGood.equalsIgnoreCase("Завершить")) {
                break;
            }
            float costGood = scanner.nextFloat();
            if (costGood <= 0) {
                System.out.println("Стоимость не может быть меньше или равна 0!");
            } else {
                calc.addGood(nameGood, costGood);
            }
        }
        calc.calculate();
    }
}