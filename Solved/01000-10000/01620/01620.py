import sys
N,M = map(int,input().split(" "))
list_pock,dict_pock = [],{}
for i in range(N):
	pock = sys.stdin.readline().rstrip()
	list_pock.append(pock)
	dict_pock[pock] = i + 1
for _ in range(M):
	s = sys.stdin.readline().rstrip()
	try: print(dict_pock[s])
	except: print(list_pock[int(s)-1])


'''
26 5
Bulbasaur
Ivysaur
Venusaur
Charmander
Charmeleon
Charizard
Squirtle
Wartortle
Blastoise
Caterpie
Metapod
Butterfree
Weedle
Kakuna
Beedrill
Pidgey
Pidgeotto
Pidgeot
Rattata
Raticate
Spearow
Fearow
Ekans
Arbok
Pikachu
Raichu
25
Raichu
3
Pidgey
Kakuna
	'''