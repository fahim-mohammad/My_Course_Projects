#include <bits/stdc++.h>
using namespace std;

struct Thread {
    long long finish;
    int id;
    bool operator>(const Thread& other) const {
        if(finish == other.finish) return id > other.id;
        return finish > other.finish;
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    priority_queue<Thread, vector<Thread>, greater<Thread>> pq;

    for(int i=0;i<n;i++) pq.push({0,i});

    for(int i=0;i<m;i++){
        long long t;
        cin >> t;
        Thread th = pq.top();
        pq.pop();
        cout << th.id << " " << th.finish << "\n";
        pq.push({th.finish + t, th.id});
    }
}
