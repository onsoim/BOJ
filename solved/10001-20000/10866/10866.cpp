#include <iostream>
#include <string>
#include <deque>

using namespace std;

int main() {
	int T, X;
	string cmd;
	deque<int> dq;
	
	cin >> T;
	while (T--) {
		cin >> cmd;
		
		if (cmd == "push_front" || cmd == "push_back") {
			cin >> X;
			if (cmd == "push_front") dq.push_front(X);
			else dq.push_back(X);
		}

		else if (cmd == "pop_front" || cmd == "pop_back" || cmd == "front" || cmd == "back") {
			if (dq.empty()) cout << "-1\n";
			else {
				if (cmd == "front" || cmd == "pop_front") cout << dq.front() << "\n";
				else cout << dq.back() << "\n";

				if (cmd == "pop_front") dq.pop_front();
				else if (cmd == "pop_back") dq.pop_back();
			}
		}
		
		else if (cmd == "size") cout << dq.size() << "\n";
		else if (cmd == "empty") cout << (dq.empty() ? "1\n":"0\n");
	}

	return 0;
}