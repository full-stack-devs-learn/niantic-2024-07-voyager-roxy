let service;
let list = []

let allItemsIncomplete = true;


function displayListTitle() {
    const title = document.getElementById("title")
    title.textContent = service.getListName();
}


function displayShoppingList() {
    const parent = document.getElementById("shopping-list")

    list.forEach(item => {
        addListItem(item, parent);
    })
}

function addListItem(item, parent)
{
    const div = document.createElement("div")
    div.classList.add("list-item");
    if(item.isComplete)
    {
        div.classList.add("complete")
    }

    addItemTitle(item, div);
    addQuantity(item, div)

    parent.appendChild(div)
}

function addItemTitle(item, parent)
{
    const div = document.createElement("div")
    div.textContent = item.title;

    parent.appendChild(div);
}

function addQuantity(item, parent)
{
    const div = document.createElement("div");
    div.classList.add("quantity-container");

    const span = document.createElement("span");
    span.textContent = "quantity"
    span.classList.add("super");

    const text = document.createTextNode(item.quantity)

    div.appendChild(span)
    div.appendChild(text)

    parent.appendChild(div);
}


function markCompleted() {
    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
            item.classList.toggle("complete")
    })

    buttonToggle();
}

function markIndividualItem()
{
    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
        item.addEventListener('click', () => {
                if(!item.classList.contains("complete")){
                item.classList.add("complete")
                }
        });
        item.addEventListener('dblclick', () => {
            if(item.classList.contains("complete")){
            item.classList.remove("complete")
            }
    });
    })
}

function buttonToggle()
{
    const button = document.getElementById("allCompleteButton");
    allItemsIncomplete = !allItemsIncomplete;
    
    console.log(allItemsIncomplete);

    if(!allItemsIncomplete)
    {
        button.innerText = "Mark All Uncompleted"
    }
    else {
        button.innerText = "Mark All Completed"
    }
}

function submitItem(event)
{
    event.preventDefault();

    const itemName = document.getElementById("itemName").value;
    const quantity = document.getElementById("quantity").value;

    const grocery = {
        title: itemName,
        quantity: quantity,
        isComplete: false
    }

    list.push(grocery);

    const parent = document.getElementById("shopping-list");
    addListItem(grocery, parent);

    clearForm();
}

function clearForm()
{
    document.getElementById("itemName").value = "";
    document.getElementById("quantity").value = "";
}


// create the page load event here

document.addEventListener("DOMContentLoaded", () => {
    service = new ShoppingService();
    list = service.getShoppingList();

    displayListTitle();
    displayShoppingList();
    markIndividualItem();

    const button = document.getElementById("allCompleteButton");
    button.addEventListener("click", markCompleted);

    const form = document.querySelector("form");
    form.addEventListener('submit', submitItem);
});

