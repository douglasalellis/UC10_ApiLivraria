

package br.senac.sp.livraria.service;
import br.senac.sp.livraria.model.Livro;
import br.senac.sp.livraria.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    //Construtor
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    //SALVAR LIVRO
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    //LISTAR LIVROS
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    //EXCLUIR LIVRO
    public boolean excluir(Long id) {

        Optional<Livro> livroExcluir =
                livroRepository.findById(id);

        if (livroExcluir.isPresent()) {

            livroRepository.deleteById(id);

            return true;
        }

        return false;
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElse(null);
    }

    //ATUALIZAR LIVRO
    public Livro atualizar(Livro novoLivro) {

        Optional<Livro> livroAtual =
                livroRepository.findById(novoLivro.getId());

        if (livroAtual.isPresent()) {

            return livroRepository.save(novoLivro);
        }

        return null;
    }
}
