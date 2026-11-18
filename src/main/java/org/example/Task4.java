import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Считываем размер массива и количество доступных операций
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Счётчик обменов
        int swapsCount = 0;

        // Основной цикл: идём по каждой позиции, где можно сделать обмен
        for (int i = 0; i < n - 1; i++) {
            // Если операции закончились, дальше смысла идти нет
            if (k == 0) {
                break;
            }

            // Ищем индекс минимального элемента
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // Если минимальный элемент находится не на текущей позиции i,
            // то совершаем обмен
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;

                swapsCount++;
                k--;
            }
        }

        // Выводим итоговый массив
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();

        // Выводим метрику
        System.out.println("swaps: " + swapsCount);

        sc.close();
    }
}