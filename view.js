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

function buildCard(product) {
    const status = getStatus(product.expiryMonth, product.expiryYear);
    return `
        <div class="product-card">
            <div class="product-info">
                <p class="product-name">${product.name}</p>
                <p class="product-date">Expires: ${String(product.expiryMonth).padStart(2, '0')}/${product.expiryYear}</p>
            </div>
            <span class="badge ${status.cls}">${status.label}</span>
        </div>
    `;
}

function buildSection(title, products) {
    if (products.length === 0) return "";
    return `
        <h2 class="category-title">${title}</h2>
        ${products.map(buildCard).join("")}
    `;
}

const products = JSON.parse(localStorage.getItem("glamBagProducts")) || [];

if (products.length === 0) {
    document.getElementById("emptyMsg").style.display = "block";
} else {
    const lip     = products.filter(p => p.category === "lip");
    const eye     = products.filter(p => p.category === "eye");
    const eyebrow = products.filter(p => p.category === "eyebrow");
    const skin    = products.filter(p => p.category === "skin");

    document.getElementById("lipSection").innerHTML     = buildSection("Lip", lip);
    document.getElementById("eyeSection").innerHTML     = buildSection("Eye", eye);
    document.getElementById("eyebrowSection").innerHTML = buildSection("Eyebrow", eyebrow);
    document.getElementById("skinSection").innerHTML    = buildSection("Skin", skin);
}