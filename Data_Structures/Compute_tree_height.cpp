#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    if(!(cin>>n)) return 0;
    vector<int> parent(n);
    int root=-1;
    for(int i=0;i<n;i++){
        cin>>parent[i];
        if(parent[i]==-1) root=i;
    }
    vector<vector<int>> children(n);
    for(int i=0;i<n;i++) if(parent[i]!=-1) children[parent[i]].push_back(i);
    int height=0;
    if(root!=-1){
        queue<pair<int,int>> q;
        q.emplace(root,1);
        while(!q.empty()){
            auto [v,d]=q.front(); q.pop();
            height=max(height,d);
            for(int u:children[v]) q.emplace(u,d+1);
        }
    }
    cout<<height<<"\n";
    return 0;
}
