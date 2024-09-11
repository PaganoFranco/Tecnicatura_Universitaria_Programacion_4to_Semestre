from capa_datos_log.Usuario import Usuario
from logger_base import log
from capa_datos_log.usuario_dao import UsuarioDAO

opcion = None
while opcion != 5:
    print("Opciones: ")
    print("1. Listar Usuarios")
    print("2. Agregar Usuario")
    print("3. Modificar Usuario")
    print("4. Eliminar Usuario")
    print("5. Salir")
    opcion = int(input("Digite la opcion (1-5): "))

    if opcion == 1:
        usuarios = UsuarioDAO.seleccionar()
        for usuario in usuarios:
            log.info(usuario)
    elif opcion == 2:
        usuername_var = input("Digite el nombre de usuario: ")
        password_var = input("Digite su contraseña: ")
        usuario = Usuario(username=usuername_var, password=password_var)
        usuario_insertado = UsuarioDAO.insertar(usuario)
        log.info(f"Usuario {usuario_insertado} cargado exitosamente")
    elif opcion == 3:
        print("Digite los siguientes datos a modificar: ")
        id_usuario_var = int(input("Digite el id: "))
        username_var = input("Digite el nombre del usuario: ")
        password_var = input("Digite la contraseña del usuario: ")
        usuario = Usuario(id_usuario=id_usuario_var, username=usuername_var, password=password_var)
        usuario_actualizado = UsuarioDAO.actualizar(usuario)
        log.info(f"Usuario actualizado: {usuario_actualizado} ")
    elif opcion == 4:
        id_usuario_var = int(input("Digite el id del usuario a eliminiar: "))
        usuario = Usuario(id_usuario=id_usuario_var)
        usuario_eliminado = UsuarioDAO.eliminar(usuario_eliminado)
        log.info(f"Usuario eliminado: {usuario_eliminado}")


else:
    log.info("Salimos de la aplicación, Hasta la proxima!!")