#include <iostream>
#include <string>
#include <list>
#include <stack>

using namespace std;

int main() {
    string buf;
    list<char> characters;
    stack<char> reverse;
    bool flag = false;

    getline(cin, buf);

    for (char c : buf)
        switch (c) {
            case '<':
                flag = true;
            case ' ':
                while (!reverse.empty()) {
                    characters.push_back(reverse.top());
                    reverse.pop();
                }
                characters.push_back(c);
                break;
            case '>':
                flag = false;
                characters.push_back(c);
                break;
            default:
                if (flag) characters.push_back(c);
                else reverse.push(c);
                break;
        }

    for (char c : characters) cout << c;
    while (!reverse.empty()) {
        cout << reverse.top();
        reverse.pop();
    }
    return 0;
}