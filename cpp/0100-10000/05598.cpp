#include <iostream>

using namespace std;

int main() {
    string str;
    cin >> str;

    for (int i = 0; i < str.length(); i++) {
        if (str.at(i) < 68) str.at(i) += 23;
        else str.at(i) -= 3;
    }

    cout << str;
    return 0;
}