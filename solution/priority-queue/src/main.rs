use text_io::read;

struct PriorityQueue {
    len: usize,
    els: Vec<i32>,
}

impl PriorityQueue {
    fn new() -> Self {
        Self {
            len: 0,
            els: Vec::new(),
        }
    }

    fn len(&self) -> usize {
        self.len
    }

    fn get_parent_ind(&self, i: usize) -> usize {
        (i - 1) / 2
    }

    fn get_left_ind(&self, i: usize) -> usize {
        (2 * i) + 1
    }

    fn get_right_ind(&self, i: usize) -> usize {
        (2 * i) + 2
    }

    fn push(&mut self, e: i32) {
        self.els.push(e);
        self.sift_up(self.len());
        self.len += 1;
    }

    fn pop_max(&mut self) -> i32 {
        let max = self.els[0];
        self.els[0] = *self.els.last().unwrap();
        self.els.pop();

        self.len -= 1;

        self.sift_down(0);

        max
    }

    fn sift_up(&mut self, mut i: usize) {
        while i > 0 && self.els[self.get_parent_ind(i)] < self.els[i] {
            let pi = self.get_parent_ind(i);
            self.els.swap(i, pi);
            i = pi;
        }
    }

    fn sift_down(&mut self, mut i: usize) {
        let mut max_ind = i;
        loop {
            let l = self.get_left_ind(i);
            let r = self.get_right_ind(i);
            for u in [l, r] {
                if u < self.len() && self.els[u] > self.els[max_ind] {
                    max_ind = u;
                }
            }
            if i == max_ind {
                break;
            }
            self.els.swap(i, max_ind);
            i = max_ind;
        }
    }
}

fn main() {
    let n: usize = read!("{}\n");

    let mut q = PriorityQueue::new();
    for _ in 0..n {
        let a: String = read!();
        if a == "GET" {
            let max = q.pop_max();
            println!("{}", max);
        } else {
            let el = a.parse::<i32>().unwrap();
            q.push(el);
        }
    }
}

