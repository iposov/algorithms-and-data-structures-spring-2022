#include <iostream>
#include <set>

int main()
{
	std::set<int> tree;
	int N, x, j;

	std::cin >> N;
	for (int i = 0; i < N; i++)
	{
		std::cin >> x;
		auto it = tree.find(x);
		if (it == tree.end())
		{
			std::cout << "-";
			it = tree.insert(x).first;
		}
		else
		{
			std::cout << "+";
		}

		auto nx = std::next(it);
		if (nx != tree.end())
		{
			std::cout << " " << *nx << std::endl;
		}
		else
		{
			std::cout << " -" << std::endl;
		}
	}

	return 0;
}
