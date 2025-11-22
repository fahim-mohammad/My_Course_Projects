#include <bits/stdc++.h>
using namespace std;

long long p = 1000000007;
long long x = 263;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string pat, text;
    cin >> pat >> text;

    int P = pat.size();
    int T = text.size();
    if (P > T) return 0;

    vector<long long> h(T+1), hp(P+1), xp(P+1);
    h[T] = 0;
    xp[0] = 1;

    for (int i = T-1; i >= 0; i--)
        h[i] = (h[i+1]*x + text[i]) % p;

    for (int i = 1; i <= P; i++)
        xp[i] = (xp[i-1]*x) % p;

    hp[P] = 0;
    for (int i = P-1; i >= 0; i--)
        hp[i] = (hp[i+1]*x + pat[i]) % p;

    auto get_hash_text = [&](int i, int len) {
        return (h[i] - h[i+len]*xp[len] % p + p) % p;
    };

    auto get_hash_pat = [&](int i, int len) {
        return (hp[i] - hp[i+len]*xp[len] % p + p) % p;
    };

    for (int i = 0; i + P <= T; i++) {
        if (get_hash_text(i,P) == get_hash_pat(0,P)) {
            cout << i << " ";
            continue;
        }

        int L = 0, R = P-1, pos = -1;
        while (L <= R) {
            int M = (L+R)/2;
            if (get_hash_text(i,M+1) == get_hash_pat(0,M+1))
                L = M+1;
            else {
                pos = M;
                R = M-1;
            }
        }

        if (pos == -1) continue;

        if (get_hash_text(i+pos+1, P-pos-1) ==
            get_hash_pat(pos+1, P-pos-1))
            cout << i << " ";
    }
    return 0;
}
