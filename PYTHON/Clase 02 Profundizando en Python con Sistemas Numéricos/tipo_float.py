# Profundizando en el tipo float
a = 3.0 # automaticamente es un float, por sus decimales
print(f"a: {a}")
# para determinar la cantidad de decimales a visualizar podemos usar:
print(f"a_ {a:.2f}")

# Constructor de tipo float -> puede recibir int y str
a = float(10) # Le pasamos un tipo entero (int)
print(f"a: {a}") # paso a ser un tipo float
a = float("10") # Le pasamos un tipo texto (str)
print(f"a: {a}")

# Notacion exponencial (Valores positivos o negativos)
a = 3e5 # al agregar la "e" determina un exponencial
print(f"a: {a}")

a = 3e-5
print(f"a: {a}")
print(f"a: {a:.5f}") # De esta forma podemos visualizar los ceros

# Cualquier calculo que incluya un float, TODO CAMBIA A FLOAT

a = 4.0 + 5
print(a)
print(type(a))

