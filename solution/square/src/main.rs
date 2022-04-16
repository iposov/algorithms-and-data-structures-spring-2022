#![feature(destructuring_assignment)]

use text_io::{read, scan};

fn read_pair_i32() -> (i32, i32) {
    let a: i32;
    let b: i32;
    scan!("{} {}", a, b);
    (a, b)
}

fn main() {
    let n: usize = read!("{}\n");

    let mut sum: i32 = 0;

    let (x_first, y_first) = read_pair_i32();
    let (mut x_prev, mut y_prev) = (x_first, y_first);

    let mut x: i32 = 0;
    let mut y: i32 = 0;
    for _ in 1..n {
        (x, y) = read_pair_i32();
        sum += (x_prev + x) * (y - y_prev);
        x_prev = x;
        y_prev = y;
    }
    sum += (x_first + x) * (y_first - y);
    let sum = (sum.abs() as f32) / 2.0;
    println!("{:.1}", sum);
}
