package bj.highfiveuniversity.datapulse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.datapulse.model.Product;
import bj.highfiveuniversity.datapulse.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




// pour dire que la classe est capable de renvoyer des réponses http
@RestController
// pour dire que le préfixe de toutes routes sera api/products
@RequestMapping("/api/products")
public class ProductController {

    // pour envoyer automatiquement puisqu'on ne peut pas instancier l'interface
    @Autowired
    // injecter le repository
    private ProductRepository productRepository ;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    // méthode pour créer un produit
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetail) {
        // identifier d'abord le produit à modifier
        Product product = productRepository.findById(id).orElseThrow();
        // remplacer les champs du produit par les nouvelles données que l'utilisateur veut
        product.setName(productDetail.getName());
        product.setPrice(productDetail.getPrice());
        // retourner le repository avec le produit avec les champs modifiés enregistrés dans la base de données
        return productRepository.save(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        // récupérer le produit à supprimer au travers de son id
        Product deleteproduct = productRepository.findById(id).orElseThrow();
        // supprimer le produit dans la base de données
        productRepository.delete(deleteproduct);
    }

    // tout supprimer
    public void deleteAllProducts(){
        productRepository.deleteAll();
    }


}
