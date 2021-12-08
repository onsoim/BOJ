#include <iostream>
#include <string>
#include <math.h>

using namespace std;

int b2o(string str, int l) {
    int sum = 0;
    for (int i = 0; i < l; i++)
        if (str.at(i) - 0x30) sum += pow(2, l - i - 1);
    return sum;
}

int main() {
    string bin, calc;
    int l, i;

    cin >> bin;
    l = bin.length();

    if (l % 3) cout << b2o(bin.substr(0, l % 3), l % 3);
    for (i = l % 3; i < l; i += 3)
        cout << b2o(bin.substr(i, 3), 3);

    return 0;
}