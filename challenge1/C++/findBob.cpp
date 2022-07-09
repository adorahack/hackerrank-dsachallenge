#include <iostream>
#include <vector>
#include <functional>
#include <string>

int main() {
  int n, m;
  std::cin >> n >> m;

  std::vector<std::string> grid(n);
  for (int i = 0; i < n; i++)
    std::cin >> grid[i];

  int aliceX = -1, aliceY = -1;
  for (int i = 0; i < n; i++) 
    for (int j = 0; j < (int) grid[i].size(); j++) 
      if (grid[i][j] == 'A') 
        aliceX = i, aliceY = j;

  std::function<bool(int, int)> canReach = [&](int x, int y) {
    if (x >= n || y >= m) return false;
    if (grid[x][y] == '#') return false;
    if (grid[x][y] == 'B') return true;
    return (canReach(x + 1, y) || canReach(x, y + 1));
  };

  if (canReach(aliceX, aliceY))
    std::cout << "YES";
  else
    std::cout << "NO";

  return 0;
}