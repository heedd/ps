#include <bits/stdc++.h>
using namespace std;

int arr[26];
int brr[26];

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    while(n--){
        fill(arr, arr+26, 0);
        fill(brr, brr+26, 0);
        
        string str1, str2;
        cin >> str1 >> str2;
        for(auto c : str1){
            arr[c - 'a']++;
        }
        for(auto c : str2){
            brr[c - 'a']++;
        }
        bool isValid = true;
        for(int i = 0; i < 26; i++) {
            if(arr[i] != brr[i] ) {
                isValid = false;
                break;
            }
        }
        if(isValid) cout << "Possible" << '\n';
        else cout << "Impossible" << '\n';
    }
}