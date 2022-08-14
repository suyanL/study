//package com.ddup.mybatis.springbootmybatis;
//
//import java.util.Scanner;
//
//public class Solution {
//    public int calculate(String s) {
//        return 0；
//    }
//
//    /*
//    请一个在字符串中找出连续最长的数字串，并把这个串的长度返回；如果存在长度相同的连续数字串，返回最后一个连续数字串；
//     */
//
//    /*
//    输入n个数组，每次取出k项添加到空数组，最后打印这个数组
//     */
//    public int[] poll_k_items( int[][] a, int k) {
//        //记录a的元素个数
//        int len = 0;
//        for (int i = 0; i < a.length; i++) {
//            len += a[i].length;
//        }
//        int[] array = new int[len];
//        int n = 0;
//        //开始取元素
//        //i指行，j指列
//        int times = 1;
//        while (true){
//            for (int i = 0; i < a.length; i++) {
//
//                int k_1 = 0;
//                if (times * k >= a[i].length) {
//                    k_1 = a[i].length - (times - 1) * k;
//                } else {
//                    k_1 = k;
//                }
//
//                for (int j = 0; j < k_1; j++) {
//                    array[n] = a[i][(times - 1) * k + j];
//                    n++;
//                    if (n == len) {
//                        return array;
//                    }
//                }
//
//            }
//            times++;
//        }
//    }
//
//    /*
//    写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入输入字符串中含有该字符的个数。不区分大小写
//     */
//    public void demo(){
//        Scanner sc = new Scanner(System.in);
//        String strs = sc.nextLine();
//        //将输入的字符串转成char型便于比较
//        char ch1 = sc.nextLine().charAt(0);
//        int count = 0;
//        char[] arrs = strs.toCharArray();
//        for(char ch : arrs){
//            //char类型没有忽略大小写比较，但是可以直接将都转成大写或者小写比较
//            if(Character.toUpperCase(ch) == Character.toUpperCase(ch1)){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//
//}