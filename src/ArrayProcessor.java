import java.util.Random;

public class ArrayProcessor {
    public static void main(String[] args) {
        try {
            int[] array = generateRandomArray(10, -100, 100);
            displayArray(array);

            System.out.println("Найбільший елемент: " + findMax(array));
            System.out.println("Добуток елементів між перши і остайнім відємним елементом: " + calculateProductBetweenNegatives(array));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        if (size <= 0) throw new IllegalArgumentException("Розмір масиву має бути більше за 0.");
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static int findMax(int[] array) {
        if (array.length == 0) throw new IllegalArgumentException("Array is empty.");
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    public static int calculateProductBetweenNegatives(int[] array) {
        int firstNegativeIndex = -1;
        int lastNegativeIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                if (firstNegativeIndex == -1) firstNegativeIndex = i;
                lastNegativeIndex = i;
            }
        }

        if (firstNegativeIndex == -1 || lastNegativeIndex == -1 || firstNegativeIndex == lastNegativeIndex) {
            throw new IllegalArgumentException("В масиві менше 2 відємних елементів.");
        }
        int product = 1;
        for (int i = firstNegativeIndex + 1; i < lastNegativeIndex; i++) {
            product *= array[i];
        }
        return product;
    }
    public static void displayArray(int[] array) {
        System.out.print("Масив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}