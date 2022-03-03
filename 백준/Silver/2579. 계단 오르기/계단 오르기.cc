#include <bits/stdc++.h>
using namespace std;

// 함수 정의
int arr[302];  // arr[i] = i번쨰 계단까지 최대 점수

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    int str[n];
    for(int i=1; i<=n; i++) cin >> str[i];
    
    arr[1] = str[1];
    arr[2] = str[1] + str[2];
    arr[3] = max(str[1] + str[3], str[2] + str[3]);
    for(int i=4; i<=n; i++) {
        arr[i] = max(str[i] + arr[i-2], str[i] + str[i-1] + arr[i-3]);
    }
    
    cout << arr[n];
}