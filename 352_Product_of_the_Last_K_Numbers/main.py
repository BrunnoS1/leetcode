class ProductOfNumbers(object):
#products[n] contains the product of the first n elements added to the stream
#product is the product of all the elements currently in the stream
#when new number is added, update current product and append it to products
#when getProduct is called, return the last product divided by the element at -1-k
#this will give the product of the last k elements

#example
#stream = [2,3,4,4,3]
#products = [2,6,24,96,288]
#getProduct(3) will return 288 / 6 = 48 || last 3 elements are 3,4,4, which's product is 48 
#in this case, 288 is products[-1] and 6 is products[-4] (products[-1-k])

#if a 0 is added, products and product reset because it would cause a division by 0 if getProduct was called
    def __init__(self):
        self.products = []
        self.product = 1

    def add(self, num):
        """
        :type num: int
        :rtype: None
        """
        if num:
            self.product *= num
            self.products.append(self.product)
        else:
            self.products = []
            self.product = 1

    def getProduct(self, k):
        """
        :type k: int
        :rtype: int
        """
        if len(self.products) < k:
            #this happens when a 0 is added and products reset
            return 0
        elif k == len(self.products):
            return self.product
        else:
            return int(self.products[-1] / self.products[-1-k])
