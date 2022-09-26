from FootMeasureClass import FootMeasure

"""How a FootMeasure value is created"""
print("FootMeasure values being Created")
test_measure = FootMeasure(inches=24)
print(test_measure)

test_measure2 = FootMeasure(feet=8, inches=0)
print(test_measure2)

test_measure3 = FootMeasure(feet=4, inches=4)
print(test_measure3)

test_measure4 = FootMeasure(feet=2)
print(test_measure4)

"""The special method add() being used"""
print("\nThe special method add() being used")

print(test_measure, '+', test_measure2)
print(test_measure + test_measure2)

print(test_measure3, '+', test_measure4)
print(test_measure3 + test_measure4)

"""The special method == being used"""
print("\nThe special method == being used")

print(test_measure, '==', test_measure2)
print(test_measure == test_measure2)

print(test_measure3, '==', test_measure4)
print(test_measure3 == test_measure4)

print(test_measure2, '==', test_measure3)
print(test_measure2 == test_measure3)

print(test_measure, '==', test_measure4)
print(test_measure == test_measure4)

"""The special method != being used"""
print("\nThe special method != being used")

print(test_measure, '!=', test_measure2)
print(test_measure != test_measure2)

print(test_measure3, '!=', test_measure4)
print(test_measure3 != test_measure4)

print(test_measure2, '!=', test_measure3)
print(test_measure2 != test_measure3)

print(test_measure, '!=', test_measure4)
print(test_measure != test_measure4)

"""The special method < being used"""
print("\nThe special method < being used")

print(test_measure, '<', test_measure2)
print(test_measure < test_measure2)

print(test_measure3, '<', test_measure4)
print(test_measure3 < test_measure4)

print(test_measure2, '<', test_measure3)
print(test_measure2 < test_measure3)

print(test_measure, '<', test_measure4)
print(test_measure < test_measure4)

"""The special method <= being used"""
print("\nThe special method <= being used")

print(test_measure, '<=', test_measure2)
print(test_measure <= test_measure2)

print(test_measure3, '<=', test_measure4)
print(test_measure3 <= test_measure4)

print(test_measure2, '<=', test_measure3)
print(test_measure2 <= test_measure3)

print(test_measure, '<=', test_measure4)
print(test_measure <= test_measure4)

"""The special method > being used"""
print("\nThe special method > being used")

print(test_measure, '>', test_measure2)
print(test_measure > test_measure2)

print(test_measure3, '>', test_measure4)
print(test_measure3 > test_measure4)

print(test_measure2, '>', test_measure3)
print(test_measure2 > test_measure3)

print(test_measure, '>', test_measure4)
print(test_measure > test_measure4)

"""The special method >= being used"""
print("\nThe special method >= being used")

print(test_measure, '>=', test_measure2)
print(test_measure >= test_measure2)

print(test_measure3, '>=', test_measure4)
print(test_measure3 >= test_measure4)

print(test_measure2, '>=', test_measure3)
print(test_measure2 >= test_measure3)

print(test_measure, '>=', test_measure4)
print(test_measure >= test_measure4)


