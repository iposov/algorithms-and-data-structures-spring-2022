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
		if (!tree.count(x))
		{
			std::cout << "-";
			tree.insert(x);
		}
		else
		{
			std::cout << "+";
		}

		auto it = tree.find(x); 
		++it;
		if (it != tree.end())
		{
			std::cout << " " << *it << std::endl;
		}
		else
		{
			std::cout << " -" << std::endl;
		}
	}

	return 0;
}
