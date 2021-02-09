#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
    int N, cnt = 0;
    string str;
    stack<char> s;

    cin >> N;
    while (N--) {
        cin >> str;
        s = {};

        for (int i = 0; i < str.size(); i++)
            if (s.empty() || s.top() != str[i]) s.push(str[i]);
            else s.pop();
        if (s.empty()) cnt++;
    }
    cout << cnt;

    return 0;
}