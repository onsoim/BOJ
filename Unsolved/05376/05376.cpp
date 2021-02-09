#include <iostream>
#include <string>
#include <math.h>

using namespace std;
using ll = long long;

ll gcd(ll a, ll b) {
    ll tmp = 0;
    while (b != 0) {
        tmp = a % b;
        a = b, b = tmp;
    }
    return a;
}

void float2fraction(string num) {
    ll ord = 0, card = 0, card2 = 0, g;
    int flag = 0, l = num.length(), l2 = 0;
    for (int i = 2; i < l; i++) {
        if (num.at(i) == '(') {
            flag = 1;
            l--;
            card2 = card;
        }
        else {
            card = card * 10 + num.at(i) - 0x30;
            ord *= 10;
            if (flag) ord += 9;
            else l2++;
        }
    }
    if (!ord) ord = 1;
    ord *= (ll)pow(10, l2);
    card -= card2;
    g = gcd(ord, card);
    cout << card/g << "/" << ord/g << "\n";
}

int main() {
    int T;
    string num;
    // freopen("05376_01.in", "r", stdin);
    cin >> T;
    while (T--) {
        cin >> num;
        float2fraction(num);
    }
    return 0;
}