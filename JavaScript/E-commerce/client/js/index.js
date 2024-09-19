// Seleccionamos el contenedor donde se mostrarán los productos de la tienda
const shopContent = document.getElementById("shopContent");

// Inicializamos el carrito como un array vacío
const cart = []; 

// Recorremos el array de productos para mostrar cada uno en la página
productos.forEach((product) => {

    // Creamos un div que contendrá la información del producto
    const content = document.createElement("div");

    // Añadimos la estructura HTML al div, incluyendo la imagen, nombre y precio del producto
    content.innerHTML = `
        <img src="${product.img}">
        <h3>${product.productName}</h3>
        <p>${product.price} $</p>
    `;

    // Añadimos el div creado al contenedor principal "shopContent"
    shopContent.append(content);

    // Creamos un botón de compra para el producto
    const buyButton = document.createElement("button");
    buyButton.innerText = "Comprar"; // Definimos el texto del botón

    // Añadimos el botón de compra al div del producto
    content.append(buyButton);

    // Añadimos un evento para detectar clics en el botón "Comprar"
    buyButton.addEventListener("click", () => {
        // Cuando el botón es clicado, agregamos el producto al carrito
        cart.push({
            id: product.id, // El identificador del producto
            productName: product.productName, // El nombre del producto
            price: product.price, // El precio del producto
            quanty: product.quanty, // La cantidad del producto
            img: product.img, // La imagen del producto
        });

        // Mostramos el contenido actual del carrito en la consola para verificar los productos agregados
        console.log(cart);
    });

});
