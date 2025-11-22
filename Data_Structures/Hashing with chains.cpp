#include <bits/stdc++.h>
using namespace std;

long long p = 1000000007;
long long x = 263;

long long hash_func(const string &s, int m) {
    long long h = 0;
    for(int i = s.size()-1; i >= 0; i--)
        h = (h * x + s[i]) % p;
    return h % m;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m, n;
    cin >> m >> n;

    vector<vector<string>> chain(m);

    while(n--) {
        string type;
        cin >> type;

        if(type == "add") {
            string s;
            cin >> s;
            long long h = hash_func(s, m);
            bool exists = false;
            for(auto &t : chain[h]) {
                if(t == s) { exists = true; break; }
            }
            if(!exists) chain[h].insert(chain[h].begin(), s);
        }

        else if(type == "del") {
            string s;
            cin >> s;
            long long h = hash_func(s, m);
            for(int i=0;i<(int)chain[h].size();i++){
                if(chain[h][i] == s){
                    chain[h].erase(chain[h].begin()+i);
                    break;
                }
            }
        }

        else if(type == "find") {
            string s;
            cin >> s;
            long long h = hash_func(s, m);
            bool exists = false;
            for(auto &t : chain[h]) {
                if(t == s) { exists = true; break; }
            }
            cout << (exists ? "yes\n" : "no\n");
        }

        else {
            int idx;
            cin >> idx;
            for(auto &t : chain[idx]) cout << t << " ";
            cout << "\n";
        }
    }
    return 0;
}
