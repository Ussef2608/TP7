package com.example.produits;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.Produit;
import com.example.produits.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitsApplicationTests {

    @Autowired
    ProduitRepository produitRepository;

    @Test
    void testCreateProduit() {
        Produit p = new Produit(null, "iphone X", 2200.5, new Date(),null);
        produitRepository.save(p);
    }
    @Test
    void testFindProduit() {
        Produit p = produitRepository.findById(1L).orElse(null);
        System.out.println(p);
    }
    @Test
    void testUpdateProduit() {
        Produit p = produitRepository.findById(1L).get();
        p.setPrixProduit(1999.99);
        produitRepository.save(p);
    }
    @Test
    void testDeleteProduit() {
        produitRepository.deleteById(1L);
    }
    @Test
    void testListerTousProduits() {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
    @Test
    public void testFindByNomProduit()
    {
        List<Produit> prods = produitRepository.findByNomProduit("iphone X");

        for (Produit p : prods)
        {
            System.out.println(p);
        }

    }
    @Test
    public void testFindByNomProduitContains ()
    {
        List<Produit> prods=produitRepository.findByNomProduitContains("iphone X");
        for (Produit p : prods)
        {
            System.out.println(p);
        } }

//    public void findByCategorieIdCat()
//    {
//        List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
//        for (Produit p : prods)
//        {
//            System.out.println(p);
//        }
//
//    }
    @Test
    public void testfindByNomPrix()
    {
        List<Produit> prods = produitRepository.findByNomPrix("iphone X", 1000.0);
        for (Produit p : prods)
        {
            System.out.println(p);
        }

    }
    @Test
    public void testfindByCategorie()
    {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);
        List<Produit> prods = produitRepository.findByCategorie(cat);
        for (Produit p : prods)
        {
            System.out.println(p);
        }

    }
    @Test
    public void testfindByOrderByNomProduitAsc()
    {
        List<Produit> prods =

                produitRepository.findByOrderByNomProduitAsc();
        for (Produit p : prods)
        {
            System.out.println(p);
        }

    }
    @Test
    public void testTrierProduitsNomsPrix()
    {
        List<Produit> prods = produitRepository.trierProduitsNomsPrix ();
        for (Produit p : prods)
        {
            System.out.println(p);
        }

    }

}
