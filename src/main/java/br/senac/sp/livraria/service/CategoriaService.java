
package br.senac.sp.livraria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.sp.livraria.model.Categoria;
import br.senac.sp.livraria.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    // Cadastrar
    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    // Listar todas
    public List<Categoria> listar() {
        return repository.findAll();
    }

    // Buscar por ID
    public Categoria buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada"));
    }

    // Atualizar
    public Categoria atualizar(Long id, Categoria dados) {

        Categoria categoria = buscarPorId(id);

        categoria.setNome(dados.getNome());

        return repository.save(categoria);
    }

    // Excluir
    public void excluir(Long id) {
        Categoria categoria = buscarPorId(id);
        repository.delete(categoria);
    }
}
