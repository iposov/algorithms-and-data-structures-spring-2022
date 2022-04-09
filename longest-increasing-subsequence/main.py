class Sequence:
    def __init__(self, n, seq):
        self.n = n
        self.seq = seq

    def get_subseq_len(self):
        F = []
        for i in range(self.n):
            F.append(1)
            for j in range(i):
                if self.seq[j] < self.seq[i] and F[j]+1 > F[i]:
                    F[i] = F[j] + 1

        return max(F)



if __name__ == "__main__":
    n = int(input())

    seq = []
    for i in range(n):
        seq.append(int(input()))

    sequence = Sequence(n, seq)
    print(sequence.get_subseq_len())
