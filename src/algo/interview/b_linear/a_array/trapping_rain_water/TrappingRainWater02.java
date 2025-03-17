package algo.interview.b_linear.a_array.trapping_rain_water;

import java.util.*;
public class TrappingRainWater02 {

    public static void main(String[] args) {
        int[] height = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int totalVolume = trap(height);
        System.out.println(totalVolume);
    }

    // *천천히 생각해보기!*
    public static int trap(int[] height) {

        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            // 변곡점 만나는 경우
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // stack에서 꺼냄
                Integer top = stack.pop();

                if (stack.isEmpty()) break;

                // 스택의 마지막 위치까지를 거리로 계산
                int distance = i - stack.peek() - 1;
                // 현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];

                // 물이 쌓이는 양은 거리와 물 높이의 곱
                volume += distance * waters;
            }

            // 진행하면서 현재 위치를 스택에 삽입
            stack.push(i);
        }

        return volume;
    }

}
