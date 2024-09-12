class SaleData:
    def __init__(self, saleidp, quantityp ) -> None:
        pass
        self.saleid = saleidp
        self.quantity = quantityp

mynode = SaleData("ABC", 2)
print(mynode.quantity)