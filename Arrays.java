import java.util.*;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] nums) {
		int j = 0;

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[j] != nums[i]) {
				j++;
				nums[j] = nums[i];
			}
		}
		return j + 1;
	}

	public int maxProfit(int[] prices) {
		int profit = 0;
		int buy = prices[0];
		int len = prices.length - 1;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i - 1] < prices[i]) {
				continue;
			}
			profit += prices[i - 1] - buy;
			buy = prices[i];
		}
		if (buy < prices[len])
			profit += prices[len] - buy;
		return profit;
	}

	public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int[] res = new int[len];
		for (int i = 0; i < len; i++) {
            res[(i+k)%len] = nums[i];
		}
		System.arraycopy(res, 0, nums, 0, len);
//		
//		int count = 0;
//		for (int i = 0; count < len; i++) {
//			int startIndex = i, currentIndex = (i + k) % k;
//			int prevVal = nums[startIndex];
//			while (startIndex != currentIndex) {
//				int temp = nums[currentIndex];
//				nums[currentIndex] = prevVal;
//				prevVal = temp;
//				currentIndex = (currentIndex + k) % k;
//			}
//		}
	}

	public int[] twoSum(int[] nums, int target) {
		int targetSum[] = new int[2];
		Map<Integer, Integer> twoSum = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int rem = target - nums[i];
			if (twoSum.containsKey(rem)) {
				targetSum[0] = twoSum.get(rem);
				targetSum[1] = i;
				return targetSum;
			}
			twoSum.put(nums[i], i);
		}
		return null;
	}
	
	public int singleNumber(int[] nums) {
		HashSet<Integer> val = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
        	if(val.contains(nums[i]))
        		val.remove(nums[i]);
        	else
        		val.add(nums[i]);
        }
        return val.iterator().next();
    }
}
