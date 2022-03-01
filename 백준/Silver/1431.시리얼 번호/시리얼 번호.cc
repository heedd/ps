#include <bits/stdc++.h>
using namespace std;

int n;
string tmp;
vector<string> arr;

bool cmp(const string &a, const string &b){ 
    // 1번
    if(a.size() != b.size()) return a.size() < b.size();
    
    // 2번
    
    int asum = 0;
    int bsum = 0;
        
    for(int i=0; i<a.size(); i++){
        if(isdigit(a[i])) asum += (a[i] - '0');
        if(isdigit(b[i])) bsum += (b[i] - '0');
    }
    if(asum != bsum) return asum < bsum;
    
    
    // 3번
    return a < b;
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    //입력
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> tmp;
        arr.push_back(tmp);
    }
    
    // 정렬
    sort(arr.begin(), arr.end(), cmp);
    
    // 출력
    for(auto i : arr) cout << i << '\n';
    // for(int i=0; i<n; i++) cout << arr[i] << '\n';
}