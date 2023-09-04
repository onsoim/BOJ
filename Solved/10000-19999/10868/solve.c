
#include <stdio.h>

typedef long long ll;

ll n[1000000];
ll stMIN[4000000];

int left = 0;
int right = 0;

ll init(int from, int to, int idx) {
    if (from == to) {
        stMIN[idx] = n[from];
    }
    else {
        int mid = (from + to) / 2;
        ll left = init(from, mid, idx * 2);
        ll right = init(mid + 1, to, idx * 2 + 1);
        stMIN[idx] = left < right ? left : right;
    }

    return stMIN[idx];
}

ll query(int from, int to, int idx) {
    if (left > to || right < from) return 1000 * 1000 * 1000;
    if (left <= from && right >= to) return stMIN[idx];

    int mid = (from + to) / 2;
    ll ltmp = query(from, mid, idx * 2);
    ll rtmp = query(mid + 1, to, idx * 2 + 1);

    return ltmp < rtmp ? ltmp : rtmp;
}

int main() {
    int N, M;

    scanf("%d %d", &N, &M);

    for (int i = 0; i < N; i++) {
        scanf("%lld", &n[i]);
    }

    init(0, N - 1, 1);

    for (int i = 0; i < M; i++) {
        scanf("%d %d", &left, &right);
        left -= 1;
        right -= 1;
        printf("%lld\n", query(0, N - 1, 1));
    }

    return 0;
}