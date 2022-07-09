#include <iostream>
#include <vector>
#include <functional>

int main() {

  int n, S;
  std::cin >> n >> S;

  std::vector<int> l(n), r(n);
  for (int i = 0; i < n; i++) 
    std::cin >> l[i] >> r[i];

  std::function<int(int, int)> solve = [&](int index, int total) {
    if (index == n) 
      return (total == S ? 1 : 0);
    int res = 0;
    for (int value = l[index]; value <= r[index]; value++) 
      res += solve(index + 1, total + value);
    return res;
  };

  std::cout << solve(0, 0);

  return 0;
}