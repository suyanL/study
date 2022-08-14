package com.ddup.mybatis.springbootmybatis.proxy.dy;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProxyTest {

    private static Long num = 0l;

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,2};

        System.out.println(trap(nums));

//        //关键之处，如果一直到末尾一直是连1的话，会导致result没有更新
//        System.out.println(result>count ? result:count);

//        //创建一个实例对象，这个对象是被代理的对象
//        Person zhangsan = new Student("张三");
//
//        //创建一个与代理对象相关联的InvocationHandler
//        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
//        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, new StuInvocationHandler<Person>(zhangsan));
//
//       //代理执行上交班费的方法
//        stuProxy.giveMoney();
    }

    public static int trap(int[] height) {
        int rain = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            int min = Math.min(max_left, max_right);
            if (min > height[i]) {
                rain = rain + (min - height[i]);
            }
        }
        return rain;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        //题目中要求最大长度是6000，我们就来个大点的值，来判断距离是否合法。
        final int FLAG = Integer.MAX_VALUE/2;
        //matrix二位数组用来记录两点之间的距离，用空间换时间
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(matrix[i],FLAG);
        }
        for(int i=0;i<times.length;i++){
            //start为起始点，end为终点，而matrix[start][end]的值则为从start到end的时长
            //由于数组是从0开始，所以而题目中的点是从1开始，所以题目中的1号点对应于数组中的0下标
            int start = times[i][0]-1,end = times[i][1]-1;
            matrix[start][end] = times[i][2];
        }
        //used数组用来判断该点是否以使用，即是否已经确定起点到该点的最短距离，并且可以将
        //该点作为过度点，计算到起点经过该点到其他点的距离
        boolean[] used = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist,FLAG);
        dist[k-1] = 0;
        for(int i=0;i<n;i++){
            int start = -1;
            for(int j=0;j<n;j++){
                //扫描一轮dist数组，将所有未被使用的点中距离题目所给起点距离最小的点作为临时起点（即可以通过该点过渡）
                if(!used[j]&&(start==-1||dist[start]>dist[j]))
                    start=j;
            }
            used[start] = true;
            for(int end=0;end<n;end++){
                //扫描一边dist数组，题目起点在经过临时起点过度到达其他所有点的距离如果比
                //没有通过临时起点过度的距离短，则可以更新该数组中对应的值
                dist[end]=Math.min(dist[end],dist[start]+matrix[start][end]);
            }
        }
        int res = Arrays.stream(dist).max().getAsInt();
        return res==FLAG?-1:res;
    }

    public String reverseWords(String s) {

        String[] split = s.split(" ");
        String contact="";
        int flag=0;
        int index=0;
        for (int i=split.length-1;i>=0;i--){
            if(!split[i].equals("")){
                contact=contact+split[index]+" ";
                index=i;
            }
            if(i==0){
                contact=contact+split[index];
            }

        }
        return contact;
    }

    //-----单词搜索
    public boolean exist(char[][] board, String word) {
        //DFS+剪枝
        char[] words=word.toCharArray();
        int n=board.length;
        int m=board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(board,words,i,j,0))
                    return true;
            }
        }
        return false;
    }
    private static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=word[k])
            return false;
        if(k==word.length-1)
            return true;
        //如果匹配的话
        board[i][j]='\0';
        boolean res=dfs(board,word,i+1,j,k+1)||dfs(board,word,i,j+1,k+1)
                ||dfs(board,word,i-1,j,k+1)||dfs(board,word,i,j-1,k+1);
        //开始回溯的时候恢复原样
        board[i][j]=word[k];
        return res;
    }
    //-----最大数
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numbers, (o1, o2) -> {
            StringBuilder s1 = new StringBuilder(o1);
            StringBuilder s2 = new StringBuilder(o2);
            return -s1.append(o2).toString().compareTo(s2.append(o1).toString());
        });
        if (numbers[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            result.append(number);
        }
        return result.toString();
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = Math.abs(ax2-ax1)*Math.abs(ay2-ay1);
        int b = Math.abs(bx2-bx1)*Math.abs(by2-by1);
        int sum = a+b;
        int l = 0;int m = 0;
        if(bx1 < ax2 && bx2 > ax1){
            if(bx1 >= ax1){
                if(bx2 < ax2){
                    l = Math.abs(bx2-bx1);
                }else{
                    l = Math.abs(ax2-bx1);
                }
            }else{
                if(bx2 < ax2){
                    l = Math.abs(bx2-ax1);
                }else{
                    l = Math.abs(ax2-ax1);
                }
            }
        }
        if(by1 < ay2 && by2 > ay1){
            if(by1 >= ay1){
                if(by2 < ay2){
                    m = Math.abs(by2-by1);
                }else{
                    m = Math.abs(ay2-by1);
                }
            }else{
                if(by2 < ay2){
                    m = Math.abs(by2-ay1);
                }else{
                    m = Math.abs(ay2-ay1);
                }
            }
        }
        return sum-l*m;
    }
}