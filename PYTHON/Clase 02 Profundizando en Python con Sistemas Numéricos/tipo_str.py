# Profucndizando en el tipo String
# Concatenacion automatica en Python

variable = " Pagano"
mensaje = "Hola " + "Franco" # El sigo de mas es innecesario usarlo siempre y cuando sean los dos string o esten estre ""
mensaje = "Hola ""Franco" + variable # en este caso a juntar con una variable si se utiliza el conectar
mensaje += ", Terminamos"
# print(mensaje)

# usamos la clase help que esta incluida en python (built-in), se usa para ayudar o documentar
help(str)