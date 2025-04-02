package algo.interview.b_linear.c_stack_queue;

import java.util.*;
public class ValidParentheses01 {

    public static void main(String[] args) {

        String input = "[]{})";
        System.out.println(validParentheses(input));

    }

    public static boolean validParentheses(String s) {

        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++ ) {
            if (!table.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || table.get(s.charAt(i)) != stack.pop()) {
//            } else if (table.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
