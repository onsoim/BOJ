import sys
import requests
from bs4 import BeautifulSoup
import subprocess

def boj_ac():
	print("[*] check BOJ status")
	# nic = input("input nicname: ")
	res,ret = requests.get(url="https://www.acmicpc.net/status?user_id=onsoim"),[]
	html = BeautifulSoup(res.text, 'html.parser')
	tr = html.select('tr')
	for i in range(1,len(tr)):
		if "맞았습니다!!" in str(tr[i]):
			a = tr[i].select('a')[1]
			ret.append(['{:05d}'.format(int(a.get_text())),a['title']])
	return ret

def git_none():
	accept,ret = boj_ac(),[]
	print("[*] check GIT status")
	for i in range(len(accept)):
		num = accept[i][0]
		folder = "01000-10000" if num[0] == "0" else "10001-20000"
		res = requests.get(url="https://github.com/onsoim/BOJ/tree/master/{}/{}.py".format(folder,num))
		if res.status_code == 404:
			ret.append([folder,accept[i][0],accept[i][1]])
	return ret

if __name__ == "__main__":
	upload = git_none()
	for i in range(len(upload)):
		folder,filename,problem = map(str,upload[i])
		print("-> upload {}.py".format(filename))
		subprocess.call('mv ./unsolved/{}.py ./{}/{}.py'.format(filename,folder,filename),shell=True)
		subprocess.call('git add ./{}/'.format(folder),shell=True)
		subprocess.call('git commit -m "{} - {}"'.format(filename,problem),shell=True)
	subprocess.call('git push',shell=True)
