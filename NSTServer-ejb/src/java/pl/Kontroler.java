/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;

import domen.Grad;
import domen.Kandidat;
import domen.Komisija;
import domen.Tipfajla;
import domen.Tipzavrsnograda;
import domen.Titula;
import domen.Ulogaclanakomisije;
import domen.Zaposleni;
import domen.Zavrsnirad;
import domen.Zvanje;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import sb.grad.GradSBLocal;
import sb.kandidat.KandidatSBLocal;
import sb.komisija.KomisijaSBLocal;
import sb.tutila.TitulaSBLocal;
import sb.uloga.UlogaSBLocal;
import sb.zaposleni.ZaposleniSBLocal;
import sb.zr.ZavrsniRadSBLocal;
import sb.zr.fajl.tip.TipFajlaSBLocal;
import sb.zr.tip.TipZRSBLocal;
import sb.zvanje.ZvanjeSBLocal;

/**
 *
 * @author MilicaJelica
 */
@Startup
@Singleton
@LocalBean
public class Kontroler {

    private int tekucaSifraZR;
    @EJB
    private ZavrsniRadSBLocal zrSB;
    @EJB
    private TipZRSBLocal tipZRSB;
    @EJB
    private KandidatSBLocal kandidatSB;
    @EJB
    private KomisijaSBLocal komisijaSB;
    @EJB
    private ZaposleniSBLocal zaposleniSB;
    @EJB
    private UlogaSBLocal ulogaSB;
    @EJB
    private TitulaSBLocal titulaSB;
    @EJB
    private ZvanjeSBLocal zvanjeSB;
    @EJB
    private GradSBLocal gradSB;
    @EJB
    private TipFajlaSBLocal tipFajlaSB;

    public Kontroler() {
    }

    @PostConstruct
    private void startup() {
        tekucaSifraZR = zrSB.uzmiTekucuSifru();
    }

    @PreDestroy
    private void shutdown() {
        zrSB.azurirajTekucuSifru(tekucaSifraZR);
    }

    public int getTekucaSifraZR() {
        return tekucaSifraZR;
    }

    public List<Tipzavrsnograda> vratiTipoveZR() {
        return tipZRSB.vratiTipoveZR();
    }

    public List<Kandidat> vratiKandidate() {
        return kandidatSB.vratiKandidate();
    }

    public Tipzavrsnograda vratiTipZavrsnogRada(int sifraTipaZR) {
        return tipZRSB.vratiTipZR(sifraTipaZR);
    }

    public Object vratiKandidata(String value) {
        return kandidatSB.vratiKandidata(value);
    }

    public void sacuvajKandidata(Kandidat kandidat) {
        kandidatSB.sacuvajKandidata(kandidat);
    }

    public void sacuvajKomisiju(List<Komisija> komisija) {
        for (Komisija clan : komisija) {
            komisijaSB.sacuvajKomisiju(clan);
        }
    }

    public List<Zaposleni> vratiZaposlene() {
        return zaposleniSB.vratiZaposlene();
    }

    public List<Zavrsnirad> vratiZavrsneRadove() {
        return zrSB.vratiZavrsneRadove();
    }

    public Zavrsnirad vratiZavrsniRad(int sifraZR) {
        return zrSB.vratiZavrsniRad(sifraZR);
    }

    public Ulogaclanakomisije vratiUlogu(int sifraUloge) {
        return ulogaSB.vratiUlogu(sifraUloge);
    }

    public List<Ulogaclanakomisije> vratiUloge() {
        return ulogaSB.vratiUloge();
    }

    public Titula vratiTitulu(int sifraTitule) {
        return titulaSB.vratiTitulu(sifraTitule);
    }

    public List<Titula> vratiTitule() {
        return titulaSB.vratiTitule();
    }

    public List<Zvanje> vratiZvanja() {
        return zvanjeSB.vratiZvanja();
    }

    public Object vratiZvanje(int sifraZvanja) {
        return zvanjeSB.vratiZvanje(sifraZvanja);
    }

    public Object vratiGrad(int ptt) {
        return gradSB.vratiGrad(ptt);
    }

    public List<Grad> vratiGradove() {
        return gradSB.vratiGradove();
    }

    public void sacuvajZaposlenog(Zaposleni zaposleni) {
        zaposleniSB.sacuvajZaposlenog(zaposleni);
    }

    public Object vratiZaposlenog(int id) {
        return zaposleniSB.vratiZaposlenog(id);
    }

    public Zaposleni login(Zaposleni zaposleni) {
        return zaposleniSB.login(zaposleni);
    }

    public List<Tipfajla> vratiTipoveFajla() {
        return tipFajlaSB.vratiTipoveFajla();
    }

    public void sacuvajZavrsniRad(Zavrsnirad zr) {
        zrSB.sacuvajZavrsniRad(zr);
        tekucaSifraZR++;
        zrSB.azurirajTekucuSifru(tekucaSifraZR);
    }

    public long vratiMinGodinu() {
        return zrSB.vratiMinGodinu();
    }

    public long vratiMaxGodinu() {
        return zrSB.vratiMaxGodinu();
    }

    public List<Kandidat> vratiKandidateZaGodinu(long godina, int sifraTipaZR) {
        return zrSB.vratiKandidateZaGodinu(godina, sifraTipaZR);
    }

}
