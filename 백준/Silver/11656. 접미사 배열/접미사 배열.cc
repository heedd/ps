#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    // 입력
    string s;
    cin >> s;
    
    // 접미사 구하기
    string arr[s.size()];
    
    arr[0] = s[s.size()-1];
    for(int i=1; i<s.size(); i++)
        arr[i] = s[s.size() - i - 1] + arr[i-1];
    
    // 정렬
    sort(arr, arr+s.size());
    for(int i=0; i<s.size(); i++) cout << arr[i] << '\n';
    
}