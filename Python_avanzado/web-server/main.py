import store
from frasapi import FastAPI
from fastapi.responses import HTMLResponse

app = FastAPI() # Creamos nuestra primera instancia y con estem cremos nuestro primer recurso

#Ruta principal
@app.get('/') # Agregmos el decorador para decirle cual es la ruta
def grt_list(): # Va a devolver una lista
    return[1, 2, 3]

# Ruta secundaria
@app.get('/contact', response_class=HTMLResponse)
def get_list():
    return """
        <h1> Soy un sitio web </h1>
        <p> Soy un parrafo para que tu leas </p>
    """

def run():
    store.get_razas()

if __name__ == '__main__':
    run()