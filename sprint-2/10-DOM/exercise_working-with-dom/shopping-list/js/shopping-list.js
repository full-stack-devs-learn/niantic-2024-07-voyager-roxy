// add pageTitle

// add groceries

const service = new ShoppingService();
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function displayListTitle() {
    const listTitle = document.getElementById("title");
    listTitle.textContent = service.getListName();
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
    function displayGroceries() {
    const groceries = service.getShoppingList();

    const groceryContainer = document.getElementById("shopping-list");

    groceries.forEach(grocery => {
        createGroceryDiv(grocery, groceryContainer);
    });
}

function createGroceryDiv(grocery, parent)
{
    const groceryDiv = document.createElement("div");
    groceryDiv.classList.add("list-item");

    if(grocery.isComplete){
        groceryDiv.classList.add("complete");
    }

    groceryDiv.textContent = grocery.title;

    parent.appendChild(groceryDiv);

    buildQuantityDiv(grocery, groceryDiv)
}

function buildQuantityDiv(grocery, parent)
{
    const quantityDiv = document.createElement("div");

    quantityDiv.classList.add("quantity-container");

    buildSpanElement(quantityDiv);

    const textContent = document.createTextNode(grocery.quantity);

    quantityDiv.appendChild(textContent);
    
    parent.appendChild(quantityDiv);
}

function buildSpanElement(parent)
{
    const spanElement = document.createElement("span");

    spanElement.classList.add("super");

    spanElement.textContent = "quantity";

    parent.appendChild(spanElement);
}






/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
    const groceries = document.querySelectorAll(".list-item");


    groceries.forEach(grocery => {
        grocery.classList.add("complete");
    });
}


displayListTitle();
displayGroceries();

