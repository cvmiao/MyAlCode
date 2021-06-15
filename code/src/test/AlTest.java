package test;

import junit.framework.TestCase;
import main.FirstDay;
import main.MathProblem;
import org.junit.Test;

import java.util.*;

/**
 * @Classname FirstDayTest
 * @Description TODO
 * @Date 2021/5/30 8:14
 * @Created by cvmao
 */
public class AlTest {
    @Test
    public void isPowerOfTwoTest() {
        assert !FirstDay.isPowerOfTwo(-1);
        assert !FirstDay.isPowerOfTwo(0);
        TestCase.assertTrue(FirstDay.isPowerOfTwo(8));
        TestCase.assertTrue(FirstDay.isPowerOfTwo(128));
        TestCase.assertTrue(FirstDay.isPowerOfTwo(1));
        TestCase.assertFalse(FirstDay.isPowerOfTwo(7));
    }


    @Test
    public void isPowerOfTwoEasyTest() {
        assert !FirstDay.isPowerOfTwoEasy(-1);
        assert !FirstDay.isPowerOfTwoEasy(0);
        TestCase.assertTrue(FirstDay.isPowerOfTwoEasy(8));
        TestCase.assertTrue(FirstDay.isPowerOfTwoEasy(128));
        TestCase.assertTrue(FirstDay.isPowerOfTwoEasy(1));
        TestCase.assertFalse(FirstDay.isPowerOfTwoEasy(7));
    }


    @Test
    public void findTwoSumTest() {
        int[] numbers = {3, 2, 4};
        int[] result = FirstDay.findTwoSum(numbers, 6);
        assert Objects.deepEquals(new int[]{1, 2}, result);
        Set aas = new LinkedHashSet<>();

        assert Arrays.equals(new int[]{
                1, 2
        }, result);
    }

    @Test
    public void findMedianSortedArraysTest() {
        int[] num1 = {1};
        int[] num2 = {2, 3};
        assert 2.0 == MathProblem.findMedianSortedArrays(num1, num2);
        String.join("12", new String[]{"qww", "eee"});
        String.join("oo", new ArrayList<String>() {{
            add("ddd");
            add("sss");
        }});
    }
}
