package algo.boj.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RuleOfLargeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        String[] numbers = sc.nextLine().split(" ");
        ArrayList list = new ArrayList();
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }

        System.out.println("LIST : " + list);

        Collections.sort(list);
        int first = (int) list.get(n - 1);
        int second = (int) list.get(n - 2);

        int result = 0;
        while(true) {
            for (int i = 0; i < k ; i++) {

                if (m == 0) { break; }
                result += first;
                m -= 1;
            }
            if (m == 0) { break; }
            result += second;
            m -= 1;
        }
        System.out.println(result);

    }

}
