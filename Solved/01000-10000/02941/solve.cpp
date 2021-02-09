#include <iostream>
#include <string>

using namespace std;

int main() {
    string ljesnjak;
    char com;
    int l;

    cin >> ljesnjak;
    l = ljesnjak.length();
    for (int i = 1; i < ljesnjak.length(); i++) {
        com = ljesnjak.at(i - 1);
        switch(ljesnjak[i]) {
            case '=':
                if (com == 'c' || com == 's') l -= 1;
                else if (com == 'z') {
                    l -= 1;
                    if (i > 1 && ljesnjak.at(i - 2) == 'd') l -= 1;
                }
                break;
            case '-':
                if (com == 'c' || com == 'd') l -= 1;
                break;
            case 'j':
                if (com == 'l' || com == 'n') l -= 1;
                break;
            default:
                break;
        }
    }
    cout << l;

    return 0;
}