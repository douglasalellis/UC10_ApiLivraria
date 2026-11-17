
package br.senac.sp.livraria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.senac.sp.livraria.model.Categoria;
import br.senac.sp.livraria.service.CategoriaService;

@RestController
@RequestMapping("/v1/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    // Cadastrar
    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return service.salvar(categoria);
    }

    // Listar
    @GetMapping
    public List<Categoria> listar() {
        return service.listar();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Atualizar
    @PutMapping("/{id}")
    public Categoria atualizar(
            @PathVariable Long id,
            @RequestBody Categoria categoria) {

        return service.atualizar(id, categoria);
    }

    // Excluir
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
