use std::cmp::Ordering;

use text_io::read;

fn binary_search(arr: &Vec<i32>, x: i32) -> i32 {
    let mut left = 0i32;
    let mut right = (arr.len() - 1) as i32;
    while left <= right {
        let middle = (left + right) / 2;

        match arr[middle as usize].cmp(&x) {
            Ordering::Greater => right = middle - 1,
            Ordering::Less => left = middle + 1,
            Ordering::Equal => return middle,
        }
    }
    -1
}

fn main() {
    let n: usize = read!("{}\n");
    let mut arr = Vec::<i32>::with_capacity(n);

    for _ in 0..n {
        let a = read!();
        arr.push(a);
    }

    let k: usize = read!("{}\n");

    for _ in 0..k {
        let x = read!("{}\n");
        let pos = binary_search(&arr, x);
        println!("{}", pos);
    }
}
