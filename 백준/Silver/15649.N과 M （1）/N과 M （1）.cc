#include <bits/stdc++.h>
using namespace std;

int n,m;   // n 중 m 택하기
int arr[10];   // 1~n
bool isused[10]; // 1:used, 0:unused

// 현재 k개 수를 택했음.
void func(int k){
  // base condition
  // m개를 모두 택했으면 arr 전체 출력
  if(k == m){
    for(int i = 0; i < m; i++)
      cout << arr[i] << ' ';
    cout << '\n';
    return;
  }

  //재귀식
  // 1~n 중 unused에 대해
  for(int i = 1; i <= n; i++){ 
    if(!isused[i]){
      arr[k] = i;     // k+1번째 수를 i로 정하고
      isused[i] = 1;  // i를 사용되었다고 표시
      func(k+1); // 다음 수를 정하러 한 단계 더 들어감
      isused[i] = 0; // k+1번째 수가 i인 모든 경우에 대해 다 확인했으니, 백트래킹하게 i를 다시 unused로 바꾸기
    }
  }
}

int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
    
  cin >> n >> m;
  func(0);
}