#include <bits/stdc++.h>
using namespace std;

int n, s;
int arr[22];
int cnt = 0;

// cur번째 원소까지 가지 고려해놨음
void func(int cur, int tot){
  // base condition
  if(cur == n){
    if(tot == s) cnt++;
    return;
  }
   
  // 재귀식
  func(cur+1, tot);  // 수열에 원소 추가 안하기
  func(cur+1, tot+arr[cur]);  // 수열에 cur+1번째 원소 추가하기
}

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
    
  cin >> n >> s;
  for(int i = 0; i < n; i++) cin >> arr[i];
  
  func(0, 0);
    
  if(s == 0) cnt--;  // 공집합 제외하기 위해
  cout << cnt;
}