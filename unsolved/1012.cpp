#include <iostream> 

using std::cin;
using std::cout;
using std::endl;

int main(int argc, char **argv) {
	int T;

	cin >> T;

	for(int i=0;i<T;i++) {
		int M,N,K;
		cin >> M >> N >> K;

		int **field = new int *[M];
		for(int j=0;j<M;++j)
			field[j] = new int [N];

		for(int j=0;j<M;++j)
			for(int k=0;k<N;++k)
				field[j][k] = 0;

		for(int j=0;j<K;j++) {
			int X,Y;
			cin >> X >> Y;
			field[X][Y] = 1;
		}
		for(int j=0;j<M;++j) {
			for(int k=0;k<N;++k)
				cout << field[j][k] << " ";
			cout << endl;
		}
		cout << endl;
	}

    return (0);
}