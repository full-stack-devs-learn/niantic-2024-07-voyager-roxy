import './App.css'
import Header from './components/header/Header'
import '../node_modules/bootswatch/dist/morph/bootstrap.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Home from './components/home/Home'
import CategoriesList from './components/categories/categories-list/CategoriesList'
import CategoryDetails from './components/categories/category-details/CategoryDetails'
import CategoryEdit from './components/categories/category-edit/CategoryEdit'
import CategoryAdd from './components/categories/category-add/CategoryAdd'
import CategoriesPage from './components/categories/categories-page/CategoriesPage'
import ProductsPage from './components/products/product-page/ProductsPage'
import ProductSearch from './components/products/product-search/ProductSearch'
import ProductAdd from './components/products/product-add/ProductAdd'
import ProductEdit from './components/products/product-edit/ProductEdit'
import ProductDetails from './components/products/product-details/ProductDetails'


function App() {

  return (
    <Router>
      <Header />

      <main className='container mt-4'>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/categories' element={<CategoriesPage />} >
          <Route path='' element={<CategoriesList />} />
          <Route path=':categoryId' element={<CategoryDetails />} />
          <Route path='add' element={<CategoryAdd />} />
          <Route path=':categoryId/edit' element={<CategoryEdit />} />
        </Route>
        <Route path='/products' element={<ProductsPage />}>
          <Route path='' element={<ProductSearch />} />
          <Route path=':productId' element={<ProductDetails />} />
          <Route path='add' element={<ProductAdd />} />
          <Route path=':productId/edit' element={<ProductEdit/>} />
        </Route>

      </Routes>
      </main>
    </Router >
  )
}

export default App
