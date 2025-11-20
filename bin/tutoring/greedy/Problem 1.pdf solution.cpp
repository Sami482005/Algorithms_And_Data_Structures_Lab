#include <bits/stdc++.h>
using namespace std;

#define io                            \
    ios_base::sync_with_stdio(false); \
    cin.tie(NULL);                    \
    cout.tie(NULL)
typedef long long ll;

ll n;
vector<ll> edge;

vector<ll> dijkstra(ll s, vector<vector<pair<ll, ll>>> &arr)
{
    vector<ll> dist(n + 1, 1E18);
    priority_queue<pair<ll, ll>, vector<pair<ll, ll>>, greater<pair<ll, ll>>> pq;
    vector<ll> vis(n + 1);

    pq.push({0, s});
    dist[s] = 0;
    edge[s] = -1;
    while (!pq.empty())
    {
        ll u = pq.top().second;
        ll d = pq.top().first;
        pq.pop();
        if (vis[u])
            continue;
        vis[u] = 1;

        for (auto &it : arr[u])
        {
            int v = it.first;
            int w = it.second;
            if (w + d < dist[v])
            {
                dist[v] = w + d;
                pq.push({dist[v], v});
                edge[v] = u;
            }
        }
    }
    return dist;
}

void printpath(int target, vector<ll> path)
{
    vector<ll> res;
    for (int i = target; i != -1; i = path[i])
    {
        res.push_back(i);
    }
    reverse(res.begin(), res.end());
    for (int i = 0; i < res.size(); ++i)
    {
        cout << res[i] << " ";
    }
}

int main()
{
    io;
    ll m;
    cin >> n >> m;
    edge.resize(n + 1, -1);
    vector<vector<pair<ll, ll>>> arr(n + 1);
    for (int i = 0; i < m; ++i)
    {
        ll a, b, c;
        cin >> a >> b >> c;
        arr[a].push_back({b, c});
        arr[b].push_back({a, c});
    }
    vector<ll> res = dijkstra(1, arr);
    if (res[n] == 1E18)
        cout << -1;
    else
        printpath(n, edge);
}