#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    //입력
    int a,b,c;
    cin >> a >> b >> c;
    
    //빈도수
    int t = a*b*c;
    int freq[10]={};
    while (t>0) {
        freq[t%10]++;
        t/=10;
     }    
    
    //출력
    for(int i=0; i<10; i++){
        cout << freq[i] << '\n';
    }
}