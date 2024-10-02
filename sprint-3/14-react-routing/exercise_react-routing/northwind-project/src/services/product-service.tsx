import axios from "axios";
import { Product } from "../models/product";

class ProductService
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}`

    async getProducts(): Promise<Product[]>
    {
        const response = await axios.get<Product[]>(`${this.baseUrl}/products`)
        return response.data
    }

    async getProductById(id: number): Promise<Product>
    {
        const response = await axios.get<Product>(`${this.baseUrl}/api/products/${id}`)
        return response.data
    }

    async addProduct(product: Product): Promise<Product>
    {
        const response = await axios.post<Product>(`${this.baseUrl}/products`, product)
        return response.data
    }

    async editCategory(product: Product): Promise<void>
    {
        const url = `${this.baseUrl}/api/products/${product.productId}`
        await axios.put<void>(url, product)
    }

}

const productService = new ProductService()
export default productService