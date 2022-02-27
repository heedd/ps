#include <stdio.h>
#include <stdlib.h>

int MAX(int a, int b) { return a > b ? a : b; }
#define max 501
int best[max][max];


void number_triangle(int a[][max], int k) {
	int i, j;
	int max_result = 0;
	for (i = 1; i <= k; i++)
		for (j = 1; j <= i; j++)
			best[i][j] = a[i][j] + MAX(best[i - 1][j - 1], best[i - 1][j]);
	for (i = 1; i <= k; i++)
		if (max_result < best[k][i]) max_result = best[k][i];
	printf("%d", max_result);
}

int main()
{
	int n;
	int arr[501][501];
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for(int j=1; j<=i; j++)
			scanf("%d", &arr[i][j]);
	}

	number_triangle(arr, n);
	return 0;
}