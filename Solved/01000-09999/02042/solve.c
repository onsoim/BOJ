
#include <stdio.h>

long long n[1000000];
long long segment[4000000];

long long init(int from, int to, int idx) {
    if (from == to) {
        segment[idx] = n[from];
    }
    else {
        int mid = (from + to) / 2;
        segment[idx] = init(from, mid, idx * 2) + init(mid + 1, to, idx * 2 + 1);
    }

    return segment[idx];
}

long long sum(int from, int to, int idx, int left, int right) {
    if(left > to || right < from) return 0;
    if (left <= from && right >= to) return segment[idx];

    int mid = (from + to) / 2;
    // printf("[S] %d~%d(%d) + %d~%d(%d)\n", from, mid, sum(from, mid, idx * 2, left, right), mid + 1, to, sum(mid + 1, to, idx * 2 + 1, left, right));
    return sum(from, mid, idx * 2, left, right) + sum(mid + 1, to, idx * 2 + 1, left, right);
}

void update(int from, int to, int idx, int new, long long diff) {
    if (new < from || new > to) return;

    // printf("[U] %d %d %d (%d => %d)\n", from, to, idx, segment[idx], segment[idx] + diff);
    segment[idx] += diff;
    if (from == to) return;

    int mid = (from + to) / 2;
    update(from, mid, idx * 2, new, diff);
    update(mid + 1, to, idx * 2 + 1, new, diff);
}

int main() {
    int N, M, K;
    int a, b;
    long long c;

    scanf("%d %d %d", &N, &M, &K);

    for(int i = 0; i < N; i++)
        scanf("%lld", &n[i]);
    init(0, N - 1, 1);

    for(int i = 0; i < M + K; i++) {
        scanf("%d %d %lld", &a, &b, &c);

        // update
        if (a == 1) {
            update(0, N - 1, 1, b - 1, c - n[b - 1]);
            n[b - 1] = c;
        }
        // printf
        else {
            printf("%lld\n", sum(0, N - 1, 1, b - 1, c - 1));
        }
    }

    return 0;
} 
