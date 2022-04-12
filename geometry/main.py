def get_coordinates_matrix(top_number: int):
    top_coors = []
    for i in range(top_number):
        current_top_str = input(
            'Input {number} top coordinate '.format(number=i + 1))
        current_top = [int(n) for n in current_top_str.split(' ')]
        top_coors.append(current_top)
    return top_coors


def get_first_y(matrix, i_row) -> int:
    if i_row + 1 > len(matrix) - 1:
        return matrix[0][1]
    return matrix[i_row + 1][1]


def get_second_y(matrix, i_row) -> int:
    if i_row - 1 < 0:
        return matrix[len(matrix) - 1][1]
    return matrix[i_row - 1][1]


def calculate_square(matrix: list):
    s = 0
    for i_row in range(len(matrix)):
        s += matrix[i_row][0] * (
            get_first_y(matrix, i_row) - get_second_y(matrix, i_row)
        )
    return 0.5 * abs(s)


#Если нужно записать в файл
#def output(value):
#    with open('1.out', 'w') as f:
#       f.write(str(value))


number = int(input('Input number '))
matrix = get_coordinates_matrix(number)
square = calculate_square(matrix)
#Запись в файл
#output(square)
print(square)
