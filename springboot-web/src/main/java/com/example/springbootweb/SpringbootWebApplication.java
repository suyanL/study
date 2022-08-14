package com.example.springbootweb;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootWebApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(SpringbootWebApplication.class, args);
//    }

//    public static void main(String[] args) {
//        String[] strings = {"dogcar","racecar","car"};
//        String s = longestCommonPrefix(strings);
//        System.out.println(s);
//    }
//
//    public static String longestCommonPrefix(String[] strs) {
//        String first = strs[0];
//        char[] chars = first.toCharArray();
//        String prefix = "";
//        for (int i = 0; i < chars.length; i++) {
//            List<String> collect = Arrays.asList(strs);
//            if (i>0 && i< chars.length-1) {
//                int finalI1 = i;
//                collect = Arrays.stream(strs)
//                        .map(m -> m.substring(finalI1))
//                        .collect(Collectors.toList());
//            }
//            int finalI2 = i;
//            long count = collect
//                    .stream()
//                    .filter(s -> s.startsWith(String.valueOf(chars[finalI2])))
//                    .count();
//
//            if (count == strs.length) {
//                prefix = prefix + chars[i];
//            }
//            break;
//        }
//
//        return prefix;
//    }

//
//    给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
//    返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
//    可以不考虑输出结果的顺序。
//
//
//    示例 1：
//
//    输入：nums1 = [1,2,2,1], nums2 = [2,2]
//    输出：[2,2]
//    示例 2:
//
//    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    输出：[4,9]

        public static List<Integer> intersect(Integer[] nums1, Integer[] nums2) {
            List<Integer> n1 = Arrays.asList(nums1);
            List<Integer> n2 = Arrays.asList(nums2);
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                boolean contains = n2.contains(nums1[i]);
                boolean contains1 = result.contains(nums1[i]);
                if (contains1) {
                    continue;
                }
                if (contains) {
                    int finalI = i;
                    long count1 = n1.stream().filter(f -> f.equals(n1.get(finalI))).count();
                    long count2 = n2.stream().filter(f -> f.equals(n1.get(finalI))).count();
                    if (count1<=count2) {
                        for (int j = 0; j < count1; j++) {
                            result.add(n1.get(i));
                        }
                    } else {
                        for (int j = 0; j < count2; j++) {
                            result.add(n1.get(i));
                        }
                    }

                }
            }
            return result;
        }

    public static void main(String[] args) {
        Integer[] nums1 = {1,2,2,1};
        Integer[] nums2 = {2,2};
        List<Integer> result = intersect(nums1, nums2);
        System.out.println(result);
    }

}
