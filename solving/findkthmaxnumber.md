[url](https://www.careercup.com/question?id=5663671083597824)
是采用二分查找的方法的优化。
如果查找完成的分组 左边 （大值端）的数量正好是k-1 ，那么此时的值就是需求的值
solving 很多时候可以直接用sort开始。

```
 class Solution {

    public int findKthLargest(int[] nums, int k) {
       if (k < 1 || nums == null)
		return 0;

	return getKth(nums.length - k +1, nums, 0, nums.length - 1);
}

public int getKth(int k, int[] nums, int start, int end)
{
	int pivot = nums[end];
	int left = start;
	int right = end;
	while (true)
	{
		while (nums[left] < pivot && left < right)
		left++;

		while (nums[right] >= pivot && right > left)
			right--;

		if (left == right)
			break;

		swap(nums, left, right);
	}

	swap(nums, left, end);
	if (k == left + 1)
		return pivot;
	else if (k < left + 1)
		return getKth(k, nums, start, left - 1);
	else
		return getKth(k, nums, left + 1, end);
}

public void swap(int[] nums, int n1, int n2)
{
	int tmp = nums[n1];
	nums[n1] = nums[n2];
	nums[n2] = tmp;
}
   
}
```
