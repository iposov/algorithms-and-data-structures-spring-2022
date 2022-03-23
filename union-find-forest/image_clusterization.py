import cProfile

import uff


def count_islands_quadratic_memory(m, n, lines_sequence):
    u = uff.UFF(m * n)
    islands = 0
    upper_line = '.' * n
    point_index = 0
    for line in lines_sequence:
        left_symbol = '.'
        for symbol, upper_symbol in zip(line, upper_line):
            set_of_symbol = point_index #  u.find(point_index)
            if symbol == '#':
                islands += 1
                if left_symbol == '#':
                    set_of_left_symbol = u.find(point_index - 1)
                    if set_of_left_symbol != set_of_symbol:
                        islands -= 1
                        set_of_symbol = u.union(point_index, point_index - 1)
                if upper_symbol == '#':
                    set_of_upper_symbol = u.find(point_index - n)
                    if set_of_upper_symbol != set_of_symbol:
                        islands -= 1
                        u.union(point_index, point_index - n)

            left_symbol = symbol
            point_index += 1
        upper_line = line

    return islands


if __name__ == '__main__':
    """
    print(count_islands_quadratic_memory(4, 5, [
        '.##.#',
        '.##..',
        '.#..#',
        '.##..',
    ]))
    print(count_islands_quadratic_memory(4, 5, [
        '#####',
        '#..##',
        '#...#',
        '#####'
    ]))
    print(count_islands_quadratic_memory(10, 10, [
        '##########',
        '#........#',
        '#.######.#',
        '#.#....#.#',
        '#.#.##.#.#',
        '#.#.##.#.#',
        '#.#....#.#',
        '#.######.#',
        '#........#',
        '##########'
    ]))
    """

    # with open('6.in', mode='r') as f:
    with open('12/12.in', mode='r') as f:
        print("loading lines")
        lines = [line.strip() for line in f if line.strip() != 0]
        print("--------")
        cProfile.run("print(count_islands_quadratic_memory(3000, 4000, lines))")
        # print(count_islands_quadratic_memory(3000, 4000, lines))
        # print(count_islands_quadratic_memory(20, 20, lines))
        print("--------")
