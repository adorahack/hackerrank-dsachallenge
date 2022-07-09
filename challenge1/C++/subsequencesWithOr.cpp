#include <iostream>
#include <vector>
#include <functional>

int main() {
  int n, X;
  std::cin >> n >> X;

  std::vector<int> a(n);
  for (int i = 0; i < n; i++)
    std::cin >> a[i];

  std::function<int(int, int)> countSubsequences = [&](int index, int total) {
    if (index == n) return (total == X ? 1 : 0);
    return countSubsequences(index + 1, total | a[index]) +
           countSubsequences(index + 1, total);
  };

  std::cout << countSubsequences(0, 0);

  return 0;
}