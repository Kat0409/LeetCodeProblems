class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        
        int row = dimension.get(0)-1;
        int col = dimension.get(1)-1;
      
        int start = 0; 
        int end = col; 
        int counter = 0;
        int res = -1;
        while(start<=end ){
           
           int mid = (start+end)/2;
           int akt = binaryMatrix.get(counter, mid); 
        
          if(akt == 1){
              
              res = (res==-1) ? mid : Math.min(mid,res);
              counter = 0;
              end = mid-1; 
          }else{
              
              if(counter <row){
                  counter++;
              }else{
                  counter = 0;
                  start = mid+1;
              }                
          }
        }
       
        return res; 
        
    }
}
