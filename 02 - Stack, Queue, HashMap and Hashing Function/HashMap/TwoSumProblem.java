import java.util.HashMap;
public class TwoSumProblem {
    public static int[] findTwoSum(int[] num, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int complement = target - num[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(num[i], i);
        }
        return new int[] { -1, -1 };
    }
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(array, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
