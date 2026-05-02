const categorySelect = document.getElementById("categorySelect");
const productList = document.getElementById("productList");
const emptyMsg = document.getElementById("emptyMsg");

categorySelect.addEventListener("change", function () {
    const selected = categorySelect.value;
    productList.innerHTML = "";
    emptyMsg.style.display = "none";

    if (!selected) return;

    const products = JSON.parse(localStorage.getItem("glamBagProducts")) || [];
    const filtered = products.filter(p => p.category === selected);

    if (filtered.length === 0) {
        emptyMsg.textContent = "No products found in this category.";
        emptyMsg.style.display = "block";
        return;
    }

    filtered.forEach(function (product) {
        const realIndex = products.findIndex(p =>
            p.name === product.name &&
            p.category === product.category &&
            p.expiryMonth === product.expiryMonth &&
            p.expiryYear === product.expiryYear
        );

        const card = document.createElement("div");
        card.className = "product-card";
        card.innerHTML = `
            <div class="product-info">
                <p class="product-name">${product.name}</p>
                <p class="product-date">Expires: ${String(product.expiryMonth).padStart(2, '0')}/${product.expiryYear}</p>
            </div>
            <button class="delete-btn" data-index="${realIndex}">Remove</button>
        `;
        productList.appendChild(card);
    });

    productList.querySelectorAll(".delete-btn").forEach(function (btn) {
        btn.addEventListener("click", function () {
            const index = parseInt(btn.getAttribute("data-index"));
            const allProducts = JSON.parse(localStorage.getItem("glamBagProducts")) || [];
            allProducts.splice(index, 1);
            localStorage.setItem("glamBagProducts", JSON.stringify(allProducts));
            categorySelect.dispatchEvent(new Event("change"));
        });
    });
});