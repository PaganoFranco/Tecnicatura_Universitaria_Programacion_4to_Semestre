// Se obtienen los elementos del DOM correspondientes al contenedor del modal y el overlay (fondo oscuro)
const modalContainer = document.getElementById("modal-container");
const modalOverlay = document.getElementById("modal-overlay"); // El nombre del ID ha sido corregido para coincidir con el HTML

// Se obtiene el botón del carrito que abrirá el modal
const cartBtn = document.getElementById("cart-btn");

// Función que se ejecuta al hacer clic en el botón del carrito para mostrar el modal
const displayCart = () => { 
    
    modalContainer.innerHTML = "";

    // Se muestran el contenedor del modal y el overlay configurando el estilo "display" a "block"
    modalContainer.style.display = "block";
    modalOverlay.style.display = "block";

    // Creación del encabezado del modal
    const modalHeader = document.createElement("div");

    // Creación del botón de cierre del modal (❌) y asignación de clase para darle estilo
    const modalClose = document.createElement("div");
    modalClose.innerText = "❌"; // Se establece el texto del botón de cierre
    modalClose.className = "modal-close";

    // Se añade el botón de cierre al encabezado del modal
    modalHeader.append(modalClose); 

    // Evento que permite cerrar el modal al hacer clic en el botón de cierre (❌)
    modalClose.addEventListener("click", () => {
        modalContainer.style.display = "none"; // Oculta el modal
        modalOverlay.style.display = "none";   // Oculta el overlay
    });

    // Creación del título del modal y asignación de la clase para estilos
    const modalTitle = document.createElement("div");
    modalTitle.innerText = "Cart"; // Se establece el texto del título
    modalTitle.className = "modal-title"; // Correcto, se asigna la clase para el estilo

    // Se añade el título al encabezado del modal
    modalHeader.append(modalTitle);

    // Finalmente, se añade el encabezado completo (título y botón de cierre) al contenedor del modal
    modalContainer.append(modalHeader);

    // Modal Body
    cart.forEach((product)=>{
        const modalBody = document.createElement("div");
        modalBody.className = "modal-body";
        modalBody.innerHTML = `
        <div class="product">
            <img class="product-img" src="${product.img}" /> 
            <div class="product-info"> 
                <h4>${product.productName}</h4> 
            </div>
        <div class="quantity"> 
            <span class="quantity-btn-decrease">-</span> 
            <span class="quantity-input">${product.quanty}</span> 
            <span class="quantity-btn-increase">+</span> 
        </div>
            <div class="price">${product.price * product.quanty}</div> 
            <div class="delete-product">❌</div> 
        </div>
        `;
        modalContainer.append(modalBody);

        const decrease = modalBody.querySelector(".quantity-btn-decrease");
        decrease.addEventListener("click", ()=> {
            if(product.quanty !== 1){
                product.quanty--;
                displayCart();
            }
        });
    
        const increase = modalBody.querySelector(".quantity-btn-increase");
        increase.addEventListener("click", ()=> {
            product.quanty++;
            displayCart();
        });

        //delete
        const deleteProduct = modalBody.querySelector(".delete-product");
        deleteProduct.addEventListener("click", ()=> {
            deleteCartProduct(product.id);
        });

    });

    //modal footer
    const total = cart.reduce((acc, el) => acc + el.price * el.quanty, 0);

    const modalFooter = document.createElement("div");
    modalFooter.className= "modal-footer";
    modalFooter.innerHTML = `
    <div class="total-price">Total: ${total}</div>
    `;
    modalContainer.append(modalFooter);

};

// Se añade un event listener al botón del carrito. Al hacer clic, se ejecutará la función displayCart.
cartBtn.addEventListener("click", displayCart);

const deleteCartProduct = (id) => {
    const foundId = cart.findIndex((element) => element.id === id);
    cart.splice(foundId, 1);
    displayCart();
};