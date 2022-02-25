#include <bits/stdc++.h>
using namespace std;

using ll = long long;

ll POW(ll a, ll b, ll c){
    if(b==1) return a%c;  // base condition 수렴
    
    ll val = POW(a, b/2, c);
    val = val*val % c;
    
    if(b%2 == 0) return val;
    else if(b%2 == 1) return val*a % c;
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    ll a, b, c;
    cin >> a >> b >> c;
    
    cout << POW(a, b, c);
}