

package br.senac.sp.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.senac.sp.livraria.model.Categoria;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {

}


