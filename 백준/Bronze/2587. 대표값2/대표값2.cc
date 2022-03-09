#include <bits/stdc++.h>
using namespace std;

int num[5], tot;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    // 입력
    for(int i = 0; i < 5; i++) cin >> num[i];
    
    // 평균
    for(int i = 0; i < 5; i++) tot += num[i];
    cout << tot / 5 << "\n";
    
    // 중앙값
    sort(num, num + 5);
    cout << num[2];
}