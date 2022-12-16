from itertools import combinations
import numpy as np
import random
import datetime
import matplotlib.pyplot as plt

def generator():
    timea=[]
    n_items = [50]
    bag = 100
    for how_many_items in n_items:
        items_weight = []
        items_val = []
        items_priority = []
        for j in range(how_many_items):
            items_weight.append(random.randint(1,10))
            items_val.append(random.randint(1,15))
            items_priority.append(random.randint(0,1))
        print(items_priority,items_val,items_weight)
        start=datetime.datetime.now()
        separator(how_many_items,bag,items_weight,items_val,items_priority)
        end = datetime.datetime.now() - start
        print(end)
        timea.append(end.total_seconds())

    yline = np.array(timea)
    xline = np.array(n_items)
    plt.xlabel('ilość przedmiotów')
    plt.ylabel('czas [s]')
    plt.title("Wykres dla algorytmu dynamicznego dla stałej pojemności plecaka = 100")
    plt.plot(xline,yline)
    plt.show()

def separator(n,bag,items_weight,items_val,items_priority):
    n_elements_with_priority = 0
    max_weight_elements_with_priority = 0
    n_elements_without_priority = 0
    first_use_elements_weight = []
    first_use_elements_val = []
    else_elements_weight = []
    else_elements_val = []
    max_sum_brute = 0
    max_sum_dynamic = 0

    for i in range(n):
        if(items_priority[i]==1):
            first_use_elements_weight.append(items_weight[i])
            first_use_elements_val.append(items_val[i])
            n_elements_with_priority+=1
            max_weight_elements_with_priority+=items_weight[i]
            max_sum_brute+=items_val[i]
            max_sum_dynamic+=items_val[i]
        else:
            else_elements_weight.append(items_weight[i])
            else_elements_val.append(items_val[i])
            n_elements_without_priority+=1

    if(max_weight_elements_with_priority<=bag):
        print("Przedmioty konieczne w plecaku")
        bag=bag-max_weight_elements_with_priority
        #max_sum_brute+=brute_force(bag,else_elements_weight,else_elements_val,n_elements_without_priority)
        max_sum_dynamic+=dynamic(bag,else_elements_weight,else_elements_val,n_elements_without_priority)
    else:
        print("Nie udało zmieścić się wszystkich koniecznych przedmiotów w plecaku.")
        #max_sum_brute = brute_force(bag,items_weight,items_val,n)
        max_sum_dynamic = dynamic(bag,items_weight,items_val,n)
        
    print("Wynik algorytmu brute force: ", max_sum_brute)
    print("Wynik algorytmu dynamicznego: ", max_sum_dynamic)

def brute_force(bag,items_weight,items_val,n):
    if n==0 or bag==0:
        return 0
    if(items_weight[n-1]>bag):
        return brute_force(bag,items_weight,items_val,n-1)
    else:
        return max(items_val[n-1]+brute_force(bag-items_weight[n-1],items_weight,items_val,n-1),brute_force(bag,items_weight,items_val,n-1))

def dynamic(bag,items_weight,items_val,n):
    matrix = np.zeros((n+1, bag+1))
    for i in range(1,n+1):
        for j in range(1,bag+1):
            if items_weight[i-1] <= j:
                matrix[i][j] = max(matrix[i-1][j], matrix[i-1][j-items_weight[i-1]]+items_val[i-1])
            else:
                matrix[i][j]=matrix[i-1][j]
    return matrix[n][bag]



generator()

