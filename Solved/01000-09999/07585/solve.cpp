#include <iostream>
#include <string.h>
#include <stack>

using namespace std;

int main() {
    char str[251];
    bool flag;
    int cmp;
    stack<char> s;

    cin.getline(str, 251, '\n');
    while (strlen(str) != 1 || str[0] != '#') {
        flag = true;
        s = {};
        for (int i = 0; i < strlen(str); i++)
            if (str[i] == '(' || str[i] == '[' || str[i] == '{') {
                s.push(str[i]);
            }

            else if (str[i] == ')' || str[i] == ']' || str[i] == '}') {
                if (s.empty() || (str[i] - s.top() != 1 && str[i] - s.top() != 2)) {
                    flag = false;
                    break;
                }
                s.pop();
            }

        if (flag && s.empty()) cout << "Legal\n";
        else cout << "Illegal\n";
        cin.getline(str, 251, '\n');
    }
    
    return 0;
}