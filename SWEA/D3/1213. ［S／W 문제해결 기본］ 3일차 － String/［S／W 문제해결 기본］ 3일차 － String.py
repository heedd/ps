for test_case in range(1, 11) :
    t = input()
    w = input().rstrip()
    s = input().rstrip()

    print('#'+str(test_case), s.count(w))