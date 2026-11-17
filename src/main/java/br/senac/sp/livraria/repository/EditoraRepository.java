package br.senac.sp.livraria.repository;

import br.senac.sp.livraria.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

    // Consulta de editoras cujo site pertença a um determinado domínio
    List<Editora> findBySiteContaining(String site);

    // Lista ordenada em ordem crescente pelo nome
    List<Editora> findAllByOrderByNomeAsc(String nome);
}