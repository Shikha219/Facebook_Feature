class Solution {

  public static void DFS (boolean[][] friends, int n, boolean[] visited, int v) {
    for (int i = 0; i < n; ++i) {
        if (friends[v][i] == true && !visited[i] && i != v) {
            visited[i] = true;
            DFS(friends, n, visited, i);
        }
    }
  }

  public static int friendCircles(boolean[][] friends, int n) {
    if (n == 0) {
        return 0;
    }
 
    int numCircles = 0;  
    boolean visited[] = new boolean[n];

    for (int i=0;i < n; i++){
      visited[i] = false;
    }
    for (int i = 0; i < n; ++i) {
        if (!visited[i]) {
            visited[i] = true;
            DFS(friends, n, visited, i); 
            numCircles = numCircles + 1;
        }
    }
    
    return numCircles;
  }
  
  //Driver Code
  public static void main(String args[]) 
  { 
      int n = 4;
      boolean[][] friends = {
        {true,true,false,false},
        {true,true,true,false},
        {false,true,true,false},
        {false,false,false,true}
      };
     System.out.println("Number of friends circles: " + friendCircles(friends, n)); 
  } 

}
