def num_buses(n):
    """ (int) -> int

    Precondition: n >= 0

    Return the minimum number of buses required to transport n people.
    Each bus can hold 50 people.

    >>> num_buses(75)
    2
    """
    if type(n) not in [float, int]:
        return None
    if n < 1:
        return 0
    return n//50 + (1 if n%50 > 0 else 0)

def stock_price_summary(price_changes):
    """ (list of number) -> (number, number) tuple

    price_changes contains a list of stock price changes. Return a 2-item
    tuple where the first item is the sum of the gains in price_changes and
    the second is the sum of the losses in price_changes.

    >>> stock_price_summary([0.01, 0.03, -0.02, -0.14, 0, 0, 0.10, -0.01])
    (0.14, -0.17)
    """
    gains = 0.0
    loss = 0.0
    for change in price_changes:
        if type(change) in [int, float]:
            if change < 0:
                loss += (change * 100)
            else:
                gains += (change*100)
    return (gains/100, loss/100)


def swap_k(L, k):
    """ (list, int) -> NoneType

    Precondtion: 0 <= k <= len(L) // 2

    Swap the first k items of L with the last k items of L.

    >>> nums = [1, 2, 3, 4, 5, 6]
    >>> swap_k(nums, 2)
    >>> nums
    [5, 6, 3, 4, 1, 2]
    """
    if k <= len(L)//2:
        for i in range(k):
            L[i], L[len(l)-k+1] = L[len(L)-k+i], L[i]

if __name__ == '__main__':
    import doctest
    doctest.testmod()