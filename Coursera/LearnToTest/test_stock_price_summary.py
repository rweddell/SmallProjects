import a1
import unittest


class TestStockPriceSummary(unittest.TestCase):
    """ Test class for function a1.stock_price_summary. """

    def test_correct_sums(self):
        """ Result should be 2-tuple of (positives_sum, negatives_sum) """
        actual = a1.stock_price_summary([0.01, 0.03, -0.02, -0.14, 0, 0, 0.10, -0.01])
        self.assertEqual(actual, (0.14, -0.17))

    def test_empty_list(self):
        """ Result should be 2-tuple of zeros if given empty list. """
        actual = a1.stock_price_summary([])
        self.assertEqual(actual, (0.0, 0.0))

    def test_non_numeric(self):
        """ Non-numeric types should not result in error but should be passed over """
        actual = a1.stock_price_summary([0.1, '-0.1', '0.1', -0.1])
        self.assertEqual(actual, (0.1, -0.1))


if __name__ == '__main__':
    unittest.main(exit=False)