from capa_datos_log.Usuario import Usuario
from capa_datos_log.cursor_def_pool import CursorDelPool
import logging as log


class UsuarioDAO:
    """
    DAO -> Data Acces Object - para tabla de usuario
    CRUD -> Create - Read - Update - Delete
    """

    _SELECT = "SELECT * FROM usuario ORDER BY id_usuario"
    _INSERTAR = "INSERT INTO usuario(username, password) VALUES (%s, %s)"
    _ACTUALIZAR = "UPDATE usuario SET username=%s, password=%s WHERE id_usuario=%s"
    _ELIMINAR = "DELETE FROM usuario WHERE id_usuario=%s"

    @classmethod
    def seleccionar(cls):
        with CursorDelPool() as cursor:
            log.debug('Seleccinando usuarios')
            cursor.execute(cls._SELECT)
            registros = cursor.fetchall()
            usuarios = []
            for registro in registros:
                usuario = Usuario(registro[0], registro[1], registro[2])
                usuarios.append(usuario)
            return usuarios

    @classmethod
    def insertar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'Usuario a insertar: {usuario}')
            valores = (usuario.username, usuario.password)
            cursor.execute(cls._INSERTAR, valores)
            return cursor.rowcount

    @classmethod
    def actualizar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f"Usuario a actualizar: {usuario}")
            valores = (usuario.username, usuario.password, usuario.id_usuario)
            cursor.execute(cls._ACTUALIZAR, valores)
            return cursor.rowcount

    @classmethod
    def eliminar(cls, usuario):
        with CursorDelPool() as cursor:
           log.debug(f'Usuario a eliminar: {usuario}')
           valores = (usuario.id_usuario,)
           cursor.execute(cls._ELIMINAR, valores)
           return cursor.rowcount


if __name__ == "__main__":

    # Insertar usuario
    usuario = Usuario(username="Pagano", password="321")
    usuario_insertado = UsuarioDAO.insertar(usuario)
    log.debug(f"Usuario insertado: {usuario_insertado}")


    # Actualizar usuario
    usuario = Usuario(id_usuario=1, username="", password="369")
    usuario_modificador = UsuarioDAO.actualizar(usuario)
    log.debug(f"Usuario modificado: {usuario_modificador}")
    
        # Listar o seleccionar
    usuarios = UsuarioDAO.seleccionar()
    for usuario in usuarios:
        log.debug(usuario)
        
     
        # Eliminar usuario
    usuario = Usuario(id_usuario=1)
    usuario_eliminado = UsuarioDAO.eliminar(usuario)
    log.debug(f"Usuario: eliminado: {usuario_eliminado}")   

