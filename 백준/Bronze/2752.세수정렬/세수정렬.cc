#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c; // 입력
    cin >> a >> b >> c;
    int d, e, f; // 크기 순으로 출력할 세 수
    d = min({a,b,c}); //가장 작은수
    f = max({a,b,c}); //가장 큰수
    e = (a+b+c)-d-f;  // 가운데 수
    cout << d << ' ' << e << ' ' << f;
}