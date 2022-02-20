use text_io::read;

fn check(arr: &Vec<i32>, k: i32, x: i32) -> bool {
    let mut cur_seg = arr[0] + x;
    let mut total_segs = 1;
    for &point in arr {
        if point > cur_seg {
            if total_segs == k {
                return false;
            }
            total_segs += 1;
            cur_seg = point + x;
        }
    }
    true
}

fn main() {
    let n: usize = read!("{}\n");
    let k: i32 = read!("{}\n");
    let mut arr = Vec::<i32>::with_capacity(n);

    for _ in 0..n {
        let a = read!();
        arr.push(a);
    }

    let mut left = 0i32;
    let mut right = arr.last().unwrap() - arr[0] + 1;
    while right - left > 1 {
        let mid = (left + right) / 2;
        if check(&arr, k, mid) {
            right = mid;
        } else {
            left = mid;
        }
    }
    println!("{}", right);
}
