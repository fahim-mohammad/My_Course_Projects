#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    if(!(cin>>n)) return 0;
    if(n==0){ cout<<"CORRECT\n"; return 0; }
    vector<ll> key(n);
    vector<int> leftt(n), rightt(n);
    for(int i=0;i<n;i++) cin>>key[i]>>leftt[i]>>rightt[i];
    bool ok=true;
    stack<tuple<int,ll,ll>> st;
    st.emplace(0,LLONG_MIN,LLONG_MAX);
    while(!st.empty()){
        auto [v,lo,hi]=st.top(); st.pop();
        if(!(key[v]>=lo && key[v]<=hi)){ ok=false; break; }
        int r=rightt[v];
        int l=leftt[v];
        if(r!=-1) st.emplace(r,key[v],hi);
        if(l!=-1) st.emplace(l,lo,key[v]-1);
    }
    cout<<(ok?"CORRECT\n":"INCORRECT\n");
    return 0;
}
