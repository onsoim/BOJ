#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
	int T, X;
	string cmd;
	stack<int> s;
	
	cin >> T;
	while (T--) {
		cin >> cmd;
		
		if (cmd == "push") {
			cin >> X;
			s.push(X);
		}
		
		else if (cmd == "pop" || cmd == "top") {
			if (s.empty()) cout << "-1\n";
			else {
				cout << s.top() << "\n";
				if (cmd == "pop") s.pop();
			}
		}
		
		else if (cmd == "size") cout << s.size() << "\n";
		else if (cmd == "empty") cout << (s.empty() ? "1\n":"0\n");
	}

	return 0;
}