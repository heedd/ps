#include <bits/stdc++.h>
using namespace std;

// 뒤집기 함수
void func(string &a){
    string b = "";
    
    for(int i=0; i<a.size(); i++){
        if(a[a.size() - i -1] == '0' && b.size() == 0) continue;
        b = b + a[a.size() - i -1];
    }
    
    a = b;
}

// 정렬 비교함수
bool cmp(const string &a, const string &b) {
    return stol(a) < stol(b);
}


int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    // 입력
    string arr[n];
    for(int i=0; i<n; i++) cin >> arr[i];
    
    // 뒤집기 & 정렬
    for(int i=0; i<n; i++) func(arr[i]);
    sort(arr, arr+n, cmp);
    
    // 출력
    for(int i=0; i<n; i++) cout << arr[i] << '\n';
    

 }