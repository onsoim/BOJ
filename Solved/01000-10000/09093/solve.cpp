#include <iostream>
#include <sstream>
#include <algorithm>

using namespace std;

int main() {
    int T;
    string buf;

    cin >> T;
    getchar();
    while(T--) {
        getline(cin, buf);
        stringstream ss(buf);

        while (ss >> buf) {
            reverse(buf.begin(), buf.end());
            cout << buf << " ";
        }
        cout << "\n";
    }

    return 0;
}