#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Point {
    int x, y;
};

struct Angle {
    int dx, dy;
};

bool angEqual(const Angle & a1, const Angle & a2) {
    if (a1.dx == 0 && a2.dx == 0) {
        return (a1.dy < 0) == (a2.dy < 0);
    }
    return (a1.dy * 1ll * a2.dx) == (a1.dx * 1ll * a2.dy);
}

bool angLess(const Angle & a1, const Angle & a2) {
    if (a1.dx == 0 && a2.dx == 0) {
        return a1.dy < a2.dy;
    }
    return (a1.dy * 1ll * a2.dx) < (a1.dx * 1ll * a2.dy);
}

int binSearch(Angle a, const vector<Angle>& Angles, int size) {
    int result;
    int left, right, middle;
    left = 0;
    right = size - 1;
    while (true) {
        if (right - left <= 1) {
            result = left;
            break;
        }
        middle = (left + right)/2;
        if (angEqual(a,Angles[middle])) {
            result = middle;
            break;
        }
        else if (angLess(a,Angles[middle])) {
            right = middle;
        }
        else {
            left = middle;
        }
    }

    return result;
}

int main() {
    /* ------Бинарный поиск по углу ------*/
    int n;
    cin >> n;

    vector<Point> points (n);
    int zero_id = 0;
    for (auto i = 0; i < n; i++) {
        cin >> points[i].x >> points[i].y;
        if (points[i].x < points[zero_id].x || points[i].x == points[zero_id].x && points[i].y < points[zero_id].y) {
            zero_id = i;
        }
    }

    Point zero = points[zero_id];
    rotate (points.begin(), points.begin()+zero_id, points.end());
    points.erase (points.begin());
    --n;

    vector<Angle> angles (n);
    for (auto i = 0; i < n; i++) {
        angles[i].dx = points[i].x - zero.x;
        angles[i].dy = points[i].y - zero.y;
    }

    int k;
    cin >> k;

    for (auto i = 0; i < k; i++) {
        Point p = {};
        cin >> p.x >> p.y;

        Angle a = {p.x - zero.x, p.y - zero.y};
        bool result = false;
        if (p.x == zero.x && p.y == zero.y) {
            result = true;
        }
        else if (!angLess(a,angles[0]) && !angLess(angles[n-1],a)) {
            auto j = binSearch(a, angles, n);
            long xd = p.x, yd = p.y;
            long xa = points[j].x, ya = points[j].y;
            long xb = points[(j + 1 == n ? 0 : j + 1)].x, yb = points[(j + 1 == n ? 0 : j + 1)].y;
            long xc = zero.x, yc = zero.y;
            result = (((xd - xa)*(yb-ya)-(yd-ya)*(xb-xa))*((xc - xa)*(yb-ya)-(yc-ya)*(xb-xa)) >= 0) &&
                    (((xd - xb)*(yc-yb)-(yd-yb)*(xc-xb))*((xa - xb)*(yc-yb)-(ya-yb)*(xc-xb)) >= 0) &&
                    (((xd - xc)*(ya-yc)-(yd-yc)*(xa-xc))*((xb - xc)*(ya-yc)-(yb-yc)*(xa-xc)) >= 0 );
        }
        cout << (result ? "IN" : "OUT") << endl;
    }

    return 0;
}