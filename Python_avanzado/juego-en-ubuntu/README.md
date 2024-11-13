#Game project
Para correr el juego se deben seguir las instrucciones en terminal

```sh
cd game
python3 main.py

A jugar!



# Entorno Virtual en Python

<br>Comenzamos con el entorno virtual en Python, para ingresar al repo después de un tiempo tuve que hacer lo siguiente, abrí la terminal de Ubuntu desde window como administrador:<br>

``` sh
        mkdir py-project
        cd py-project
        git clone https://...
        cd python-pip
        code .
        git branch
        # Solo esta la rama main
        git branch second # Comenzamos a crear nuevas ramas
        git branch profe
        git branch # nombre de la rama  
        git status # Desde la rama main ya hay camvio para comitear
        git add .
        git commit -m "Agrego el archivo txt de las clases"
        git push origin main #Surge un problema con el token
        # Se debe entrar en GitHub settings - Developer settings - Personal Access tokens - token classic 
        # Se genera escribiendo las notas de que trabajo se va a tratar y se debe tildar cuanto tiempo de duracion
        # tendra el token y tildar los permisos, generar y por ultimo el token
        git pull origin main
        usuario: # colocar usuario
        password: # colocar token que hemos creado
```

# Archivo requerements.txt

<br> Vamos a ver este archivo, este gestiona todas las dependencias y en que versiones se necesitan, vamos a dejar aqui
los comandos para que alguien logre contribuir en este protecto, los comando son los siguientes:  <br>

```sh
    git clone htttps://...
    cd app
    python3 -m venv env # Se debe crear el entorno virtual, este no se comparte desde Githib
    source env/bin/activate # activamos el entorno en linux
    venv/Script/activate #Activamos el entorno en window
    pip3 install -r requierements.txt #Instala las dependencias el -r significa reutilizar
    python 3 main.py # Ejecutamos el programa 
```