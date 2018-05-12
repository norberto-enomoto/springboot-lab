package lab.cliente.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    /**
     * Helper: https://spring.io/guides/gs/relational-data-access/
     * https://stackoverflow.com/questions/6917906/return-type-for-jdbctemplate-queryforlistsql-object-classtype
     * https://docs.spring.io/spring/docs/3.0.x/reference/jdbc.html
     *
     * Docs for JdbcTemplate;
     */

}
