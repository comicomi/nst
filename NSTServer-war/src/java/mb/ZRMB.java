/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template tekuciFajl, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Fajl;
import domen.Kandidat;
import domen.Tipfajla;
import domen.Zavrsnirad;
import file.upload.FileUploadService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import mb.presentation.TipfajlaPrezentacija;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;
import pl.Kontroler;

/**
 *
 * @author MilicaJelica
 */
@ManagedBean(name = "zrMB")
@ViewScoped
public class ZRMB implements Serializable {

    @EJB
    Kontroler kont;
    Zavrsnirad zr;
    private List<UploadedFile> uploadovaniFajlovi;
    private List<TipfajlaPrezentacija> tipoviFajlova;
    private TipfajlaPrezentacija tekuciTip;
    @ManagedProperty(value = "#{tipFajlaMB}")
    private TipFajlaMB tipFajlaMB;
    private TreeNode cvorDiplomski;
    private TreeNode cvorMaster;
    private TreeNode cvorDoktorski;
    private TreeNode tekuciCvor;
    private long min;
    private long max;
    
    /**
     * Creates a new instance of zrMB
     */
    public ZRMB() {
        zr = new Zavrsnirad();
        uploadovaniFajlovi = new ArrayList<>();
    }
    
    @PostConstruct
    private void napuni() {
        pripremiTipoveFajla();
    }
    
    public TreeNode getTekuciCvor() {
        return tekuciCvor;
    }

    public void setTekuciCvor(TreeNode tekuciCvor) {
        this.tekuciCvor = tekuciCvor;
    }

    private long minGodinu() {
        return kont.vratiMinGodinu();
    }

    private long maxGodinu() {
        return kont.vratiMaxGodinu();
    }

    public TreeNode getCvorDiplomski() {
        cvorDiplomski = new DefaultTreeNode("Diplomski radovi", null);
        vratiZavrsneRadove(cvorDiplomski, 1);
        return cvorDiplomski;
    }

    public void vratiZavrsneRadove(TreeNode cvor, int tip) {
        min = minGodinu();
        max = maxGodinu();
        for (long i = min; i <= max; i++) {
            TreeNode cvorGodina = new DefaultTreeNode(i, cvor);
            List<Kandidat> kandidati = kont.vratiKandidateZaGodinu(i, tip);
            for (Kandidat kandidat : kandidati) {
                TreeNode cvorKandidat = new DefaultTreeNode(kandidat, cvorGodina);
                for (Zavrsnirad zavrsnirad : kandidat.getZavrsniradList()) {
                    TreeNode cvorZR = new DefaultTreeNode(zavrsnirad, cvorKandidat);
                }
            }
        }
    }

    public void setCvorDiplomski(TreeNode cvorDiplomski) {
        this.cvorDiplomski = cvorDiplomski;
    }

    public TreeNode getCvorMaster() {
        cvorMaster = new DefaultTreeNode("Master radovi", null);
        vratiZavrsneRadove(cvorMaster, 2);
        return cvorMaster;
    }

    public void setCvorMaster(TreeNode cvorMaster) {
        this.cvorMaster = cvorMaster;
    }

    public TreeNode getCvorDoktorski() {
        cvorDoktorski = new DefaultTreeNode("Doktorski radovi", null);
        vratiZavrsneRadove(cvorDoktorski, 3);
        return cvorDoktorski;
    }

    public void setCvorDoktorski(TreeNode cvorDoktorski) {
        this.cvorDoktorski = cvorDoktorski;
    }

    public Zavrsnirad getZr() {
        return zr;
    }

    public void setZr(Zavrsnirad zr) {
        this.zr = zr;
    }

    public TipfajlaPrezentacija getTekuciTip() {
        return tekuciTip;
    }

    public void setTekuciTip(TipfajlaPrezentacija tekuciTip) {
        this.tekuciTip = tekuciTip;
    }

    public List<TipfajlaPrezentacija> getTipoviFajlova() {
        return tipoviFajlova;
    }

    public void setTipoviFajlova(List<TipfajlaPrezentacija> tipoviF) {
        pripremiTipoveFajla();
    }

    public TipFajlaMB getTipFajlaMB() {
        return tipFajlaMB;
    }

    public void setTipFajlaMB(TipFajlaMB tipFajlaMB) {
        this.tipFajlaMB = tipFajlaMB;
    }

