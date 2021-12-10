#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
    string ch;
    stack<char> brackets;
    int sum = 0;

    cin >> ch;
    for (int i = 0; i < ch.size(); i++) {
        if (ch[i] == '(') brackets.push('(');
        else if (ch[i] == ')') {
            brackets.pop();
            if (ch[i-1] != '(') sum++;
            else sum += brackets.size();
        }
    }
    cout << sum;

    return 0;
}