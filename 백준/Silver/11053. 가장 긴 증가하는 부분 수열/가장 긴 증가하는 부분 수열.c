#include <stdio.h>
#include <stdlib.h>

int arr[1001];
int dp[1001];
int h[1001];

void longest_increasing_subseq(int s[], int n) {
	int i, j;
	int MAX = n + 1;
	int max = 0, index;

	for (i = 1; i < MAX; i++) {
		for (j = 0; j < i; j++)
			if (s[i] > s[j] && h[i] < h[j] + 1) {
				h[i] = h[j] + 1;
				dp[i] = j;
			}
	}
	for (i = 1; i < MAX; i++)
		if (max < h[i]) {
			max = h[i];
			index = i;
		}
	i = max;
	printf("%d", max);
}

int main()
{
    int n;
	scanf("%d", &n);
	for (int i = 1; i < n+1; i++) {
		scanf("%d", &arr[i]);
	}

	longest_increasing_subseq(arr, n);

}