/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.zr.tip;

import domen.Tipzavrsnograda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MilicaJelica
 */
@Local
public interface TipZRSBLocal {
    List<Tipzavrsnograda> vratiTipoveZR();
    Tipzavrsnograda vratiTipZR(int sifraTipaZR);
}
