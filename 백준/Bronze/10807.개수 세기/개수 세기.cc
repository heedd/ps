#include <bits/stdc++.h>
using namespace std;

int N, v, t;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;
    
    int freq[201]={};
    for(int i=0; i<N; i++){
        cin >> t;
        freq[t+100]++;
    }
    
    cin >> v;
    
    cout << freq[v+100];
    
}