document.addEventListener("DOMContentLoaded", () =>
{
    loadPage();
})

function loadPage()
    {
    const container = document.getElementById("product-container");

    container.innerHTML = "";

    const category = document.getElementById("category");

    category.addEventListener("change", (event) => {
                               const selectedValue = event.target.value;

    if(selectedValue){
    const url = `/products/category/${selectedValue}`;

        fetch(url).then(response =>
        {
        if(response.status === 200)
        {
        return response.text();
        }
        throw new Error(response);
        }).then(data => {
        container.innerHTML = data;
        }).catch(error => {
        console.log(error)
        });
        }
    });
    }