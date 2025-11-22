#include <bits/stdc++.h>
using namespace std;

vector<pair<int,int>> swaps;
vector<long long> a;
int n;

void sift_down(int i){
    int minIndex = i;
    int l = 2*i+1;
    if(l < n && a[l] < a[minIndex]) minIndex = l;
    int r = 2*i+2;
    if(r < n && a[r] < a[minIndex]) minIndex = r;
    if(i != minIndex){
        swaps.push_back({i,minIndex});
        swap(a[i], a[minIndex]);
        sift_down(minIndex);
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    a.resize(n);
    for(int i=0;i<n;i++) cin >> a[i];
    for(int i=n/2-1;i>=0;i--) sift_down(i);
    cout << swaps.size() << "\n";
    for(auto &p: swaps) cout << p.first << " " << p.second << "\n";
}
