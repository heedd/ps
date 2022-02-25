// BFS : (4)시작점이 두 종류일 때

#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int r, c;
string board[1002];
int distF[1002][1002]; // 불의 전파 시간
int distJ[1002][1002]; // 지훈이의 이동 시간

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> r >> c;
    for(int i = 0; i < r; i++){
        fill(distF[i], distF[i]+c, -1);
        fill(distJ[i], distJ[i]+c, -1);    
    }
    
    for(int i = 0; i < r; i++) cin >> board[i];
    
    queue<pair<int,int> > QF;
    queue<pair<int,int> > QJ;
    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            if(board[i][j] == 'F'){
                QF.push({i,j});
                distF[i][j] = 0;        
              }
          if(board[i][j] == 'J'){
                QJ.push({i,j});
                distJ[i][j] = 0;
              }
        }
     }
    
    // 불에 대한 BFS
    while(!QF.empty()){
        pair<int,int> cur = QF.front(); QF.pop();
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
            if(distF[nx][ny] >= 0 || board[nx][ny] == '#') continue; 
            distF[nx][ny] = distF[cur.X][cur.Y]+1;
            QF.push({nx,ny});  // (곧 익을)익지않은 토마토 큐에 추가
        }
    }
    
    // 지훈이에 대한 BFS
    while(!QJ.empty()){
        pair<int,int> cur = QJ.front(); QJ.pop();
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c){ // 범위를 벗어났다는 것은 탈출에 성공했다는 의미. 큐에 거리 순으로 들어가므로 최초에 탈출한 시간을 출력하면 됨.
                cout << distJ[cur.X][cur.Y]+1; 
                return 0;
              }
        if(distJ[nx][ny] >= 0 || board[nx][ny] == '#') continue;
        if(distF[nx][ny] != -1 && distF[nx][ny] <= distJ[cur.X][cur.Y]+1) continue; // 불의 전파 시간을 조건에 추가
        distJ[nx][ny] = distJ[cur.X][cur.Y]+1;
        QJ.push({nx,ny});
        }
    }
    cout << "IMPOSSIBLE"; // 여기에 도달했다는 것은 탈출에 실패했음을 의미.
}