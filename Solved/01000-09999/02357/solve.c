
#include <stdio.h>

typedef long long ll;

ll n[1000000];
ll stMIN[4000000];
ll stMAX[4000000];

int left = 0;
int right = 0;

ll initMIN(int from, int to, int idx) {
    if (from == to) {
        stMIN[idx] = n[from];
    }
    else {
        int mid = (from + to) / 2;
        ll left = initMIN(from, mid, idx * 2);
        ll right = initMIN(mid + 1, to, idx * 2 + 1);
        stMIN[idx] = left < right ? left : right;
    }

    return stMIN[idx];
}

ll initMAX(int from, int to, int idx) {
    if (from == to) {
        stMAX[idx] = n[from];
    }
    else {
        int mid = (from + to) / 2;
        ll left = initMAX(from, mid, idx * 2);
        ll right = initMAX(mid + 1, to, idx * 2 + 1);
        stMAX[idx] = left > right ? left : right;
    }

    return stMAX[idx];
}

ll queryMIN(int from, int to, int idx) {
    if (left > to || right < from) return 1000 * 1000 * 1000;
    if (left <= from && right >= to) return stMIN[idx];

    int mid = (from + to) / 2;
    ll ltmp = queryMIN(from, mid, idx * 2);
    ll rtmp = queryMIN(mid + 1, to, idx * 2 + 1);

    return ltmp < rtmp ? ltmp : rtmp;
}

ll queryMAX(int from, int to, int idx) {
    if (left > to || right < from) return 0;
    if (left <= from && right >= to) return stMAX[idx];

    int mid = (from + to) / 2;
    ll ltmp = queryMAX(from, mid, idx * 2);
    ll rtmp = queryMAX(mid + 1, to, idx * 2 + 1);

    return ltmp > rtmp ? ltmp : rtmp;
}

int main() {
    int N, M;

    scanf("%d %d", &N, &M);

    for (int i = 0; i < N; i++) {
        scanf("%lld", &n[i]);
    }

    initMIN(0, N - 1, 1);
    initMAX(0, N - 1, 1);

    for (int i = 0; i < M; i++) {
        int a, b;
        scanf("%d %d", &left, &right);

        left -= 1;
        right -= 1;
        printf("%lld %lld\n", queryMIN(0, N - 1, 1), queryMAX(0, N - 1, 1));
    }

    return 0;
}