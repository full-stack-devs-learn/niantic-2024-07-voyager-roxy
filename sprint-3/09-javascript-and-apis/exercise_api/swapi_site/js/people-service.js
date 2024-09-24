// define the SWAPI people service logic here

class PeopleService
{
    baseUrl = `${config.baseUrl}/people`

    // write a function that allows you to request a page
    // of 10 people- how can you request page 1,2, 3 etc?
    // consider using async/await with your axios request

    async getPeople(page = 1)
    {
        try
        {
            const response = await axios.get(`${this.baseUrl}?page=${page}&limit=10`)

            return response.data.results;
        }
        catch(error)
        {
            return error;
        }
    }

}