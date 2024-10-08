from psycopg2 import pool
from logger_base import log
import sys


class Conexion:
    _DATABASE = "test_bd"
    _USERNAME = "postgres"
    _PASSWORD = "SuperAdmin"
    _DB_PORT = "5432"
    _HOST = "127.0.0.1"
    _MIN_CON = 1
    _MAX_CON = 5
    _pool = None

    @classmethod
    def obtenerConexion(cls):
        conexion = cls.obtenerPool().getconn()
        log.debug(f"Conexion obtenida del pool: {conexion}")
        return conexion

    @classmethod
    def obtenerCursor(cls):
        pass

    @classmethod
    def obtenerPool(cls):
        if cls._pool is None:
            try:
                cls._pool = pool.SimpleConnectionPool(cls._MIN_CON,
                                                      cls._MAX_CON,
                                                      host=cls._HOST,
                                                      user=cls._USERNAME,
                                                      password=cls._PASSWORD,
                                                      port=cls._DB_PORT,
                                                      database=cls._DATABASE)
                log.debug(f"Creacion del pool exitosa: {cls._pool}")
                return cls._pool
            except Exception as e:
                log.error(f"Ocurrio un error al obtener el pool: {e}")
                sys.exit()
        else:
            return cls._pool

    @classmethod
    def liberarConexion(cls, conexion):
        cls.obtenerPool().putconn(conexion)
        log.debug(f"Regresamos la conexion del pool: {conexion}")

    @classmethod
    def cerrarConexiones(cls):
        cls.obtenerPool().closeall()


if __name__ == "__main__":
    conexoin1 = Conexion.obtenerConexion()
    Conexion.liberarConexion(conexoin1)
    conexoin2 = Conexion.obtenerConexion()
    Conexion.liberarConexion(conexoin2)
    conexoin3 = Conexion.obtenerConexion()
    Conexion.liberarConexion(conexoin3)
    conexoin4 = Conexion.obtenerConexion()
    conexoin5 = Conexion.obtenerConexion()
    conexoin6 = Conexion.obtenerConexion()
