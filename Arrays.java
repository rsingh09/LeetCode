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
		k = k % len;
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			res[(i + k) % len] = nums[i];
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
		for (int i = 0; i < nums.length; i++) {
			if (val.contains(nums[i]))
				val.remove(nums[i]);
			else
				val.add(nums[i]);
		}
		return val.iterator().next();
	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> vals = new HashSet<Integer>();
		for (int i : nums) {
			if (vals.contains(i))
				return true;
			vals.add(i);
		}
		return false;
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		int count = 0;
		HashMap<Integer, Integer> vals = new HashMap<Integer, Integer>();
		for (int i : nums1)
			vals.put(i, vals.getOrDefault(i, 0) + 1);
		for (int i : nums2) {
			if (vals.containsKey(i)) {
				result[count] = i;
				count++;
				int cnt = vals.get(i);
				if (cnt == 0)
					vals.put(i, cnt - 1);
			}
		}
		return result;
	}

	public int[] plusOne(int[] digits) {
		int len = digits.length - 1;
		for (int i = len; i > -1; i--) {
			if (digits[i] == 9)
				digits[i] = 0;
			else {
				digits[i] += 1;
				return digits;
			}
		}
		digits = new int[len + 2];
		digits[0] = 1;
		return digits;
	}

	public void moveZeroes(int[] nums) {
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[j] != 0) {
				nums[i++] = nums[j];
			}

			j++;
		}
		while (i < nums.length) {
			nums[i++] = 0;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3 = null;
		ListNode temp = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = 0;
			int a = 0, b = 0;
			if (l1 != null) {
				a = l1.val;
				// System.out.println("Val A: " + a);
				l1 = l1.next;
			}
			if (l2 != null) {
				b = l2.val;
				// System.out.println("Val B: " + b);
				l2 = l2.next;
			}
			sum = a + b + carry;
			carry = sum > 9 ? 1 : 0;
			sum = sum % 10;
			if (temp == null)
				temp = new ListNode(sum);
			if (l3 == null) {
				l3 = temp;
			} else {
				temp.next = new ListNode(sum);
				temp = temp.next;
				temp.next = null;
			}
		}
		if (carry != 0) {
			temp.next = new ListNode(carry);
			temp = temp.next;
			temp.next = null;
		}
		return l3;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
