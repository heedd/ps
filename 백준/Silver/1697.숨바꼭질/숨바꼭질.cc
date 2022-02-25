#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int dist[100002];
int n,k;  // 수빈(n), 동생(k)

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> k;
    fill(dist, dist+100001,-1);
    
    // 수빈 시작점
    dist[n] = 0;
    queue<int> Q;
    Q.push(n);
    
    while(dist[k] == -1){  // 동생 만날 때까지
        int cur = Q.front(); 
        Q.pop();
        
        for(int nxt : {cur-1, cur+1, 2*cur}){
            if(nxt < 0 || nxt > 100000) continue;  //범위 체크
            if(dist[nxt] != -1) continue;          //지나갈 필요 있는지 체크
            
            dist[nxt] = dist[cur]+1;
            Q.push(nxt);
        }        
    }
    cout << dist[k];
}