const fs = require("fs");

// Primero leemos el archivo.txt
function leer(ruta, cb) {
  fs.readFile(ruta, (err, data) => {
    cb(data.toString());
  });
}

// Segundo esvribimos el archivo1.txt creandolo
function escribir(ruta, contenido) {
  fs.writeFile(ruta, contenido, function (err) {
    if (err) {
      console.log("No se a podido escribir", err);
    } else {
      console.log("Se ha escrito correctamente");
    }
  });
}

// tercelo eliminamos el archivo1.txt
function borrar(ruta,cb){
    fs.unlink(ruta,cb); // Elimina de manera asincrina
}

borrar(`${__dirname}/archivo1.txt`, console.log);

// escribir(`${__dirname}/archivo1.txt`,'Reescrivimos el archivo',console.log);
// leer(`${__dirname}/archivo1.txt`,console.log); // Sistaxis ES6
