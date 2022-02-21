#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int X, n;
    stack<int> s;
    cin >> X;
    string op;
    while(X--){
        cin >> op;
        if(op=="push"){
            cin >> n;
            s.push(n);
        }
        else if(op=="pop"){
            if(s.empty()){
                cout << -1 <<'\n';
            }else {
                cout << s.top() <<'\n';
                s.pop();
            }
        }
        else if(op=="size"){
            cout << s.size()<<'\n';
        }
        else if(op=="empty"){
            cout << (int)s.empty() << '\n';
        }
        else if(op=="top"){
            if(s.empty()){
                cout << -1 <<'\n';
            }else {
                cout << s.top() <<'\n';
            }
        }
    }
}