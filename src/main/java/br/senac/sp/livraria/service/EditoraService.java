package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Editora;
import br.senac.sp.livraria.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    private final EditoraRepository repository;

    public EditoraService(EditoraRepository repository) {
        this.repository = repository;
    }

    public Editora salvar(Editora editora) {
        return repository.save(editora);
    }

    public List<Editora> listar() {
        return repository.findAll();
    }

    public Editora buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada com ID: " + id));
    }

    public Editora atualizar(Long id, Editora editoraAtualizada) {
        Editora editora = buscarPorId(id);
        editora.setNome(editoraAtualizada.getNome());
        editora.setSite(editoraAtualizada.getSite());
        return repository.save(editora);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    // Métodos específicos exigidos no trabalho
    public List<Editora> buscarPorDominioSite(String site) {
        return repository.findBySiteContaining(site);
    }

    public List<Editora> listarOrdenadasPorNome(String nome) {
        return repository.findAllByOrderByNomeAsc(nome);
    }
}