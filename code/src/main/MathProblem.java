package main;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @Classname MathProblem
 * @Description 数学方法解决的问题
 * @Date 2021/5/30 21:21
 * @Created by cvmao
 */
public class MathProblem {
    /**
     * 计算n个台阶，只能走一步或两步有多少种走法
     * f(1)=1,f(2)=2,f(3)= 1+2,f(4)=
     * x 0->n
     * <p>
     * 递归算法********
     *
     * @param n n个台阶
     * @return numbers
     * @author qqg
     * @date
     */
    public static int solveFloorProblemsByRecursion(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return solveFloorProblemsByRecursion(n - 2) + solveFloorProblemsByRecursion(n - 1);

    }

    /**
     * 迭代算法
     * 问题关键最后一步只有两种情况：走一层，走两层
     * 走一层的情况，则有 n-1个台阶时的f(n-1)种走法
     * 走二层的情况，则有 n-2个台阶时的f(n-2)种走法
     */
    public static int solveFloorProblemsByLoop(int n) {
        //初始化走到第二个台阶
        int one = 2;
        //初始化走到第一个台阶
        int two = 1;
        //记录第n个台阶的方案个数
        int sum = 0;
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == two) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            //最后跨一步和跨两步的走法
            sum = one + two;
            //下一次最后跨两步的走法
            two = one;
            //下一次最后跨一步的走法
            one = sum;
        }
        return sum;
    }

    /**
     * 数学解法    阶乘排序思路
     * x+2y =n
     * x+y = m
     * 计算有多少种走法即x:0——>n的情况下总共有多少种xy的排列方法
     */
    public static int solveFloorProblemsByFactorial(int n) {
        Map<Integer, Integer> mulResults = new HashMap<>(n + 1);
        mulResults.put(0, 1);
        for (int num = 1; num < n + 1; num++) {
            mulResults.put(num, mulResults.get(num - 1) * num);
        }
        int y2;
        int sum = 0;
        for (int x = 0; x < n + 1; x++) {
            int y = 0;
            y2 = n - x;
            if (y2 % 2 == 0) {
                y = y2 / 2;
                sum += mulResults.get(x + y) / mulResults.get(x) / mulResults.get(y);
            }
        }
        return sum;
    }

    /**
     * 寻找两个正序数组的中位数
     *
     * @param nums1 数组1 nums2数组2
     * @return double 中位数
     * @author qqg
     * @date 2021/06/06
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> numbers = new ArrayList<>();
        for (int i : nums1) {
            numbers.add(i);
        }
        for (int i : nums2) {
            numbers.add(i);
        }
        Collections.sort(numbers);
        if (numbers.size() == 0) {
            return 0.0;
        }
        int size = numbers.size();
        if (numbers.size() % 2 == 1) {
            return numbers.get(size / 2);
        }
        return (numbers.get(size / 2) + numbers.get(size / 2 - 1)) / 2.0;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode headNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode headNode) {
        ArrayList<Integer> results = new ArrayList<>();
        if(Objects.isNull(headNode)){
           return results;
        }
        results.add(headNode.val);
        if(Objects.isNull(headNode.next)){
            return results;
        }
        Arrays.asList(new String[]{"2"});
        results.addAll(printListFromTailToHead2(headNode.next));
        return results;
    }



}
