#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int q;
    if(!(cin>>q)) return 0;
    vector<int> val, mx;
    while(q--){
        string cmd;
        cin>>cmd;
        if(cmd=="push"){
            int v; cin>>v;
            val.push_back(v);
            if(mx.empty()) mx.push_back(v); else mx.push_back(max(mx.back(),v));
        } else if(cmd=="pop"){
            if(!val.empty()){ val.pop_back(); mx.pop_back(); }
        } else if(cmd=="max"){
            if(!mx.empty()) cout<<mx.back()<<"\n";
        }
    }
    return 0;
}
