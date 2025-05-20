package algo.interview.z_leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class ReverseBits190 {

    public static void main(String[] args){

        // Test Case 1
//        int n = Integer.parseInt("00000010100101000001111010011100", 2);
        // [answer] 964176192

        // Test Case 2
         int n = Integer.parseUnsignedInt("11111111111111111111111111111101", 2); // -3
        int result = reverseBits(n);
        System.out.println(result);


    }

    public static int reverseBits(int n) {

        String binStr = String.format("%32s", Integer.toBinaryString(n)).replace(" ", "0");

        String reversedBinStr = "";
        for (int i = 31; i >= 0; i--) {
            reversedBinStr += binStr.charAt(i);
        }

        Integer reversedInt = Integer.parseUnsignedInt(reversedBinStr, 2);
        return reversedInt;
    }

}
