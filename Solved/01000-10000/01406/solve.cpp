#include <iostream>
#include <list>

using namespace std;

int main() {
    string buf;
    list<char> array;
    list<char>::iterator loc;
    int T;
    char cmd;

    cin >> buf;
    for (auto c : buf) array.push_back(c);
    loc = array.end();

    cin >> T;
    while (T--) {
        cin >> cmd;
        if (cmd == 'L' && loc != array.begin()) loc--; 
        else if (cmd == 'D' && loc != array.end()) loc++; 
        else if (cmd == 'B' && loc != array.begin()) {
            loc--;
            loc = array.erase(loc);
        }
        else if (cmd == 'P') {
            cin >> buf;
            array.insert(loc, buf[0]);
        }
    }

    for (auto c : array) cout << c;

    return 0;
}