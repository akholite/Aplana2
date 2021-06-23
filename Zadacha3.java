import java.util.Scanner;

public class Zadacha3 {
    public static void main(String[] args) {
        System.out.println("Введите 1 для запуска калькулятора или 2 для поиска самого длинного слова в массиве:");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1)
        {
            System.out.println("Введите через пробел 2 числа и один из символов +, -, * или /");

            double x = sc.nextDouble();
            double y = sc.nextDouble();
            String op = sc.next();

            switch (op) {
                case "+":
                    System.out.printf("Результат равен = %.4f", x + y);
                    break;
                case "-":
                    System.out.printf("Результат равен = %.4f", x - y);
                    break;
                case "*":
                    System.out.printf("Результат равен = %.4f", x * y);
                    break;
                case "/":
                    System.out.printf("Результат равен = %.4f", x / y);
                    break;
                default:
                    System.out.println("Ввведен некорректный символ");
            }
        }
        else if (n == 2)
        {
            System.out.println("Введите размер массива слов:");

            int m = sc.nextInt();
            sc.nextLine();
            String words[] = new String[m];

            System.out.println("Введите слова для массива через enter:");

            for (int i = 0; i < m; i++) {
                words[i] = sc.nextLine();
            }

            int max = 0;

            for (int i = 0; i < m; i++) {
                if (words[i].length() > max)
                    max = words[i].length();
            }

            System.out.println("Длина самого длинного из заданных слов: " + max);
        }
        else
            System.out.println("Некорректный параметр");
    }
}
