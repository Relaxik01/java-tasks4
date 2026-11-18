import java.util.Scanner;

// Класс, который хранит массив и реализует все операции
class SortedArray {
    private int[] data;
    private int size;

    // создаём пустой массив с начальной ёмкостью
    public SortedArray(int initialCapacity) {
        this.data = new int[Math.max(initialCapacity, 10)];
        this.size = 0;
    }

    // Добавляет элемент в отсортированный массив
    public void add(int x) {
        // 1. Расширяем массив, если места больше нет
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }

        // 2. Ищем индекс, куда вставить x (первый элемент >= x)
        int pos = lowerBound(x);

        // 3. Сдвигаем элементы вправо, чтобы освободить место
        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }

        // 4. Вставляем элемент
        data[pos] = x;
        size++;
    }

    // Удаляет одно вхождение x. Возвращает true, если удалось
    public boolean remove(int x) {
        int pos = lowerBound(x);
        // Если элемента нет
        if (pos == size || data[pos] != x) {
            return false;
        }

        // Сдвигаем элементы влево
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    // Проверяет, есть ли элемент (через бинарный поиск)
    public boolean contains(int x) {
        int pos = lowerBound(x);
        return pos < size && data[pos] == x;
    }

    // Считает количество элементов в диапазоне
    public int countRange(int L, int R) {
        if (L > R) return 0;
        int leftIdx = lowerBound(L);
        int rightIdx = upperBound(R);
        return rightIdx - leftIdx;
    }

    // Выводит текущий массив
    public void print() {
        for (int i = 0; i < size; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(data[i]);
        }
        System.out.println();
    }

    // Бинарный поиск: индекс первого элемента >= x
    private int lowerBound(int x) {
        int left = 0;
        int right = size;
        while (left < right) {
            int mid = (left + right) / 2;
            if (data[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Бинарный поиск: индекс первого элемента > x
    private int upperBound(int x) {
        int left = 0;
        int right = size;
        while (left < right) {
            int mid = (left + right) / 2;
            if (data[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

// Основной класс
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        // Создаём контейнер
        SortedArray arr = new SortedArray(n + q);

        // Читаем исходные значения и добавляем в контейнер
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // Обрабатываем q команд
        for (int i = 0; i < q; i++) {
            String command = sc.next();

            if (command.equals("ADD")) {
                int x = sc.nextInt();
                arr.add(x);
            } else if (command.equals("CONTAINS")) {
                int x = sc.nextInt();
                System.out.println(arr.contains(x) ? "YES" : "NO");
            } else if (command.equals("REMOVE")) {
                int x = sc.nextInt();
                arr.remove(x);
            } else if (command.equals("COUNT_RANGE")) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(arr.countRange(l, r));
            } else if (command.equals("PRINT")) {
                arr.print();
            }
        }

        sc.close();
    }
}