import axios from "axios";
import { Category } from "../models/category";

class CategoryService
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/api/categories`

    async getCategories(): Promise<Category[]>
    {
        const response = await axios.get<Category[]>(this.baseUrl)
        return response.data
    }

    async getCategoryById(id: number): Promise<Category>
    {
        const response = await axios.get<Category>(`${this.baseUrl}/${id}`)
        return response.data;
    }

    async addCategory(category: Category): Promise<Category>
    {
        const response = await axios.post<Category>(this.baseUrl, category)
        return response.data
    }
}

const categoryService = new CategoryService()
export default categoryService