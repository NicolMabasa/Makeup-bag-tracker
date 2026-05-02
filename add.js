document.getElementById("addBtn").addEventListener("click", function () {

    const name = document.getElementById("productName").value.trim();
    const category = document.getElementById("categorySelect").value;
    const month = parseInt(document.getElementById("expiryMonth").value);
    const year = parseInt(document.getElementById("expiryYear").value);

    // Basic validation
    if (!name || !category || !month || !year) {
        alert("Please fill in all fields!");
        return;
    }
    if (month < 1 || month > 12) {
        alert("Please enter a valid month (1-12)!");
        return;
    }
    if (year < 1000 || year > 9999) {
        alert("Please enter a valid year (4 digits)!");
        return;
    }

     // Load existing products from localStorage
    const existing = JSON.parse(localStorage.getItem("glamBagProducts")) || [];

    if(existing.some(p => p.name.toLowerCase() === name.toLowerCase() && p.category.toLowerCase() === category.toLowerCase())){
        alert("A product with this name already exists!");
        return;
    }

    // Build the product object
    const product = {
        name: name,
        category: category,
        expiryMonth: month,
        expiryYear: year
    };


    // Add the new product
    existing.push(product);

    // Save back to localStorage
    localStorage.setItem("glamBagProducts", JSON.stringify(existing));

    alert(name + " has been added to your Glam Bag!");

    // Clear the form
    document.getElementById("productName").value = "";
    document.getElementById("categorySelect").value = "";
    document.getElementById("expiryMonth").value = "";
    document.getElementById("expiryYear").value = "";
});