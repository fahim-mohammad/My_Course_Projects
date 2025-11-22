#include <bits/stdc++.h>
using namespace std;

long long p = 1000000007;
long long x = 263;

vector<long long> build_hash(const string &s) {
    int n = s.size();
    vector<long long> h(n+1);
    h[0] = 0;
    for (int i = 1; i <= n; i++)
        h[i] = (h[i-1] * x + s[i-1]) % p;
    return h;
}

long long get_hash(const vector<long long> &h, long long xp, int a, int L) {
    long long r = (h[a+L] - h[a] * xp % p + p) % p;
    return r;
}

bool check(int L, const string &a, const string &b,
           const vector<long long> &ha,
           const vector<long long> &hb,
           const vector<long long> &xp) {
    unordered_map<long long, vector<int>> mp;
    for (int i = 0; i + L <= (int)a.size(); i++)
        mp[get_hash(ha, xp[L], i, L)].push_back(i);

    for (int j = 0; j + L <= (int)b.size(); j++) {
        long long hv = get_hash(hb, xp[L], j, L);
        if (mp.count(hv)) return true;
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string a, b;
    cin >> a >> b;
    int A = a.size(), B = b.size();

    vector<long long> ha = build_hash(a);
    vector<long long> hb = build_hash(b);

    int N = max(A,B);
    vector<long long> xp(N+1);
    xp[0] = 1;
    for (int i = 1; i <= N; i++)
        xp[i] = (xp[i-1] * x) % p;

    int low = 0, high = min(A,B), ans = 0;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (check(mid, a, b, ha, hb, xp))
            ans = mid, low = mid + 1;
        else
            high = mid - 1;
    }

    cout << ans;
    return 0;
}
