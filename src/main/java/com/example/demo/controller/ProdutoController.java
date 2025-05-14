 package com.example.demo.controller;


import com.example.demo.model.Produto;
import com.example.demo.service.Produtoservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")

public class ProdutoController {
    private Produtoservice service;
    public ProdutoController(Produtoservice service) {
        this.service = service;
    }
    @GetMapping
    public List<Produto> listar() {
        return service.liataProdutos();
    }
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return service.salveProduto(produto);

    }
    @DeleteMapping("/id")
    public String remover (@PathVariable Long id) {
        return service.removerProduto(id)?
                "Remoção com sucesso": "Produto não encontrado";
    }


}
