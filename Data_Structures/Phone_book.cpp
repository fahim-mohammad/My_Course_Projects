#include <bits/stdc++.h>
using namespace std;

struct Query {
    string type, name;
    long long number;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    unordered_map<long long,string> mp;
    mp.reserve(n*2);

    while(n--) {
        string t;
        cin >> t;
        if(t=="add") {
            long long num; string name;
            cin >> num >> name;
            mp[num] = name;
        } else if(t=="del") {
            long long num; 
            cin >> num;
            mp.erase(num);
        } else {
            long long num;
            cin >> num;
            if(mp.count(num)) cout << mp[num] << "\n";
            else cout << "not found\n";
        }
    }
    return 0;
}
