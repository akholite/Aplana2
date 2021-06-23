import java.util.Scanner;
/**
 * Вычисляет сумму двух введенных с консоли дробных чисел.
 * В дальнейшем будет выполнять по выбору любую из 4 арифметических операций.
 * @author Ахмедшина Камила
 */
public class Zadacha2 {
    public static void main(String[] args) {
        System.out.println("Введите через пробел 2 числа и один из символов +, -, * или /");

        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        String op = sc.next();

        switch (op) {
            case "+":
                System.out.printf("Результат равен = %.4f", x + y);
                break;
            case "-":
            case "*":
            case "/":
                //будет реализовано в задаче 3
                break;
            default:
                System.out.println("Ввведен некорректный символ");
        }
    }
}
