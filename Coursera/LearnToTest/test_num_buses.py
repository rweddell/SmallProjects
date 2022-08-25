import a1
import unittest


class TestNumBuses(unittest.TestCase):
    """ Test class for function a1.num_buses. """
    
    def test_fifty_or_less(self):
        """ Result should be 1 if number is less than 50. """
        actual = a1.num_buses(50)
        self.assertEqual(actual, 1)

    def test_num_is_fifty(self):
        """ Result should be 1 if number is 50. """
        actual = a1.num_buses(49)
        self.assertEqual(actual, 1)

    def test_greater_than_fifty(self):
        """ Result should be > 1 if number is greater than fifty. """
        actual = a1.num_buses(51)
        self.assertEqual(actual, 2)

    def test_num_is_zero(self):
        """ Result should be 0 if number is 0 """
        actual = a1.num_buses(0)
        self.assertEqual(actual, 0)

    def test_num_less_than_zero(self):
        """ Result should be 0 if number is less than 0 """
        actual = a1.num_buses(-1)
        self.assertEqual(actual, 0)

    def test_non_numeric_num(self):
        """ Result should return None if number is non-numeric"""
        actual = a1.num_buses("50")
        self.assertEqual(actual, None)



if __name__ == '__main__':
    unittest.main(exit=False)