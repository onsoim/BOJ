#include <iostream>
#include <string>
#include <queue>

using namespace std;

int main() {
	int T, X;
	string cmd;
	queue<int> q;
	
	cin >> T;
	while (T--) {
		cin >> cmd;
		
		if (cmd == "push") {
			cin >> X;
			q.push(X);
		}
		
		else if (cmd == "pop" || cmd == "front" || cmd == "back") {
			if (q.empty()) cout << "-1\n";
			else {
				if (cmd == "front" || cmd == "pop") cout << q.front() << "\n";
				else if (cmd == "back") cout << q.back() << "\n";
				if (cmd == "pop") q.pop();
			}
		}
		
		else if (cmd == "size") cout << q.size() << "\n";
		else if (cmd == "empty") cout << (q.empty() ? "1\n":"0\n");
	}

	return 0;
}