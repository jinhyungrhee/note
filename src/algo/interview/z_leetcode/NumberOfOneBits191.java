package algo.interview.z_leetcode;

public class NumberOfOneBits191 {
    public static void main(String[] args) {

        int n = 2147483645;
        System.out.println(hammingWeight(n));

    }

    public static int hammingWeight(int n) {

        String bin = "";
        while(n != 1) {
            bin += (n % 2);
            n /= 2;
        }
        bin += "1";

        int result = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') result++;
        }
        return result;
    }
}
