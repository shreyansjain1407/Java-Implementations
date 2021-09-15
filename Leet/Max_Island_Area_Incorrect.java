class Solution {
    int m=0,n=0, OutPut = 0;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int max = maxval(grid, i, j);
                    int ones = getones(grid, i, j);
                    grid[i][j] = max+ones;
                    OutPut = Math.max(OutPut, grid[i][j]);
                }
            }
        }
        
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n; j++){
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println(" ");
        }
        return OutPut;
    }
    
    int maxval(int[][] grid,int i,int j){
        int out = Math.max(Math.max(get(grid,i-1,j),get(grid, i,j-1)), Math.max(get(grid,i+1,j), get(grid,i,j+1)));
        return (out == 0)?1:out;
    }
    
    int getones(int[][] grid, int i, int j){
        int out = 0;
        if(get(grid,i-1,j) == 1)out++;
        if(get(grid, i,j-1) == 1)out++;
        if(get(grid,i+1,j) == 1)out++;
        if(get(grid,i,j+1) == 1)out++;
        return out;//(out != 0)?out:1;
    }
    
    int get(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=m || j>=n)return 0;
        return grid[i][j];
    }
}