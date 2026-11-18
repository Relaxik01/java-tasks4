import java.util.Scanner;

public class Task1 {

    // Находим индекс минимального элемента — это и есть "точка сдвига".
    static int findPivot(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // Если средний элемент больше правого — значит, точка сдвига правее mid
            if (a[mid] > a[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Обычный бинарный поиск в отрезке [left, right].
    // Возвращает индекс элемента x или -1, если его нет.
    static int binarySearch(int[] a, int left, int right, int x) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Находим точку сдвига один раз — она одна для всех запросов
        int pivot = findPivot(a);

        // Обрабатываем каждый запрос
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int answer;

            if (x <= a[n - 1]) {
                answer = binarySearch(a, pivot, n - 1, x);
            } else {
                answer = binarySearch(a, 0, pivot - 1, x);
            }

            System.out.println(answer);
        }

        sc.close();
    }
}