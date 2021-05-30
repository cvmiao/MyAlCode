package main;

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
}
