/*A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [m, n], which means the matrix is m * n.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.*/


class LeftMostColumn {
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
