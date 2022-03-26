use text_io::scan;

struct Dsu {
    parent: Vec<usize>,
    rank: Vec<usize>,
}

impl Dsu {
    fn new(size: usize) -> Self {
        Self {
            parent: (0..size).collect(),
            rank: vec![0; size as usize],
        }
    }

    fn union(&mut self, a: usize, b: usize) -> bool {
        let a_par = self.find_set(a);
        let b_par = self.find_set(b);
        if a_par == b_par {
            return false;
        }

        if self.rank[a_par] < self.rank[b_par] {
            self.parent[b_par] = a_par;
        } else {
            self.parent[a_par] = b_par;
        }

        if self.rank[a_par] == self.rank[b_par] {
            self.rank[a_par] += 1;
        }

        true
    }

    fn find_set(&mut self, v: usize) -> usize {
        if v == self.parent[v] {
            v
        } else {
            let p = self.find_set(self.parent[v]);
            self.parent[v] = p;
            p
        }
    }
}

fn main() {
    let n: usize;
    let k: usize;
    scan!("{} {}\n", n, k);

    let mut s = Dsu::new(n);
    for _ in 0..k {
        let a: usize;
        let b: usize;
        scan!("{} {}\n", a, b);

        let res = if !s.union(a, b) {
            "YES"
        } else {
            "NO"
        };
        println!("{}", res);
    }
}


