#include <iostream>

using namespace std;

int main() {
    int A, B, C, D;
    int sum = 0;

    cin >> A >> B >> C >> D;
    sum = A + B + C + D;

    printf("%d\n%d\n", sum / 60 , sum % 60);

    return 0;
}