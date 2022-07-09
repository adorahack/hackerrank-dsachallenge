#include <iostream>
#include <vector>
#include <functional>

int main() {
  int p0, p1, n, X;
  std::cin >> p0 >> p1 >> n >> X;

  std::vector<int> memo(n + 1, -1);
  std::function<int(int)> productNacci = [&](int n) {
    if (n == 0) return p0;
    if (n == 1) return p1;
    if (memo[n] != -1) return memo[n];
    memo[n] = (productNacci(n - 1) * productNacci(n - 2)) % X;
    return memo[n];
  };

  std::cout << productNacci(n) << std::endl;

  return 0;
}