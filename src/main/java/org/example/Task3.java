import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Читаем размер массива
        int n = sc.nextInt();

        // Если n == 0, дальше читать нечего
        if (n == 0) {
            System.out.println();
            System.out.println("comparisons: 0");
            System.out.println("swaps: 0");
            System.out.println("passes: 0");
            return;
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Счётчики
        int comparisons = 0;
        int swaps = 0;
        int passes = 0;

        // Пузырьковая сортировка
        for (int i = 0; i < n - 1; i++) {
            passes++;
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;
                if (a[j] > a[j + 1]) {
                    // Обмен
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            // Если обменов не было — массив отсортирован
            if (!swapped) {
                break;
            }
        }

        // Вывод массива
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();

        // Вывод метрик
        System.out.println("comparisons: " + comparisons);
        System.out.println("swaps: " + swaps);
        System.out.println("passes: " + passes);

        sc.close();
    }
}