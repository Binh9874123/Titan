def Kapr(num: int, dig:int, base:int):
    digList = list()
    dv = num
    for i in range(dig):
        dv, md = divmod(dv, base)
        digList.append(md)
     
    digList.sort()
    summ = 0
    for i in range(len(digList)):
        summ = summ*r+digList[i]
    min = summ 
    digList.sort(reverse=True)

    summ = 0
    for i in range(len(digList)):
        summ = summ*r+digList[i]
    max = summ
    summ = max - min
    
    return summ

# в систему base
def FromDec(num, base):
    symb = "0123456789ABCDEF"
    if num < base:
        return symb[num]
    else:
        return FromDec(num // base, base) + symb[num % base]


# числа Капрекара и максимальный цикл
def Finding(dig: int, base: int):
    t = 0
    prev_len = 0
    new_len = 0
    numbers = list()
    t_nums = list()
    n = '9'*dig
    for i in range(int(n)+1):
        while True:
            t = Kapr(i, dig, base)
            if t == i:
                if t in numbers:
                    break
                numbers.append(t)
                break
            elif t in t_nums:
                break
            i = t
            t_nums.append(t)
            prev_len += 1
        new_len = max(new_len, prev_len)
        prev_len = 0

    return numbers, new_len

#Исследование
dig = 5
base = 6           
file = open("result.txt", 'w')

for r in range(1, dig+1):
    for k in range(2, base+1):
        nums, length = Finding(k, r)
        for i in range(len(nums)):
            print(i)
            nums[i] = FromDec(nums[i], r)
        file.write("Система счисления: " + str(r) + " Количество разрядов: " + str(k) + " Постоянные Капрекара: " + str(nums) +"\nМаксимальная длина цикла: " + str(length) + "\n")

file.close()
print("end.")
