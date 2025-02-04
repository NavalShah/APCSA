#include <bits/stdc++.h>

#ifdef LOCAL
#include "algo-ng/prettyprint.hpp"
#endif

using namespace std;

#define rep(i, a, b) for (int i = a; i < (b); ++i)
#define all(x) begin(x), end(x)
#define sz(x) (int)(x).size()
typedef long long ll;
typedef pair<int, int> bruh;
typedef vector<int> kariey;

void solve()
{
    int n;
    cin >> n;
    vector<kariey> a(n, kariey(n));
    rep(i, 0, n) rep(j, 0, n) cin >> a[i][j];
    if (n == 1)
    { // literally edge case
        cout << "2\n";
        return;
    }
    vector<vector<pair<int, int>>> idx(2 * n + 1, vector<pair<int, int>>());
    rep(i, 0, n) rep(j, 0, n) idx[a[i][j]].emplace_back(i, j);

    rep(i, 2, 2 * n + 1)
    {
        if (sz(idx[i]) == n)
        {
            swap(idx[i], idx[n + 1]);
            break;
        }
    }

    for (int i = 1; i < n; ++i)
    {
        vector<int> pick;
        for (int j = 2; j <= 2 * n; ++j)
        {
            if (sz(idx[j]) == i)
                pick.push_back(j);
        }

        if (idx[pick[0]].front() < idx[pick[1]].front())
        {
            swap(idx[pick[0]], idx[i + 1]);
            swap(idx[pick[1]], idx[2 * n - i + 1]);
        }
        else
        {
            swap(idx[pick[0]], idx[2 * n - i + 1]);
            swap(idx[pick[1]], idx[i + 1]);
        }
    }

    rep(i, 3, n + 1)
    {
        bool need_swap = true;
        for (auto [x, y] : idx[i])
        {
            if (x == idx[2][0].first || y == idx[2][0].second)
            {
                need_swap = false;
                break;
            }
        }
        if (need_swap)
        {
            swap(idx[i], idx[2 * (n + 1) - i]);
            continue;
        }
    }

    vector<kariey> ans(n, kariey(n));
    rep(i, 2, 2 * n + 1)
    {
        for (auto [x, y] : idx[i])
        {
            ans[x][y] = i;
        }
    }
    vector<kariey> ans2(n, kariey(n));
    int state = 0;
    rep(i, 0, n) rep(j, 0, n)
    {
        ans2[i][j] = 2 * (n + 1) - ans[i][j];
        if (state == 0)
        {
            if (ans2[i][j] > ans[i][j])
                state = 1;
            if (ans2[i][j] < ans[i][j])
                state = -1;
        }
    }
    rep(i, 0, n) rep(j, 0, n)
    {
        if (state == 1)
            cout << ans[i][j] << " \n"[j == n - 1];
        else if (state == -1)
            cout << ans2[i][j] << " \n"[j == n - 1];
    }
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);
    int tc = 1;
    for (int i = 1; i <= tc; ++i)
    {
        solve();
    }
}