package lab.cliente.controller;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import lab.reports.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class ClienteReportService extends ReportGenerator {

    @Autowired
    private DataSource dataSource;

    public ByteArrayOutputStream clienteReport() throws SQLException, JRException {
        Connection connection = dataSource.getConnection();
        String sql = "SELECT c.id, p.razao_social, "
                + "c.nome_fantasia, c.credito, current_date "
                + "FROM tb_cliente c "
                + "INNER JOIN tb_pessoa p ON c.id = p.id "
                + "ORDER BY c.nome_fantasia ASC;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                return fromResultSet(rs);
            }
        }
    }
}
