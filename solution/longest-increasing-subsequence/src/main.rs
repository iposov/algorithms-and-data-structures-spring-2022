use text_io::read;

fn binary_search(arr: &Vec<i32>, x: i32) -> i32 {
    let mut left = -1;
    let mut right = arr.len() as i32;
    while left < right - 1 {
        let middle = (left + right) / 2;

        if arr[middle as usize] < x {
            left = middle;
        } else {
            right = middle;
        }
    }
    right
}

fn find_lis(a: &Vec<i32>) -> Vec<i32> {
    let n = a.len();
    let mut d = vec![i32::MAX; n];
    let mut pos = vec![0 as i32; n+1];
    let mut prev = vec![0; n];
    let mut len: usize = 0;

    pos[0] = -1;
    d[0] = i32::MIN;
    for i in 0..n-1 {
        let j = binary_search(&d, a[i]) as usize;
        d[j] = a[i];
        pos[j] = i as i32;
        prev[i] = pos[j - 1];
        len = std::cmp::max(len, j);
    }

    let mut ans = Vec::new();
    let mut p = pos[len];
    while p != -1 {
        ans.push(a[p as usize]);
        p = prev[p as usize];
    }
    ans.reverse();
    return ans;
}

fn main() {
    let n: usize = read!("{}\n");

    let mut arr = Vec::with_capacity(n);
    for _ in 0..n {
        let a: i32 = read!();
        arr.push(a);
    }

    let lis = find_lis(&arr);
    println!("{}", lis.len());
    for item in lis {
        println!("{}", item);
    }
}
