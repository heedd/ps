#include <bits/stdc++.h>
using namespace std;

// 테이블 정의
int d[1000002];  // d[i] = i의 최소 연산 횟수 

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    // 초기값
    d[1] = 0;
    for(int i = 2; i <= n; i++){
        // 점화식
        // 세가지 방법 중 최소 찾기
        d[i] = d[i-1] + 1;  
        if(i%2 == 0) d[i] = min(d[i], d[i/2] + 1);
        if(i%3 == 0) d[i] = min(d[i], d[i/3] + 1);      
    }
    cout << d[n];
}