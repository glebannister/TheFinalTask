package framework.utils;

public class ArrayUtil {

    public static int[] getArrayInt(int from, int to) {
        int[] resultChars = new int[to - from + 1];
        for (int i = 0; i <= to - from; i++) {
            resultChars[i] = from + i;
        }
        return resultChars;
    }
}
