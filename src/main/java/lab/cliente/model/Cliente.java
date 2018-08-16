package lab.cliente.model;

import lab.pessoa.model.Pessoa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa implements Serializable {

    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(columnDefinition="numeric(10,2) default '0.00'")
    @NumberFormat(pattern = "#,###.##")
    private double credito;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
}
