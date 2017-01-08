

同把皇后，这里不做赘述


```java
   public class Solution {

    private List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        Map<Integer, Boolean> placed = new HashMap<>();
        int[] record = new int [nums.length];
        placeNumb(placed, 0, nums, record);
        return results;
    }
    
    private void placeNumb (Map<Integer, Boolean> placed, int step, int[] nums, int[] record){
        if(step == nums.length){
            results.add(cout(record));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(placed.get(nums[i]) == null || placed.get(nums[i]) == false){
                record[step] = nums[i];
                placed.put(nums[i], true);
                placeNumb(placed, step+1, nums, record);
                placed.put(nums[i], false);
            }
        }
        
    }
    
    private List<Integer> cout(int [] datas){
       List<Integer> list= new ArrayList<>();
       for(int i = 0 ; i < datas.length ; i ++){
            list.add(datas[i]);
       }
       return list;
    }
    

        
    
    
}
```
