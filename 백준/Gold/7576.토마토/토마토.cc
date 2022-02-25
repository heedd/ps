// BFS : (3)시작점이 여러 개일 때

#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int n, m;
int board[1002][1002];  // 익은(1), 익지않은(0), 빈칸(-1) 
int dist[1002][1002];   // 익지않은(-1), 빈칸or시작점(0), etc...

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    // 입력으로 board, dist 초기화
    cin >> m >> n;
    queue<pair<int,int>> Q;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> board[i][j];
            if(board[i][j] == 1)  // 익은 토마토 == 시작점 -> Q.push
                Q.push({i,j});
            if(board[i][j] == 0)  // 익지않은 토마토
                dist[i][j] = -1;  // 방문하지 않았음
        }
    }
    
    while(!Q.empty()){
        pair<int,int> cur = Q.front();
        Q.pop();
        
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            
            if(nx<0 || ny<0 || nx>=n || ny>=m) continue;  // 좌표 범위 확인
            if(dist[nx][ny] >= 0) continue;  // 익지않은 토마토만 큐에 넣자
            
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
            Q.push({nx,ny});  // (곧 익을)익지않은 토마토 큐에 추가
        }
    }
    int ans = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(dist[i][j] == -1){  //익지않은 토마토가 있다면 -1 출력
                cout << -1;
                return 0;
            }
            ans = max(ans, dist[i][j]);  //익는데 가장 오래 걸린 토마토 일수 출력
        }
    }
    cout << ans;
}