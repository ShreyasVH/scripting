import requests
import json


def get(url, headers={}):
	return requests.get(url, headers=headers)

def post(url, payload, headers={}):
	return requests.post(url=url, json=payload, headers=headers)

def delete(url, headers={}):
	return requests.delete(url, headers=headers)

def put(url, payload, headers={}):
	return requests.put(url=url, json=payload, headers=headers)

url = 'http://cors.playframework.com/api?input=abc'
headers = {
	'c': 'C',
	'd': 'D'
}
response = get(url, headers)
print(json.dumps(response.json(), indent=1))

print('-------------------------------')

url = 'http://cors.playframework.com/api'
headers = {
	'c': 'C',
	'd': 'D'
}
response = post(url, {'a': 'A', 'b': 'B'}, headers)
print(json.dumps(response.json(), indent=1))

print('-------------------------------')

url = 'http://cors.playframework.com/api?input=abc'
headers = {
	'c': 'C',
	'd': 'D'
}
response = delete(url, headers)
print(json.dumps(response.json(), indent=1))

print('-------------------------------')

url = 'http://cors.playframework.com/api'
headers = {
	'c': 'C',
	'd': 'D'
}
response = put(url, {'a': 'A', 'b': 'B'}, headers)
print(json.dumps(response.json(), indent=1))