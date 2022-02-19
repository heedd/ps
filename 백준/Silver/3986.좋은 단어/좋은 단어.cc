#include <bits/stdc++.h>
using namespace std;

int n, gw = 0;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    while(n--){
        string a;
        cin >> a;
        stack<char> s;
        char tmp;
        for(auto c : a){
            if (!s.empty() && s.top() == c) s.pop();
            else s.push(c);
        }
        if (s.empty()) gw++;
    }
    cout << gw;
    
}