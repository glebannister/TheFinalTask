package framework.utils;

import org.apache.commons.lang3.ArrayUtils;

public class RandomUtil {
    private static final char a = 'a';
    private static final char z = 'z';
    private static final char A = 'A';
    private static final char Z = 'Z';

    public static String getLatinRandomString(int lengthOfString) {
        char[] resultChars = new char[lengthOfString];
        int[] options = ArrayUtils.addAll(ArrayUtil.getArrayInt(A, Z), ArrayUtil.getArrayInt(a, z));
        ArrayUtils.shuffle(options);
        for (int i = 0; i < lengthOfString; i++) {
            resultChars[i] = (char) options[i];
        }
        return new String(resultChars);
    }
}
