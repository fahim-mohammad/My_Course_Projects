#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    if(!(cin>>n)) return 0;
    vector<int> a(n);
    for(int i=0;i<n;i++) cin>>a[i];
    int m; cin>>m;
    deque<int> dq;
    vector<int> res;
    for(int i=0;i<n;i++){
        while(!dq.empty() && dq.front()<=i-m) dq.pop_front();
        while(!dq.empty() && a[dq.back()]<=a[i]) dq.pop_back();
        dq.push_back(i);
        if(i>=m-1) res.push_back(a[dq.front()]);
    }
    for(size_t i=0;i<res.size();++i){
        if(i) cout<<" ";
        cout<<res[i];
    }
    cout<<"\n";
    return 0;
}
