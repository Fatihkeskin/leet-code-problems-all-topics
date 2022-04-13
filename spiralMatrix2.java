class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] result = new int[n][n];
        
        int x = 0;
        int y = 0;
        String[] direction = {"r", "d", "l", "u"};
        int directionCounter = 0;
        boolean lastX = false;
        boolean increment = false;
        for (int i = 1; i< n*n +1; i++) {            
            
            if (x > -1 && y > -1 && x < n && y < n && result[x][y] == 0) {
                result[x][y] = i;                
            } else {
                i-=1;
                directionCounter+=1;
                directionCounter = directionCounter%4;
                if (lastX && increment) {
                    x-=1;
                }  

                if (!lastX && increment) {
                    y-=1;
                    
                }  

                if (lastX && !increment) {
                    x+=1;
                    
                }  

                if (!lastX && !increment) {
                    y+=1;
                    
                } 
                
            }
            
            
            
            if (direction[directionCounter] == "r") {
                y+=1;
                lastX = false;
                increment = true;
            }  
            
            if (direction[directionCounter] == "d") {
                x+=1;
                lastX = true;
                increment = true;
            }  
            
            if (direction[directionCounter] == "l") {
                y-=1;
                lastX = false;
                increment = false;
            }  
            
            if (direction[directionCounter] == "u") {
                x-=1;
                lastX = true;
                increment = false;
            }  
            
        }
        
        return result;
    }
}