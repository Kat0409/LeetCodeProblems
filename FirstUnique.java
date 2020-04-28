/*
You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
void add(int value) insert value to the queue.
*/

class FirstUnique {
    public LinkedHashMap<Integer,Integer> lm; 

    public FirstUnique(int[] nums) {
        this.lm = new LinkedHashMap<Integer, Integer>(); 
        for(int i : nums){
            if(lm.isEmpty()||!lm.containsKey(i)){
                lm.put(i,1);
            }else{
                lm.replace(i, lm.get(i)+1);
            }
        }
    }
    
    public int showFirstUnique() {
        for(Integer key : lm.keySet()){
            if(lm.get(key)==1){
                return key;
            }
        }
        return -1; 
    }
    
    public void add(int value){
       if(lm.containsKey(value)){
           lm.replace(value, lm.get(value)+1);
       }else{
           lm.put(value,1);
       }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
