import java.util.*;

public class LeeCode {

    /**
     *    前提： 数组中一半奇数 一半偶数
     *    对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数
     * @param A 数组
     * @return  新数组
     */
    public static int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length ; i += 2)
            // 或者使用位运算 A[i]&1 != 0 ;
            if (A[i] % 2 == 1 ) {
                while (A[j] % 2 == 1 && j < A.length -1) {
                    j += 2;
                }
                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

        return A;

    }
    /**
     *  求两个数组的交集 使用Map存放一个数组，使用set存放一个数组
     *  在map中查找 若存在 则放到set中
     *  最后使用迭代器遍历将元素放置到数组中
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 两个数组的交集数组
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums1.length;i++){
            map.put(nums1[i],i);
        }
        for(int i = 0 ; i< nums2.length;i++){
            if(map.containsKey(nums2[i])){
                set.add(nums2[i]);
            }
        }
        int []res  = new int[set.size()];
        Iterator iterator = set.iterator();
        int k = 0;
        while(iterator.hasNext()){
            res[k++] = (int) iterator.next();
        }
        return res;
    }

    public static void main(String[] args) {
        int []arr1 = {1,2,3,4,5,6};
        int []arr2 = {1,3,4,4};
        System.out.println(Arrays.toString(LeeCode.intersection(arr1, arr2)));
        System.out.println(Arrays.toString(LeeCode.sortArrayByParityII(arr1)));
    }
}
