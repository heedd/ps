#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second // pair에서 first, second를 줄여서 쓰기 위해서 사용 (t.X, t.Y)

int board[502][502]; // 1이 그림을 의미
bool vis[502][502]; // 1이 방문했음을 의미
int n, m; // n = 행의 수, m = 열의 수

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
  
    cin >> n >> m;
    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
            cin >> board[i][j];

    int mx = 0;  // 그림의 최댓값 -> 넓이 = 큐에서 pop 몇번?
    int num = 0;  // 그림의 수 -> 시작점 몇개?
    
    // 시작점 개수 찾기
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(board[i][j]==0 || vis[i][j]) continue;
            num++;
            queue<pair<int,int> > Q;
            vis[i][j] = 1; // (0, 0)을 방문했다고 명시
            Q.push({i,j}); // 큐에 시작점인 (0, 0)을 삽입.
            
            // (i, j)를 시작점으로 하는 그림 넓이 찾기
            int area=0;
            while(!Q.empty()){
                area++;
                pair<int,int> cur = Q.front(); Q.pop();
    
                for(int dir = 0; dir < 4; dir++){ // cur의 상하좌우 칸을 살펴보기. 
                  int nx = cur.X + dx[dir];
                  int ny = cur.Y + dy[dir]; 
      
                  if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue; 
                  if(vis[nx][ny] || board[nx][ny] != 1) continue; 
              
                  vis[nx][ny] = 1; // (nx, ny)를 방문했다고 명시
                  Q.push({nx,ny});
                }
            }
            mx = max(mx, area);
        }
    }
    cout << num << '\n' << mx;
}