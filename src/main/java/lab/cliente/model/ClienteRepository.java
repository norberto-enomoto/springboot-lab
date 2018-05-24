package lab.cliente.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    static final String CUSTOM_QUERY = "SELECT c.id, c.nome_fantasia, p.razao_social, c.credito "
            + "FROM tb_cliente c INNER JOIN tb_pessoa p ON c.id = p.id";
    @Query(name = CUSTOM_QUERY, nativeQuery = true)
    public List<Cliente> findAllByOrderByIdAsc();

    /**
     * Helper: https://spring.io/guides/gs/relational-data-access/
     * https://stackoverflow.com/questions/6917906/return-type-for-jdbctemplate-queryforlistsql-object-classtype
     * https://docs.spring.io/spring/docs/3.0.x/reference/jdbc.html
     *
     * Docs for JdbcTemplate;
     */
}
