#include <stdio.h>

#define ll long long


ll prefix(ll num) {
    ll sum = 0;
    ll idx = 2;

    while (num > idx / 2) {
        sum += num / idx * idx / 2;

        ll tmp = num % idx - idx / 2;
        if (tmp > 0) sum += tmp;

        idx *= 2;
    }

    return sum;
}

int main(void) {
    ll A, B;

    scanf("%lld %lld", &A, &B);
    printf("%lld\n", prefix(B + 1) - prefix(A));

    return 0;
}