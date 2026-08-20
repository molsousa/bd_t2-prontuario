/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.model;

import java.util.*;

/**
 *
 * @author molsousa
 */
public class Medico {

    private int nroMedico;
    private String nomeMedico;
    private String crm;
    private List<EmailMedico> emails;

    public int getNroMedico() {
        return nroMedico;
    }

    public void setNroMedico(int nroMedico) {
        this.nroMedico = nroMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<EmailMedico> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailMedico> emails) {
        this.emails = emails;
    }

}
