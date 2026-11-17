package br.senac.sp.livraria.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import br.senac.sp.livraria.model.Livro;
import br.senac.sp.livraria.service.LivroService;

@RestController
@RequestMapping("/v1/api/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    // Cadastrar
    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return service.salvar(livro);
    }

    // Listar (chamando listarLivros() que existe no seu Service)
    @GetMapping
    public List<Livro> listar() {
        return service.listarLivros();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Atualizar
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id); // Garante que o ID da URL é o mesmo do objeto
        return service.atualizar(livro);
    }

    // Excluir
    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id) {
        return service.excluir(id);
    }
}