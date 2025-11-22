#include <bits/stdc++.h>
using namespace std;

vector<int> parent, rnk;
vector<long long> sz;
long long maxSize;

int find_set(int v){
    if(v == parent[v]) return v;
    return parent[v] = find_set(parent[v]);
}

void union_set(int a, int b){
    a = find_set(a);
    b = find_set(b);
    if(a != b){
        if(rnk[a] < rnk[b]) swap(a,b);
        parent[b] = a;
        sz[a] += sz[b];
        sz[b] = 0;
        if(rnk[a] == rnk[b]) rnk[a]++;
        maxSize = max(maxSize, sz[a]);
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    parent.resize(n+1);
    rnk.assign(n+1, 0);
    sz.resize(n+1);

    maxSize = 0;
    for(int i=1;i<=n;i++){
        cin >> sz[i];
        parent[i] = i;
        maxSize = max(maxSize, sz[i]);
    }

    while(m--){
        int d,s;
        cin >> d >> s;
        union_set(d, s);
        cout << maxSize << "\n";
    }
}
