#include <iostream>
#include <string>

using namespace std;

class tree {
private:
    char data;
    tree* right;
    tree* left;
public:
    tree(char c) {
        data  = c;
        right = NULL;
        left  = NULL;
    }

    char  getData () { return data; }
    tree* getRight() { return right; }
    tree* getLeft () { return left; }

    void setData (char c) { data  = c; }
    void setRight(char c) { right = new tree(c); }
    void setLeft (char c) { left  = new tree(c); }
};

int main() {
    ios_base::sync_with_stdio(0), cin.tie(0);

    tree* root = new tree('.');
    int k;

    cin >> k;
    while (k--) {
        char character;
        string binary;

        cin >> character >> binary;
        
        tree* search = root;
        for (char c: binary) {
            if (c == '0') { 
                if (search->getLeft() == NULL) search->setLeft('.');
                search = search->getLeft();
            }
            else {
                if (search->getRight() == NULL) search->setRight('.');
                search = search->getRight();
            }
        }
        search->setData(character);
    }

    tree* traversal = root;
    string digits;

    cin >> digits;
    for (auto c: digits) {
        if (c == '0') {
            if (traversal->getLeft() == NULL) {
                cout << traversal->getData();
                traversal = root;
            }
            traversal = traversal->getLeft();
        }
        else {
            if (traversal->getRight() == NULL) {
                cout << traversal->getData();
                traversal = root;
            }
            traversal = traversal->getRight();
        }
    }
    cout << traversal->getData() << endl;

    return 0;
}