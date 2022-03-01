#include <bits/stdc++.h>
using namespace std;

bool cmp(const string &a, const string &b){
    if(a.size() != b.size()) return a.size() < b.size();
    return a < b;
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    // 입력
    string arr[n];
    for(int i=0; i<n; i++) cin >> arr[i];
    
    // 정렬
    sort(arr, arr+n, cmp);
    
    // 출력
    for(int i=0; i<n; i++) {
        if(i == 0 || arr[i] != arr[i-1]) cout << arr[i] << '\n';
    }
 }