#include <bits/stdc++.h>
using namespace std;

// 함수의 정의 : 원판 n개를 a기둥에서 b기둥으로 옮기는 방법 출력.
void func(int a, int b, int n){
    // base condition
    if(n == 1) {
        cout << a << ' ' << b << '\n';
        return;
    }
    
    // 재귀식
    func(a, 6-a-b, n-1);    // n-1개 원판을 a -> (6-a-b)로 이동
    cout << a << ' ' << b << '\n';   // n번 원판을 a -> b로 이동
    func(6-a-b, b, n-1);    // n-1개 원판을 (6-a-b) -> b로 이동
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int k;
    cin >> k;

    cout <<  (1<<k) - 1 << '\n'; // 총 옮긴 횟수
    //cout <<  (int)pow(2, k) -1 << '\n'; // 총 옮긴 횟수
    
    func(1, 3, k);  // 과정 출력하는 재귀 함수
}
