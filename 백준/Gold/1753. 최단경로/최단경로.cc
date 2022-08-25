#include <iostream>
#include <queue>
#include <vector>
#include <functional>

using namespace std;

#define INF 987654321
#define MAX_V 20001

int vertex, edge, startVertex;
int fromV, toV, weight;

int dist[MAX_V];
int isVisit[MAX_V];

vector<pair<int, int>> adj[MAX_V];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

void input() {
	ios_base::sync_with_stdio(false);

	cin >> vertex >> edge;
	cin >> startVertex;	

	for (int i = 0; i < edge; i++) {
		cin >> fromV >> toV >> weight;
		adj[fromV].push_back(make_pair(weight, toV));
	}
}

void initDist() {
	for (int i = 1; i <= vertex; i++) {
		dist[i] = INF;
	}
}

void shortestPath() {
	dist[startVertex] = 0;
	pq.push(make_pair(0, startVertex)); 

	while (!pq.empty()) {
		int cost = pq.top().first;
		int curr = pq.top().second;

		pq.pop();

		if (dist[curr] < cost) continue;
		if (dist[curr] == cost && isVisit[curr] == 1) continue;

		isVisit[curr] = 1;

		for (int i = 0; i < adj[curr].size(); i++) {
			int nextCost = adj[curr][i].first;
			int next = adj[curr][i].second;

			if (dist[next] > nextCost + cost) {
				dist[next] = nextCost + cost;
				pq.push(make_pair(nextCost + cost, next));
			}
		}
	}
}

void printShortestPath() {
	for (int i = 1; i <= vertex; i++) {
		if (dist[i] >= INF) {
			cout << "INF" << "\n";
		}
		else {
			cout << dist[i] << "\n";
		}
	}
}

int main() {
	input();
	initDist();
	shortestPath();
	printShortestPath();
}