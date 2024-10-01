import axios from "axios";
import { Product } from "../models/product";

class ProductService
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/products`

    async getProducts(): Promise<Product[]>
    {
        const response = await axios.get<Product[]>(this.baseUrl)
        return response.data
    }

}

const productService = new ProductService()
export default productService