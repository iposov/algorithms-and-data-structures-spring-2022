use text_io::read;

#[derive(PartialEq)]
struct Node {
    val: u32,
    l: Option<Box<Node>>,
    r: Option<Box<Node>>,
}

impl Node {
    fn new(val: u32) -> Self {
        Self {
            val: val,
            l: None,
            r: None,
        }
    }

    fn insert(&mut self, new_val: u32) -> bool {
        if self.val == new_val {
            return false;
        }

        let target_node = if new_val < self.val {
            &mut self.l
        } else {
            &mut self.r
        };

        match target_node {
            Some(ref mut subnode) => subnode.insert(new_val),
            None => {
                let new_node = Node::new(new_val);
                let boxed_node = Some(Box::new(new_node));
                *target_node = boxed_node;
                true
            }
        }
    }
}

struct NaiveTree {
    root: Option<Box<Node>>,
}

impl NaiveTree {
    fn new() -> Self {
        Self { root: None }
    }

    fn insert(&mut self, new_val: u32) -> bool {
        match self.root {
            Some(ref mut n) => n.insert(new_val),
            None => {
                self.root = Some(Box::new(Node::new(new_val)));
                true
            }
        }
    }

    fn min_after(&self, val: u32) -> Option<u32> {
        let mut cur = &self.root;
        let mut suc: Option<u32> = None;
        while let Some(cur_n) = cur {
            let next = if cur_n.val > val {
                suc = Some(cur_n.val);
                &cur_n.l
            } else {
                &cur_n.r
            };
            cur = &next;
        }
        suc
    }
}

fn main() {
    let n: usize = read!("{}\n");

    let mut t = NaiveTree::new();
    for _ in 0..n {
        let a: u32 = read!();
        let contains = !t.insert(a);
        let min_after = t.min_after(a);

        let contains_sym = if contains { "+" } else { "-" };
        let min_after_sym = match min_after {
            Some(min_after_v) => min_after_v.to_string(),
            None => "-".to_string(),
        };

        println!("{} {}", contains_sym, min_after_sym);
    }
}
