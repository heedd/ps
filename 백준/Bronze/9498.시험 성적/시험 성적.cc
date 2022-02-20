#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int s;
    cin >> s;
    
    if( 90 <= s ) cout << 'A';
    else if( 80 <= s ) cout << 'B';
    else if( 70 <= s ) cout << 'C';
    else if( 60 <= s ) cout << 'D';
    else cout << 'F';
}