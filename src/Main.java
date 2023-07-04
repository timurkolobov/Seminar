import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6, 7};

        try {
            int[] result1 = getDifferenceArray(array1, array2);
            System.out.println(Arrays.toString(result1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            int[] result2 = getDivisionArray(array1, array2);
            System.out.println(Arrays.toString(result2));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] getDifferenceArray(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Массивы должны иметь одинаковую длину");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] - array2[i];
        }

        return result;
    }

    public static int[] getDivisionArray(int[] array1, int[] array2) {
        if (array1.length != array2.length || array2.length == 0) {
            throw new RuntimeException("Массивы должны иметь одинаковую ненулевую длину");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] / array2[i];
        }

        return result;
    }
}