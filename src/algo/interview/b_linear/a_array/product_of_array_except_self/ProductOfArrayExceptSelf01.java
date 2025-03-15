package algo.interview.b_linear.a_array.product_of_array_except_self;

import java.util.*;
public class ProductOfArrayExceptSelf01 {
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7};
        int[] result = new int[nums.length];

        // 왼쪽 곱셈
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        System.out.println(" ================== nums ================== ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println(" \n ============================================== ");

        System.out.println(" ================== result ================== ");
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println(" \n ============================================== ");

        // 오른쪽 곱셈, 왼쪽 곱셈 결과에 차례대로 곱하기
        p = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            result[i] *= p;
            p *= nums[i];
        }

        System.out.println(" ================== result ================== ");
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println(" \n ============================================== ");

    }
}
