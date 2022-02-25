#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int max = 0;
    int loc = 0;
    for(int i=1; i<=9; i++){
        int num;
        cin >> num;
        
        if(max < num){
            max = num;
            loc = i;
        }
    }
    cout << max << '\n';
    cout << loc << '\n';
}