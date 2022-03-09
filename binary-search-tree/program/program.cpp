#include <iostream>
#include <set>

int main()
{
	std::set<int> tree;
	int N, x;

	std::cin >> N;

	for (int i = 0; i < N; i++)
	{
		std::cin >> x;
		if (!tree.count(x))
		{
			std::cout << "-"<<std::endl;
			tree.insert(x);
		}
		else
		{
			std::cout << "+" << std::endl;
		}
	}

	return 0;
}
