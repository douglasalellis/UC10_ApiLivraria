package br.senac.sp.livraria.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import br.senac.sp.livraria.model.Editora;
import br.senac.sp.livraria.service.EditoraService;

@RestController
@RequestMapping("/v1/api/editoras")
public class EditoraController {

    private final EditoraService service;

    public EditoraController(EditoraService service) {
        this.service = service;
    }

    @PostMapping
    public Editora salvar(@RequestBody Editora editora) {
        return service.salvar(editora);
    }

    @GetMapping
    public List<Editora> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Editora buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Editora atualizar(@PathVariable Long id, @RequestBody Editora editora) {
        return service.atualizar(id, editora);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    // Requisito: Consulta de editoras por domínio do site
    @GetMapping("/filtrar-site")
    public List<Editora> buscarPorDominio(@RequestParam String dominio) {
        return service.buscarPorDominioSite(dominio);
    }

    // Requisito: Lista ordenada em ordem crescente pelo nome
    @GetMapping("/ordenadas")
    public List<Editora> listarOrdenadas(String nome) {
        return service.listarOrdenadasPorNome(nome);
    }
}