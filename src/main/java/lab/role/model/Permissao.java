package lab.role.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lab.grupo.model.GrupoUsuario;

/**
 * INSERT INTO tb_permissao (id, label) VALUES (1, 'ADICIONAR'); 
 INSERT INTO tb_permissao (id, label) VALUES (2, 'EDITAR');
 INSERT INTO tb_permissao (id, label) VALUES (3, 'EXCLUIR'); 
 INSERT INTO tb_permissao (id, label) VALUES (4, 'LER');
 *
 * @author lucas
 */
@Entity
@Table(name = "tb_permissao")
public class Permissao implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "label", unique = true)
    private String label;
    @ManyToMany(mappedBy = "permissao")
    private Set<GrupoUsuario> gruposUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<GrupoUsuario> getGruposUsuario() {
        return gruposUsuario;
    }

    public void setGruposUsuario(Set<GrupoUsuario> gruposUsuario) {
        this.gruposUsuario = gruposUsuario;
    }
}