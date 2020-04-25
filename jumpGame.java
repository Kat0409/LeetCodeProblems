/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.*/

class jumpGame {
    // only mathematical solution works for test cases
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        // start with last Index and show if the one in front of it can be new end
        int ende = nums.length-1; 
        for(int dav = nums.length-2; dav>=0; dav--){
            if(nums[dav]>=(ende-dav)){
                ende = dav; 
                if(dav==0){
                    return true; 
                }
            }  
        }
          return false; 
     }
}
    
    
    
    // backtracking solution is to slow for 2 tastcases
    private boolean helper(int [] nums, int aktuelleStelle, int ende){
        
        if(aktuelleStelle == ende){
            return true;
        }if(aktuelleStelle>ende  ||  nums[aktuelleStelle]==0){
            return false;
        }
        int i = nums[aktuelleStelle];
        while (i>0){
            if(helper(nums, aktuelleStelle+i, ende)){
                return true;
                
            }
            i--;
          }
        return false; 
    }
