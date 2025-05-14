package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.repository.Produtorepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Produtoservice {

    private final Produtorepository ropo;

    public Produtoservice(Produtorepository ropo) {
        this.ropo = ropo;
    }

    public List<Produto> liataProdutos() {
        return ropo.findAll();
    }

    public Produto salveProduto(Produto produto) {
        return ropo.save(produto);
    }

    public boolean removerProduto(Long id) {
        if (ropo.existsById(id)) {
            ropo.deleteById(id);
            return true;
        }
        return false;
    }

    // Atualizar o produto na tabela
    public Optional<Produto> buscaProduto(Long id, Produto novo) {
        return ropo.findById(id).map(p -> {
            p.setPreco(novo.getPreco());
            p.setNome(novo.getNome());
            p.setQtde(novo.getQtde());
            return ropo.save(p);
        });
    }
}
