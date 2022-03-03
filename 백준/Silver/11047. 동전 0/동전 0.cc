#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n, k;
    cin >> n >> k;
    int arr[n];
    for(int i=0; i<n; i++) cin >> arr[i];
    
    // 큰 동전부터 개수 세어나가기
    int ans = 0;
    for(int i=n-1; i>=0; i--) {
        ans += k / arr[i];
        k = k % arr[i];
    }
    cout << ans;
}