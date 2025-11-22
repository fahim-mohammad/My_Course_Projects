#include <bits/stdc++.h>
using namespace std;

long long p1 = 1000000007;
long long p2 = 1000000009;
long long x  = 263;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;
    int n = s.size();

    vector<long long> h1(n+1), h2(n+1), xp1(n+1), xp2(n+1);
    h1[0] = h2[0] = 0;
    xp1[0] = xp2[0] = 1;

    for (int i = 1; i <= n; i++) {
        h1[i] = (h1[i-1]*x + s[i-1]) % p1;
        h2[i] = (h2[i-1]*x + s[i-1]) % p2;
        xp1[i] = (xp1[i-1]*x) % p1;
        xp2[i] = (xp2[i-1]*x) % p2;
    }

    auto get_hash = [&](int a, int L) {
        long long r1 = (h1[a+L] - h1[a]*xp1[L] % p1 + p1) % p1;
        long long r2 = (h2[a+L] - h2[a]*xp2[L] % p2 + p2) % p2;
        return make_pair(r1, r2);
    };

    int q;
    cin >> q;
    while(q--) {
        int a, b, L;
        cin >> a >> b >> L;
        cout << (get_hash(a,L) == get_hash(b,L) ? "Yes\n" : "No\n");
    }
    return 0;
}
