#include <bits/stdc++.h>
using namespace std;

int freq[26]; //전역 -> 배열 0으로 초기화
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
    
  string s;
  cin >> s;
    
  for(auto c : s) //range-based for loop
    freq[c-'a']++; //ascii 고려
  for(int i = 0; i < 26; i++)
    cout << freq[i] << ' ';
}