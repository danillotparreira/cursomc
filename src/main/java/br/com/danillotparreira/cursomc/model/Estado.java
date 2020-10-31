package br.com.danillotparreira.cursomc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estado implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  @OneToMany(mappedBy = "estado")
  private List<Cidade> cidades = new ArrayList<>();

  public Estado() {}

  public Estado(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Estado(String nome) {
    this.nome = nome;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Estado id(Integer id) {
    this.id = id;
    return this;
  }

  public Estado nome(String nome) {
    this.nome = nome;
    return this;
  }

  public List<Cidade> getCidades() {
    return this.cidades;
  }

  public void setCidades(List<Cidade> cidades) {
    this.cidades = cidades;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Estado)) {
      return false;
    }
    Estado estado = (Estado) o;
    return Objects.equals(id, estado.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", nome='" + getNome() + "'" + "}";
  }
}
