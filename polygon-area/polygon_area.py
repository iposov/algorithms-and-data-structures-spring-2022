def area(points):
    segments_list = list(make_segments(points))
    area = 0.5 * abs(sum(x0 * y1 - x1 * y0
                         for ((x0, y0), (x1, y1)) in segments_list))
    return area


def make_segments(points):
    # делает лист tupl'ов-граней
    # из исходного списка точек и списка точек со сдвигом 1
    return zip(points, points[1:] + [points[0]])


vertex_count = int(input())
polygon = []
for i in range(vertex_count):
    a = input()
    polygon.append(tuple(int(el) for el in a.split(' ')))

print(round(area(polygon), 1))
