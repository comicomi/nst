/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb.presentation;

import domen.Tipfajla;

/**
 *
 * @author MilicaJelica
 */
public class TipfajlaPrezentacija extends Tipfajla{
    private boolean disabled;
    private boolean checked;
    private boolean choosable;

    public TipfajlaPrezentacija() {
    }

    public TipfajlaPrezentacija(boolean disabled, boolean checked, boolean choosable, Integer sifraTipaFajla, String naziv, String extenzija) {
        super(sifraTipaFajla, naziv, extenzija);
        this.disabled = disabled;
        this.checked = checked;
        this.choosable = choosable;
    }
    
    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChoosable() {
        return choosable;
    }

    public void setChoosable(boolean choosable) {
        this.choosable = choosable;
    }
    
}
