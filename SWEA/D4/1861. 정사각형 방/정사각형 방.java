import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int[][] grid;                //맵
    static int[][] maxDist;         //그 좌표까지 거쳐온 최대거리
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static int sy;
    static int sx;
    static int max;
    static int n;
     
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            //1. 입력
            n = Integer.parseInt(bf.readLine());
            grid = new int[n][n];
            maxDist = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    maxDist[i][j] = Integer.MIN_VALUE;
                }
            }
             
            //2. DFS
            sy = 0; sx = 0;
            max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(i, j, 1, i, j);
                }
                                 
            }
 
            //3. 출력
            System.out.printf("#%d %d %d%n", tc, grid[sy][sx], max);
        }// end of tc
    }
     
    private static void dfs(int curY, int curX, int dist, int startY, int startX) { //sy, sx??
 
        if(maxDist[curY][curX] >dist) return;
        maxDist[curY][curX] = dist;
         
 
         
        if(dist > max) {
            sy = startY;
            sx = startX;
            max = dist;
        }
        if(dist == max) {
            if(grid[sy][sx]>grid[startY][startX]) {
                sy = startY;
                sx = startX;
            }
        }
         
        // 인접 노드 탐색
        for (int d = 0; d < dy.length; d++) {
            int ny = curY + dy[d];
            int nx = curX + dx[d];
                                                                //더 나아갈 수 없는 경우
            if (ny < 0 || nx < 0 || ny >= n || nx >= n  //경계밖이면
                || grid[ny][nx] != grid[curY][curX]+1           //현재+1이 아니면
                || maxDist[ny][nx]>= dist+1) {                   //여기까지 더 멀리서 올 수 있다면
                continue;
            }
            maxDist[ny][nx] = dist+1;
            dfs(ny, nx, dist+1, startY, startX);
             
                 
        }
    }
 
}