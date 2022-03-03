#include <bits/stdc++.h>
using namespace std;

// 함수 정의
int arr[13];  // arr[i] = i를 나타내는 방법의 수

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    // 초기값
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    
    // 점화식
    for(int i=4; i<=11; i++)
        arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
    
    int t, n;
    cin >> t;
    for(int i=0; i<t; i++){
        cin >> n;
        cout << arr[n] << '\n';
    }
}