    public void sacuvaj() {
        FacesContext context = FacesContext.getCurrentInstance();
        int sifra = kont.getTekucaSifraZR();
        zr.setSifraZavrsnogRada(sifra);
        String directoryPath = System.getProperty("com.sun.aas.instanceRoot") + "/docroot/Zavrsni radovi/" + zr.getSifraZavrsnogRada();
        try {
            for (int i = 0; i < zr.getFajlList().size(); i++) {
                Fajl fajl = zr.getFajlList().get(i);
                fajl.setPutanja(directoryPath);
                fajl.setRb(i + 1);
            }
            kont.sacuvajZavrsniRad(zr);
            for (UploadedFile fajl : uploadovaniFajlovi) {
                FileUploadService.sacuvajFajl(fajl, directoryPath);
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je kreirao novi završni rad.", null));
            zr = new Zavrsnirad();
            uploadovaniFajlovi.clear();
            pripremiTipoveFajla();
            tekuciTip = new TipfajlaPrezentacija();
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška pri unosu završnog rada.", null));
        }
    }

    public List<Zavrsnirad> vratiZavrsneRadove() {
        return kont.vratiZavrsneRadove();
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        UploadedFile izabranFajl = event.getFile();
        uploadovaniFajlovi.add(izabranFajl);
        Fajl fajl = new Fajl();
        fajl.setVelicina(izabranFajl.getSize() + "");
        fajl.setNaziv(izabranFajl.getFileName());
        fajl.setSifraZavrsnogRada(zr);
        Tipfajla tip = new Tipfajla();
        tip.setExtenzija(tekuciTip.getExtenzija());
        tip.setNaziv(tekuciTip.getNaziv());
        tip.setSifraTipaFajla(tekuciTip.getSifraTipaFajla());
        tip.setFajlList(tekuciTip.getFajlList());
        fajl.setSifraTipaFajla(tip);
        zr.getFajlList().add(fajl);
        tekuciTip.setDisabled(true);
        tekuciTip.setChoosable(false);
        FacesMessage message = new FacesMessage("Uspešno ste dodali ", fajl.getNaziv() + " fajl.");
        context.addMessage(null, message);
    }

    private void pripremiTipoveFajla() {
        List<Tipfajla> tipovi = tipFajlaMB.vratiTipoveFajla();
        tipoviFajlova = new ArrayList<>();
        for (Tipfajla tipfajla : tipovi) {
            TipfajlaPrezentacija tfp = new TipfajlaPrezentacija();
            tfp.setExtenzija(tipfajla.getExtenzija());
            tfp.setNaziv(tipfajla.getNaziv());
            tfp.setSifraTipaFajla(tipfajla.getSifraTipaFajla());
            tfp.setFajlList(tipfajla.getFajlList());
            tipoviFajlova.add(tfp);
        }
    }

    public void postaviTip(TipfajlaPrezentacija tipFajla) {
        tekuciTip = tipFajla;
        if (!tekuciTip.isChecked()) {
            for (int i = 0; i < zr.getFajlList().size(); i++) {
                Fajl fajl = zr.getFajlList().get(i);
                if (fajl.getSifraTipaFajla().getSifraTipaFajla() == tekuciTip.getSifraTipaFajla()) {
                    zr.getFajlList().remove(i);
                    for (UploadedFile uploadedFile : uploadovaniFajlovi) {
                        if (uploadedFile.getFileName().equals(fajl.getNaziv())) {
                            uploadovaniFajlovi.remove(uploadedFile);
                            break;
                        }
                    }
                    break;
                }
            }
        }

    }

    public String prikaziDialog() {
        if (tekuciTip == null || !tekuciTip.isChecked()) {
            return "dodajFajl.show()";
        }
        return "dodajFajl.hide()";
    }

    public String getAllowedTypes() {
        String dozvoljeniTipovi = "/(\\.|\\/)(";
        if (tekuciTip != null) {
            dozvoljeniTipovi += tekuciTip.getExtenzija();
        }
        dozvoljeniTipovi += ")$/";
        return dozvoljeniTipovi;
    }

    public void onNodeSelect(NodeSelectEvent event) {
        TreeNode node = event.getTreeNode();
        if (node.getData() instanceof Zavrsnirad) {
            zr = (Zavrsnirad) node.getData();
            RequestContext.getCurrentInstance().execute("prikazZR.show()");
        }
    }

    public StreamedContent preuzmiFajl(Fajl izabraniFajl) {
        InputStream stream = null;
        StreamedContent fajlZaDownload = null;
        try {
            String putanja = izabraniFajl.getPutanja() + "/" + izabraniFajl.getNaziv();
            System.out.println(putanja);
            stream = new FileInputStream(putanja);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            System.out.println(externalContext.getMimeType(izabraniFajl.getNaziv()));
            fajlZaDownload = new DefaultStreamedContent(stream,externalContext.getMimeType(izabraniFajl.getNaziv()) ,izabraniFajl.getNaziv());
            return fajlZaDownload;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ZRMB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }

}
