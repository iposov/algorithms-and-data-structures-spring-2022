def main():
    bst = set()
    n = int(input())

    for _ in range(n):
        number = int(input())
        if number not in bst:
            bst.add(number)
            print('-')
        else:
            print('+')


if __name__ == '__main__':
    main()