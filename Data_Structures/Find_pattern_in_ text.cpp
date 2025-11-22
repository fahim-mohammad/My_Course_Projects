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

    vector<long long> h(T+1);
    h[T] = 0;

    for (int i = T-1; i >= 0; i--)
        h[i] = (h[i+1]*x + text[i]) % p;

    long long hp = 0;
    for (int i = P-1; i >= 0; i--)
        hp = (hp*x + pat[i]) % p;

    long long xP = 1;
    for (int i = 0; i < P; i++)
        xP = (xP * x) % p;

    for (int i = 0; i + P <= T; i++) {
        long long cur = (h[i] - h[i+P]*xP % p + p) % p;
        if (cur == hp) {
            bool ok = true;
            for (int j = 0; j < P; j++)
                if (pat[j] != text[i+j]) { ok = false; break; }
            if (ok) cout << i << " ";
        }
    }
    return 0;
}
