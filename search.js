const searchBtn = document.getElementById("searchBtn");
const searchInput = document.getElementById("searchInput");
const searchResult = document.getElementById("searchResult");
const today = new Date();

function getStatus(month, year) {
    if (year < today.getFullYear() || (year === today.getFullYear() && month < today.getMonth() + 1)) {
        return { label: "Expired", cls: "badge-expired" };
    } else if (year === today.getFullYear() && month === today.getMonth() + 1) {
        return { label: "Expiring", cls: "badge-expiring" };
    } else {
        return { label: "Good", cls: "badge-good" };
    }
}

searchBtn.addEventListener("click", function () {
    const query = searchInput.value.trim().toLowerCase();
    searchResult.innerHTML = "";

    if (!query) {
        searchResult.innerHTML = `<p class="not-found">Please enter a product name.</p>`;
        return;
    }

    const products = JSON.parse(localStorage.getItem("glamBagProducts")) || [];
    const found = products.filter(p => p.name.toLowerCase().includes(query));

    if (found.length === 0) {
        searchResult.innerHTML = `<p class="not-found">${searchInput.value} not found in your glam bag.</p>`;
        return;
    }

    found.forEach(function (product) {
        const status = getStatus(product.expiryMonth, product.expiryYear);
        const card = document.createElement("div");
        card.className = "product-card";
        card.innerHTML = `
            <div class="product-info">
                <p class="product-name">${product.name}</p>
                <p class="product-date">Expires: ${String(product.expiryMonth).padStart(2, '0')}/${product.expiryYear}</p>
                <p class="product-category">Category: ${product.category}</p>
            </div>
            <span class="badge ${status.cls}">${status.label}</span>
        `;
        searchResult.appendChild(card);
    });
});