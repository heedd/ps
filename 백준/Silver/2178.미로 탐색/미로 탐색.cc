#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int n, m;
string board[102];
int dist[102][102];  // -1 : 안지나감

int main(void){
    string s;
    cin >> n >> m;
    
    for(int i=0; i<n; i++){
        cin >> board[i];
        fill(dist[i], dist[i] + m, -1);
    }
            
    queue<pair<int,int>> Q;
    dist[0][0] = 1;
    Q.push({0,0});
    
    while(!Q.empty()){
        auto cur = Q.front(); Q.pop();
        
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            
            if(nx<0 || ny <0 || nx>=n || ny>=m) continue; //좌표 범위 체크
            if(dist[nx][ny]>0 || board[nx][ny]=='0') continue;
            
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
            Q.push({nx,ny});
        }
    }
    
    cout << dist[n-1][m-1];
}