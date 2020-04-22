/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 */

class MaxNumberOfBal {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        //map String text to Hashmap 
        for(int i = 0; i < text.length(); i++){
            if(!map.containsKey(text.charAt(i))){
                map.put(text.charAt(i),1);
            }else{
                int z = map.get(text.charAt(i));
                map.put(text.charAt(i),z+1);
            }
        }
         // check if Hashmap contains all needed chars
         if(!map.containsKey('b') || !map.containsKey('a')|| !map.containsKey('l')||                  !map.containsKey('o')|| !map.containsKey('n')){
             return 0;
        }
         
        boolean anotherBallon = true;
        int res = 0;
        
        //check if there are enough chars and how many ballons can be created
        while(anotherBallon){
      
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                 char key = entry.getKey();
                 int count = entry.getValue();
            if(key=='b'|| key =='a' || key =='n'){
                if(count<1){
                    anotherBallon = false;
                    break;
                    
                }
                map.replace(key,count-1);
            }
            if(key =='l' || key == 'o'){
                if(count<2){
                    anotherBallon = false;
                }
                map.replace(key,count-2);
            }
            
        }if(anotherBallon){
        res++;
        }}
        return res; 
    }
}
