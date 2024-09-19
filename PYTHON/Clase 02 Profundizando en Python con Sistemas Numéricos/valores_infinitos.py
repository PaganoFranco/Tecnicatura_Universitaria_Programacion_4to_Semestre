import math
from _pydecimal import Decimal

# manejo de valores infinitos
infinito_positivo = float("inf")
print(f"Infinito positivo: {infinito_positivo}")
print(f"Es infinito?: {math.isinf(infinito_positivo)}")

infinito_negativo = float("-inf")
print(f"Infinito positivo: {infinito_negativo}")
print(f"Es infinito?: {math.isinf(infinito_negativo)}")

# Modulo math
infinito_positivo = math.inf # asignamo el valor infinito desde el modulo math
print(f"Infinito positivo: {infinito_positivo}")
print(f"Es infinito?: {math.isinf(infinito_positivo)}")

infinito_negativo = -math.inf
print(f"Infinito positivo: {infinito_negativo}")
print(f"Es infinito?: {math.isinf(infinito_negativo)}")

# Modulo decimal
infinito_positivo = Decimal("Infinity")
print(f"Infinito positivo: {infinito_positivo}")
print(f"Es infinito?: {math.isinf(infinito_positivo)}")

infinito_negativo = Decimal("-Infinity")
print(f"Infinito positivo: {infinito_negativo}")
print(f"Es infinito?: {math.isinf(infinito_negativo)}")