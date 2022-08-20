package com.example.springbootweb.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class LeecodeTest {

    @Test
    public void test() {
        /*
            # 将5向左移动2位：
            # 程序执行过程：
            - 将十进制 5 转换成二进制表示形式（java中整数默认是是int类型，也就是32位）
                0000 0000 0000 0000 0000 0000 0101
                0000 0000 0000 0000 0000 0001 0100  （左移 2 位，转换成10进制为：20）
         */
        System.out.println(5 << 2);
    }

    /*
    给你两个二进制字符串，返回它们的和（用二进制表示）。
    输入为 非空 字符串且只包含数字 1 和 0。
     */
    @Test
    public void addBinary() {
        String a = "1011";
        String b = "1";
        System.out.println(a.charAt(1));
        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        System.out.println(ans);
    }

    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最长回文子串， 中间扩散算法
     */
    @Test
    public void longestPalindrome() {
        String s = "babad";
        int len = s.length();
        if (len < 2) {
            System.out.println(s);
        }
        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();
        // 枚举所有长度大于 1 的子串 charArray[i..j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        System.out.println(s.substring(begin, begin + maxLen));
    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //------ 双指针算法@盛最多的水
    @Test
    public void maxArea() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        System.out.println(ans);
    }

    /**
     * ----Z 字形变换 leetcode:https://leetcode.cn/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */
    @Test
    public void convert() {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        if (numRows < 2) System.out.println(s);
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        System.out.println(res);
    }

    /**
     * 最长公共子序列
     * <p>
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * <p>
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     */
    @Test
    public void longestCommonSubsequence() {
        String text1 = "abcde";
        String text2 = "ace";

        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[M][N]);
    }

    @Test
    public void evalRPN() {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        System.out.println(stack.pop());
    }
    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

    @Test
    public void str() {
        String ps = "$ab$$sh$$$gggg";
        if (ps == null) {
            System.out.println(0);
            return;
        }
        Deque<Character> stack = new LinkedList<>();
        char[] chars = ps.toCharArray();
        int length = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stack.push(chars[i]);
        }
        boolean is = false;
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            if (pop != '$' && !is) {
                sb.append(pop);
            }
            if (pop == '$') {
                is = true;
            }
        }
        System.out.println(sb.length());
    }


}
