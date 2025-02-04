#include <bits/stdc++.h>

#ifdef LOCAL
#include "algo-ng/prettyprint.hpp"
#endif

using namespace std;

#define int long long
#define rep(i, a, b) for (int i = a; i < (b); ++i)
#define all(x) begin(x), end(x)
#define sz(x) (int)(x).size()
typedef long long icek;
typedef pair<int, int> idek;
typedef vector<int> vi;

int minOperationsToCongruent(vector<int> &A, int M)
{
    if (M == 1)
    {
        return 0; // duh chutiye
    }

    int n = A.size();
    vector<int> remainders(n);
    for (int i = 0; i < n; ++i)
    {
        int rem = A[i] % M;
        if (rem < 0)
            rem += M; // neg mat kar
        remainders[i] = rem;
    }

    sort(remainders.begin(), remainders.end());

    // aur ek
    vector<int> S = remainders;
    for (int r : remainders)
    {
        S.push_back(r + M);
    }

    // sums
    vector<long long> prefix(S.size() + 1, 0);
    for (int i = 0; i < S.size(); ++i)
    {
        prefix[i + 1] = prefix[i] + S[i];
    }

    long long minTotal = LLONG_MAX;

    for (int i = 0; i <= (int)S.size() - n; ++i)
    {
        int j = i + n;
        int m = i + (n - 1) / 2;
        long long median = S[m];

        int leftCount = m - i + 1;
        long long leftSum = median * leftCount - (prefix[m + 1] - prefix[i]);

        int rightCount = j - (m + 1);
        long long rightSum = (prefix[j] - prefix[m + 1]) - median * rightCount;

        long long total = leftSum + rightSum;
        if (total < minTotal)
        {
            minTotal = total;
        }
    }

    return (int)minTotal;
}

void solve()
{
    int n, m;
    cin >> n >> m;
    vi a(n);
    rep(i, 0, n) cin >> a[i], a[i] %= m;
    cout << minOperationsToCongruent(a, m) << '\n';
}

signed main()
{
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);
    int tc = 1;
    cin >> tc;
    for (int i = 1; i <= tc; ++i)
    {
        solve();
    }
}