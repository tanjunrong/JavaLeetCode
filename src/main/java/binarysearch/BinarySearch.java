package binarysearch;

/**
 * @author t30010543
 * 先给出示例升序数组如下
 * value:|0|1|2|3|3|3|4|5|6|7|
 * index:|0|1|2|3|4|5|6|7|8|9|
 * 二分查找找的下标值无非是四种情况:
 * 1.查找2下标,即小于指定值value=3的最大下标值,<value的上界
 * 2.查找3下标,即大于等于指定值value=3的最小下标值,>=value的下界
 * 3.查找5下标,即小于等于指定值value=3的最大下标值,<=value的上界
 * 4.查找6下标,即大于指定值value=3的最小下标值,>value的下界
 * java.util.Arrays.binarySearch()只能应对数组值唯一的情况
 */
public class BinarySearch {
    /**
     * 最普通的二分查找，采用左闭右开的策略，即[l, r),相当于java.util.Arrays.binarySearch()
     *
     * @param nums 待排序数组
     * @param target 目标值
     * @return 目标值在待排序数组下标，若不存在则返回-1
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找下界的二分查找,采用左闭右开的策略,即[l, r).
     * @param nums 待排序数组
     * @param target 目标值
     * @return 目标值在待排序数组下标，若不存在则返回-1
     */
    public int searchLower(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            // 这个地方限制是查<value还是<=value的下界
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 此时l==r
        return l;
    }
    /**
     * 查找上界的二分查找,采用左闭右开的策略,即[l, r).
     * <value的下界为>=value的上界下标值-1;<=value的下界为>value的上界下标值-1
     * @param nums 待排序数组
     * @param target 目标值
     * @return 目标值在待排序数组下标，若不存在则返回-1
     */
    public int searchHigher(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            // 这个地方限制是查<value还是<=value的下界
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 此时l==r,查上界需要对应下界下标-1
        return l - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9};
        for (int num : nums) {
            System.out.println(num + "|" + new BinarySearch().searchLower(nums, num));
        }
        // System.out.println(((1 << 30) + (-1 << 31)) / 2);
        // System.out.println(((-1)) >>> 1);
        // System.out.println("jlkad"+'\''+"sd");
    }
}
