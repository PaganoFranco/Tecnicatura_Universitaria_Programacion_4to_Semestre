# Bool contiene los valores de True y False
# Los tipos numericos, es falso para el 0 (cero), true para los deams valores
valor = 0
resultado = bool(valor)
print(f"valor: {valor}, Resultado: {resultado}")


valor = 1
resultado = bool(valor)
print(f"valor: {valor}, Resultado: {resultado}")

# Tipo String -> False "", True otro valor
valor = "Hola"
resultado = bool(valor)
print(f"valor: {valor}, Resultado: {resultado}")

valor = ""
resultado = bool(valor)
print(f"valor: {valor}, Resultado: {resultado}")

# Tipo colecciones -> False para colecciones vacias
# Tipo colecciones -> True para todas las demas

# Lista
valor = []
resultado = bool(valor)
print(f"valor de una lista vacia: {valor}, Resultado: {resultado}")

valor = [1, 2, 3]
resultado = bool(valor)
print(f"valor de una lista con elementos: {valor}, Resultado: {resultado}")

# Tupla
valor = ()
resultado = bool(valor)
print(f"valor de una tupla vacia: {valor}, Resultado: {resultado}")

valor = (1, )
resultado = bool(valor)
print(f"valor de una tupla con elementos: {valor}, Resultado: {resultado}")

# Diccionario
valor = {}
resultado = bool(valor)
print(f"valor de un diccionario vacio: {valor}, Resultado: {resultado}")

valor = {"Nombre": "Franco", "Apellido": "Pagano"}
resultado = bool(valor)
print(f"valor de un diccionario con elementos: {valor}, Resultado: {resultado}")

# Sentencias de control con bool
if bool(0):
    print("Regresa verdadero")
else:
    print("Regresa falso")

# Ciclos
variable = 3
while variable:
    print("Regresa verdadero")
    break
else:
    print("Regresa falso")

