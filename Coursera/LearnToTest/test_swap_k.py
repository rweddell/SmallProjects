import a1
import unittest


class TestSwapK(unittest.TestCase):
    """ Test class for function a1.swap_k. """

    def test_k_greater_than_half_len(self):
        """ Values of k cannot be greater than half length of list and should not result in error """
        test_list = [1, 2, 3, 4, 5, 6]
        a1.swap_k(test_list, 6)
        self.assertEqual(test_list, [1, 2, 3, 4, 5, 6])

    def test_value_swap(self):
        """ Subset of first k values should be swapped with last k subset of values and maintain order"""
        test_list = [1, 2, 3, 4, 5, 6]
        a1.swap_k(test_list, 2)
        self.assertEqual(test_list, [5, 6, 3, 4, 1, 2])

    def test_no_return_value(self):
        """ Function should not return value """
        actual = a1.swap_k([1, 2, 3, 4, 5, 6], 3)
        self.assertEqual(actual, None)


if __name__ == '__main__':
    unittest.main(exit=False)