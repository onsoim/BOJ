
#include <stdio.h>

#define MOD(x, y) (int)((long)x * y % 1000000007)
#define F(i) for(int j=0;j<i;j++)

int n[1000000];
int r[1000000];
int setr[4000000];

int a, b, c;

int init(int from, int to, int idx) {
    if (from == to) {
        setr[idx] = n[from];
        r[from] = idx;
    }
    else {
        int mid = (from + to) / 2;
        setr[idx] = MOD(init(from, mid, idx * 2), init(mid + 1, to, idx * 2 + 1));
    }

    return setr[idx];
}

int mul(int from, int to, int idx) {
    if (b > to || c < from) return 1;
    if (b <= from && c >= to) return setr[idx];

    int mid = (from + to) / 2;
    return MOD(mul(from, mid, idx * 2), mul(mid + 1, to, idx * 2 + 1));
}

// [logic error] a / b mod p != (a mod p) / b mod p
// void update(int from, int to, int idx) {
//     if (b < from || b > to) return;

//     setr[idx] = (int)((long)setr[idx] * c / n[b] % 1000000007);
//     if (from == to) return;

//     int mid = (from + to) / 2;
//     update(from, mid, idx * 2);
//     update(mid + 1, to, idx * 2 + 1);
// }

void update() {
    int idx = r[b];
    setr[idx] = c;

    while (idx != 1) {
        if (idx % 2) {
            setr[idx / 2] = MOD(setr[idx - 1], setr[idx]);
        }
        else {
            setr[idx / 2] = MOD(setr[idx], setr[idx + 1]);
        }
        idx /= 2;
    }
}

int main() {
    int N, M, K;

    scanf("%d %d %d", &N, &M, &K);

    F(N) scanf("%d", &n[j]);
    init(0, N - 1, 1);
 
    F(M + K) {
        scanf("%d %d %d", &a, &b, &c);
        b -= 1;

        if (a % 2) update();
        else {
            c -= 1;
            printf("%d\n", mul(0, N - 1, 1));
        }
    }

    return 0;
}