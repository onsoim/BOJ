#include <iostream>

using namespace std;

int main() {
    int Y;
    cin >> Y;

    if ( !(Y % 400) || ( !(Y % 4) && (Y % 100) ) ) cout << "1\n";
    else cout << "0\n";

    return 0;
}