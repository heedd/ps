#include <bits/stdc++.h>
using namespace std;

int func(int n, int r, int c){
    // base condition
    if(n==0) return 0;
    
    // 재귀식
    int half = 1<<(n-1);
    if(r < half && c < half) return 0*half*half + func(n-1, r, c);
    if(r < half && c >= half) return 1*half*half + func(n-1, r, c-half);
    if(r >= half && c < half) return 2*half*half + func(n-1, r-half, c);
    return 3*half*half + func(n-1, r-half, c-half);
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int N, r, c;
    cin >> N >> r >> c;
    cout << func(N, r, c);
}