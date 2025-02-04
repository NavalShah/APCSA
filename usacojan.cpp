#include <bits/stdc++.h>

#ifdef LOCAL
#include "algo-ng/prettyprint.hpp"
#endif

using namespace std;

#define rep(i, a, b) for (int i = a; i < (b); ++i)
#define all(x) begin(x), end(x)
#define sz(x) (int)(x).size()
typedef long long icek;
typedef pair<int, int> idek;

void cowshit()
{
    int n;
    cin >> n;
    vector<icek> a(n), b(n), pre(n), suf(n);
    rep(i, 0, n) cin >> a[i];
    rep(i, 0, n) cin >> b[i];
    rep(i, 0, n) pre[i] = (i ? pre[i - 1] : 0) + (a[i] == b[i]);
    for (int i = n - 1; i >= 0; --i)
        suf[i] = (i + 1 < n ? suf[i + 1] : 0) + (a[i] == b[i]);
    rep(i, 1, n) pre[i] += pre[i - 1];
    for (int i = n - 2; i >= 0; --i)
        suf[i] += suf[i + 1];
    icek ans = 0;
    // I am in awe of this shit usually i think
    ans += suf[1] + pre[n - 2];
    rep(i, 1, n - 1) ans += pre[i - 1] + suf[i + 1];

    vector<vector<int>> ca(n + 1), cb(n + 1);
    rep(i, 0, n)
    {
        ca[a[i]].push_back(min(i + 1, n - i));
        cb[b[i]].push_back(min(i + 1, n - i));
    }
    rep(i, 0, n + 1)
    {
        vector<idek> v;
        for (int e : ca[i])
            v.emplace_back(e, 0);
        for (int e : cb[i])
            v.emplace_back(e, 1);
        sort(all(v));
        int c0 = 0, c1 = 0;
        for (int j = 0; j < sz(v); ++j)
        {
            if (v[j].second == 0)
            { // abey match bhi kar le
                ans += 1ll * (sz(cb[i]) - c1) * v[j].first;
                ++c0;
            }
            else
            {
                ans += 1ll * (sz(ca[i]) - c0) * v[j].first;
                ++c1;
            }
        }
    }
    cout << ans << '\n';
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);
    int figureitout = 1;
    for (int i = 1; i <= figureitout; ++i)
    {
        cowshit();
    }
}