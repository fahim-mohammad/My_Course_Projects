#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int S,n;
    if(!(cin>>S>>n)) return 0;
    deque<long long> finish;
    for(int i=0;i<n;i++){
        long long a,t;
        cin>>a>>t;
        while(!finish.empty() && finish.front()<=a) finish.pop_front();
        if((int)finish.size()>=S){
            cout<<-1<<"\n";
        } else {
            long long start = finish.empty() ? a : max(a, finish.back());
            cout<<start<<"\n";
            finish.push_back(start + t);
        }
    }
    return 0;
}
