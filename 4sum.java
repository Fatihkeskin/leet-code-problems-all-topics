class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums.length < 4) 
            return result;
        
        Arrays.sort(nums);
        

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int leftPointer = j+1;
                int rightPointer = nums.length -1;
                while (leftPointer < rightPointer) {
                    if (nums[i] + nums[j] + nums[leftPointer] + nums[rightPointer] == target) {
                        List<Integer> results = new ArrayList<>();
                        results.add(nums[i]);
                        results.add(nums[j]);
                        results.add(nums[leftPointer]);
                        results.add(nums[rightPointer]);
                        result.add(results);
                        leftPointer++;
                        
                        while (leftPointer < rightPointer && nums[leftPointer] == results.get(2)) ++leftPointer;
                
                    
                        while (leftPointer < rightPointer && nums[rightPointer] == results.get(3)) --rightPointer;
                    } else if (nums[i] + nums[j] + nums[leftPointer] + nums[rightPointer] < target) {
                        leftPointer++;
                    } else {
                        rightPointer--;
                    }
                    while(j + 1 < nums.length && nums[j + 1] == nums[j]) ++j;
                }              
            }
             while (i + 1 < nums.length && nums[i + 1] == nums[i]) ++i;
        }    
        
        return result;
    }
}