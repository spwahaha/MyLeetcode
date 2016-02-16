def traverse(seq_len):
    idx = 1
    traversed = []

    while len(traversed) < seq_len:
        traversed.append(idx)
        traversed.append(2*len(traversed) + 1)
        idx += 2
        if idx > seq_len:
            idx -= seq_len


    sum = 0
    for idx in traversed:    
        i = traversed.pop()
        sum += (i * idx)

    print(sum)

traverse(7)