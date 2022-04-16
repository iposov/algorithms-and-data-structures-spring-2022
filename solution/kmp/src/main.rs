use text_io::read;

fn prefix(s: &String) -> Vec<usize> {
    let mut ps = vec![0; s.len()];
    let cs: Vec<_> = s.bytes().collect();
    ps[0] = 0;
    for i in 1..s.len() {
        let mut k = ps[i - 1];
        while k > 0 && cs[i] != cs[k] {
            k = ps[k - 1];
        }
        if cs[i] == cs[k] {
            k += 1;
        }
        ps[i] = k;
    }
    ps
}

fn find(s: &String, sub: &String) -> Option<usize> {
    let s_len = s.len();
    let sub_len = sub.len();

    let fs = sub.to_owned() + "#" + s;
    let prefs = prefix(&fs);
    for i in 0..s_len {
        if prefs[sub_len + i + 1] == sub_len {
            return Some(i + 1 - sub_len);
        }
    }

    return None;
}

fn main() {
    let s1: String = read!("{}\n");
    let s2: String = read!("{}\n");
    let ans = find(&s1, &s2)
        .map(|x| x.to_string())
        .unwrap_or("-1".to_string());
    println!("{}", ans);
}
