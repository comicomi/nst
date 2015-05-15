/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "ulogaclanakomisije")
@NamedQueries({
    @NamedQuery(name = "Ulogaclanakomisije.findAll", query = "SELECT u FROM Ulogaclanakomisije u"),
    @NamedQuery(name = "Ulogaclanakomisije.findBySifraUloge", query = "SELECT u FROM Ulogaclanakomisije u WHERE u.sifraUloge = :sifraUloge"),
    @NamedQuery(name = "Ulogaclanakomisije.findByNaziv", query = "SELECT u FROM Ulogaclanakomisije u WHERE u.naziv = :naziv")})
public class Ulogaclanakomisije implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraUloge")
    private Integer sifraUloge;
    @Size(max = 20)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sifraUloge")
    private List<Komisija> komisijaList;

    public Ulogaclanakomisije() {
    }

    public Ulogaclanakomisije(Integer sifraUloge) {
        this.sifraUloge = sifraUloge;
    }

    public Integer getSifraUloge() {
        return sifraUloge;
    }

    public void setSifraUloge(Integer sifraUloge) {
        this.sifraUloge = sifraUloge;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Komisija> getKomisijaList() {
        return komisijaList;
    }

    public void setKomisijaList(List<Komisija> komisijaList) {
        this.komisijaList = komisijaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraUloge != null ? sifraUloge.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ulogaclanakomisije)) {
            return false;
        }
        Ulogaclanakomisije other = (Ulogaclanakomisije) object;
        if ((this.sifraUloge == null && other.sifraUloge != null) || (this.sifraUloge != null && !this.sifraUloge.equals(other.sifraUloge))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
