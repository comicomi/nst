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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "zaposleni")
@NamedQueries({
    @NamedQuery(name = "Zaposleni.findAll", query = "SELECT z FROM Zaposleni z"),
    @NamedQuery(name = "Zaposleni.findBySifraZaposlenog", query = "SELECT z FROM Zaposleni z WHERE z.sifraZaposlenog = :sifraZaposlenog"),
    @NamedQuery(name = "Zaposleni.findByIme", query = "SELECT z FROM Zaposleni z WHERE z.ime = :ime"),
    @NamedQuery(name = "Zaposleni.findByPrezime", query = "SELECT z FROM Zaposleni z WHERE z.prezime = :prezime"),
    @NamedQuery(name = "Zaposleni.findByAdresa", query = "SELECT z FROM Zaposleni z WHERE z.adresa = :adresa"),
    @NamedQuery(name = "Zaposleni.findByKorisnickoIme", query = "SELECT z FROM Zaposleni z WHERE z.korisnickoIme = :korisnickoIme"),
    @NamedQuery(name = "Zaposleni.findByKorisnickaSifra", query = "SELECT z FROM Zaposleni z WHERE z.korisnickaSifra = :korisnickaSifra"),
    @NamedQuery(name = "Zaposleni.login", query = "SELECT z FROM Zaposleni z WHERE z.korisnickoIme = :korisnickoIme AND z.korisnickaSifra = :korisnickaSifra")})
public class Zaposleni implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraZaposlenog")
    private Integer sifraZaposlenog;
    @Size(max = 20)
    @Column(name = "ime")
    private String ime;
    @Size(max = 30)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresa")
    private String adresa;
    @Size(max = 20)
    @Column(name = "korisnickoIme")
    private String korisnickoIme;
    @Size(max = 20)
    @Column(name = "korisnickaSifra")
    private String korisnickaSifra;
    @JoinColumn(name = "ptt", referencedColumnName = "ptt")
    @ManyToOne(optional = false)
    private Grad ptt;
    @JoinColumn(name = "sifraZvanja", referencedColumnName = "sifraZvanja")
    @ManyToOne(optional = false)
    private Zvanje sifraZvanja;
    @JoinColumn(name = "sifraTitule", referencedColumnName = "sifraTitule")
    @ManyToOne(optional = false)
    private Titula sifraTitule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposleni")
    private List<Komisija> komisijaList;

    public Zaposleni() {
    }

    public Zaposleni(Integer sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public Zaposleni(Integer sifraZaposlenog, String adresa) {
        this.sifraZaposlenog = sifraZaposlenog;
        this.adresa = adresa;
    }

    public Integer getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(Integer sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    public Grad getPtt() {
        return ptt;
    }

    public void setPtt(Grad ptt) {
        this.ptt = ptt;
    }

    public Zvanje getSifraZvanja() {
        return sifraZvanja;
    }

    public void setSifraZvanja(Zvanje sifraZvanja) {
        this.sifraZvanja = sifraZvanja;
    }

    public Titula getSifraTitule() {
        return sifraTitule;
    }

    public void setSifraTitule(Titula sifraTitule) {
        this.sifraTitule = sifraTitule;
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
        hash += (sifraZaposlenog != null ? sifraZaposlenog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposleni)) {
            return false;
        }
        Zaposleni other = (Zaposleni) object;
        if ((this.sifraZaposlenog == null && other.sifraZaposlenog != null) || (this.sifraZaposlenog != null && !this.sifraZaposlenog.equals(other.sifraZaposlenog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }
    
}
