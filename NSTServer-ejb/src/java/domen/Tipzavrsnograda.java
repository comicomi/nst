/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MilicaJelica
 */
@Entity
@Table(name = "tipzavrsnograda")
@NamedQueries({
    @NamedQuery(name = "Tipzavrsnograda.findAll", query = "SELECT t FROM Tipzavrsnograda t"),
    @NamedQuery(name = "Tipzavrsnograda.findBySifraTipaZavrsnogRada", query = "SELECT t FROM Tipzavrsnograda t WHERE t.sifraTipaZavrsnogRada = :sifraTipaZavrsnogRada"),
    @NamedQuery(name = "Tipzavrsnograda.findByNaziv", query = "SELECT t FROM Tipzavrsnograda t WHERE t.naziv = :naziv")})
public class Tipzavrsnograda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraTipaZavrsnogRada")
    private Integer sifraTipaZavrsnogRada;
    @Size(max = 20)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(mappedBy = "sifraTipaZavrsnogRada")
    private List<Zavrsnirad> zavrsniradList;

    public Tipzavrsnograda() {
    }

    public Tipzavrsnograda(Integer sifraTipaZavrsnogRada) {
        this.sifraTipaZavrsnogRada = sifraTipaZavrsnogRada;
    }

    public Integer getSifraTipaZavrsnogRada() {
        return sifraTipaZavrsnogRada;
    }

    public void setSifraTipaZavrsnogRada(Integer sifraTipaZavrsnogRada) {
        this.sifraTipaZavrsnogRada = sifraTipaZavrsnogRada;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Zavrsnirad> getZavrsniradList() {
        return zavrsniradList;
    }

    public void setZavrsniradList(List<Zavrsnirad> zavrsniradList) {
        this.zavrsniradList = zavrsniradList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraTipaZavrsnogRada != null ? sifraTipaZavrsnogRada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipzavrsnograda)) {
            return false;
        }
        Tipzavrsnograda other = (Tipzavrsnograda) object;
        if ((this.sifraTipaZavrsnogRada == null && other.sifraTipaZavrsnogRada != null) || (this.sifraTipaZavrsnogRada != null && !this.sifraTipaZavrsnogRada.equals(other.sifraTipaZavrsnogRada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
