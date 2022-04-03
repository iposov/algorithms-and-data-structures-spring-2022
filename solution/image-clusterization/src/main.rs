use std::io::Read;
use text_io::scan;

#[derive(Debug)]
struct Dsu {
    parent: Vec<Option<usize>>,
    rank: Vec<usize>,
}

impl Dsu {
    fn new(size: usize) -> Self {
        Self {
            parent: vec![None; size],
            rank: vec![0; size as usize],
        }
    }

    fn init_element_at(&mut self, a: usize) {
        self.parent[a] = Some(a);
    }

    fn union(&mut self, a: usize, b: usize) -> bool {
        let a_par = self.find_set(a);
        let b_par = self.find_set(b);
        if a_par.is_none() || b_par.is_none() {
            return false;
        }

        let a_par = a_par.unwrap();
        let b_par = b_par.unwrap();

        if a_par == b_par {
            return false;
        }

        if self.rank[a_par] < self.rank[b_par] {
            self.parent[b_par] = Some(a_par);
        } else {
            self.parent[a_par] = Some(b_par);
        }

        if self.rank[a_par] == self.rank[b_par] {
            self.rank[a_par] += 1;
        }

        true
    }

    fn find_set(&mut self, v: usize) -> Option<usize> {
        match self.parent[v] {
            Some(u) => {
                if v == u {
                    Some(v)
                } else {
                    let p = self.find_set(u);
                    self.parent[v] = p;
                    p
                }
            },
            None => None,
        }
    }

    fn count(&mut self) -> usize {
        let n = self.parent.len();
        let mut elems = vec![0; n];
        for v in 0..n {
            match self.find_set(v) {
                Some(s) => elems[s] += 1,
                None => {},
            }
        }
        elems.iter().cloned().filter(|x| *x > 0).count()
    }
}

#[derive(PartialEq, Eq, Copy, Clone, Debug)]
enum Zone {
    None,
    Water,
    Ground,
}

fn main() {
    let m: i32; // Высота.
    let n: i32; // Ширина.
    scan!("{} {}\n", m, n);

    let mut prev_line = Vec::new();
    let mut curr_line = vec![Zone::None; n as usize];
    let mut lake = Dsu::new((n*m) as usize);

    let mut lines = 0;
    let mut i: usize = 0;
    for a in std::io::stdin().bytes() {
        let a = a.unwrap() as char;

        match a {
            '.' => {
                curr_line[i] = Zone::Water;
                i += 1;
            },
            '#' => {
                curr_line[i] = Zone::Ground;

                let j = i as i32;
                let cur_ind = (lines*n + j) as usize;
                let up_ind = (lines-1)*n + j;
                let left_ind = lines*n + (j - 1);

                lake.init_element_at(cur_ind);

                if lines > 0 && prev_line[i] == Zone::Ground {
                    lake.union(up_ind as usize, cur_ind);
                }
                if i > 0 && curr_line[i-1] == Zone::Ground {
                    lake.union(left_ind as usize, cur_ind);
                }

                i += 1;
            },
            '\n' => {
                prev_line = curr_line.clone();
                i = 0;
                lines += 1;
            },
            _ => panic!("invalid zone"),
        };
    }
    println!("{}", lake.count());
}


