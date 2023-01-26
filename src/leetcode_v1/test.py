
def romanToInt(s: str) -> int:
    dub = s[:]
    #sym = 'IVXLCDM'
    sym = ['IV', 'IX', 'XL', 'XC', 'CD', 'CM', 'I', 'V', 'X', 'L', 'C', 'D', 'M']
    num = [4, 9, 40, 90, 400, 900, 1, 5, 10, 50, 100, 500, 1000]
    #sym_2 = ['IV', 'IX', 'XL', 'XC', 'CD', 'CM']
    #num_2 = [4, 9, 40, 90, 400, 900]
    summa = 0
    for i in range(len(sym) - 1):
        if sym[i] == s.find(sym[i]):
            



    for i in range(len(tmp)):
        for j in range(len(sym)):
            if tmp[i] == sym[j]: summa += num[j]
    return summa

print(romanToInt("MCMXCIV"))
