#include <iostream>

using namespace std;

int main() {
    int A, B, V;
    int days;

    cin >> A >> B >> V;
    days = (V - A)/(A - B) + 1;
    if ((V - A) % (A - B)) days++;

    cout << days;
    return 0;
}