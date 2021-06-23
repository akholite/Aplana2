import java.util.Random;

public class Zadacha4_1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int size = 20;
        int[] array = new int[size];

        System.out.print("Сгенерированный массив: \n");

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(21) - 10;
            System.out.printf("%d ", array[i]);
        }
        System.out.println();

        int max, min, indmax, indmin, n;
        boolean pos, neg;
        pos = neg = false;
        indmax = indmin = 0;
        max = min = array[0];

        for (int i = 0; i < size; i++) {
            n = array[i];

            if (n > 0) {
                pos = true;
                if (min <= 0 || n < min) {
                    min = n;
                    indmin = i;
                }
            }
            else if (n < 0) {
                neg = true;
                if (max >= 0 || n > max) {
                    max = n;
                    indmax = i;
                }
            }
        }

        if (neg & pos) {
            n = array[indmin];
            array[indmin] = array[indmax];
            array[indmax] = n;

            System.out.println("Массив после замены:");
            for (int i = 0; i < size; i++) {
                System.out.printf("%d ", array[i]);
            }
        }
        else
            System.out.print("В массиве отсутствуют либо отрицательные, либо положительные элементы");
    }
}
