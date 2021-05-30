package main;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname FirstDay
 * @Description TODO
 * @Date 2021/5/30 8:14
 * @Created by cvmao
 */
public class FirstDay {

    /**
     * 判断整数是否是2的次幂
     *
     * @param n 整数
     * @return n是否是2的次幂
     * @author qqg
     * @date 2021/5/30 8:14
     */
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n % 2 == 1) {
            if (n == 1) {
                return true;
            }
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    /**
     * 位运算简单实现 判断N是否是2的次幂
     *
     * @author qqg
     */
    public static boolean isPowerOfTwoEasy(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    /**
     * 数组numbers   整数n  返回两个加数的下标
     */
    public static int[] findTwoSum(int[] numbers, int n) {
        Map<Integer, Integer> keyvalue = new HashMap<>();
        int[] result = new int[2];
        for (int index = 0; index < numbers.length; index++) {
            int num = numbers[index];
            if (keyvalue.containsKey(num)) {
                result[0] = keyvalue.get(num);
                result[1] = index;
            } else {
                keyvalue.put(n - num, index);
            }
        }
        return result;
    }
}
