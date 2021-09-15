class Solution {
    public void solve(char[][] board) {
        //System.out.println(board.length);
        int m = board.length, n = board[0].length;
        char o = 'O';
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == o){
                    boolean flip = true;
                    try{
                        if(board[i-1][j] == o && ((i-1)==0||j==0)){
                            flip = false;
                            continue;
                        }
                    }catch(Exception e){}
                    try{
                        if(board[i][j-1] == o && (i==0||(j-1)==0)){
                            flip = false;
                            continue;
                        }
                    }catch(Exception e){}
                    try{
                        if(board[i+1][j] == o && ((i+1)==m-1||j==(n-1))){
                            flip = false;
                            continue;
                        }
                    }catch(Exception e){}
                    try{
                        if(board[i][j+1] == o && (i==m-1||(j+1)==(n-1))){
                            flip = false;
                            continue;
                        }
                    }catch(Exception e){}
                    
                    if(flip)board[i][j]="X";
                }
            }
        }
        
    }
}