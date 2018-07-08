package lab.grupo.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lab.role.model.Permissao;
import lab.usuario.model.Usuario;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tb_grupo_usuario")
public class GrupoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "descricao", unique = true)
    private String descricao;
    @Column(name = "label", unique = true)
    private String label;
    @OneToMany(mappedBy = "grupoUsuario")
    private Set<Usuario> usuario;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_grupo_permissao", 
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_permissao"))
    private Set<Permissao> permissao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    public Set<Permissao> getPermissao() {
        return permissao;
    }

    public void setPermissao(Set<Permissao> permissao) {
        this.permissao = permissao;
    }
}
