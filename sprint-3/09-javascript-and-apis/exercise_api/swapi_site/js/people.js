// code here is the logic to manage the home (or people) page
let peopleService;
let currentPage = 1;

document.addEventListener('DOMContentLoaded', () => {
    peopleService = new PeopleService();

    // add logic to display a list of people from the SWAPI
    // note that it will defautl to displaying 10 people
    // at a time.

    // look at the API and discover how you can access
    // page 2 or page 3

    // can you add previous and next buttons to the page
    // to navigate between pages?
    loadPeople();


    document.getElementById('previous').addEventListener('click', () => 
        {
            if (currentPage > 1)
            {
                currentPage--;
                loadPeople();
            }
        });
    
        document.getElementById('next').addEventListener('click', () => 
            {
                    currentPage++;
                    loadPeople();
            });

})

async function loadPeople()
{
    try
    {
        const people = await peopleService.getPeople(currentPage);

        const peopleContainer = document.getElementById('people-container');
        peopleContainer.innerHTML = '';

        people.forEach(person => {
            const li = document.createElement('li');
            li.textContent = person.name;
            peopleContainer.appendChild(li);
        });
    }
    catch (error)
    {
        return error;
    }
}