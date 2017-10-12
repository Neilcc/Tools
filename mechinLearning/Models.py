__author__ = 'cc'

import numpy as np


def sigmod(z):
    return 1.0 / (1.0 + np.exp(-z))
