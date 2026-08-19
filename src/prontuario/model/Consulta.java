/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.model;

import java.sql.*;

/**
 *
 * @author molsousa
 */
public class Consulta {

    private int codConsulta;
    private Date dataConsulta;
    private String codCID;
    private String descricaoCID;
    private int idMedico;

    public int getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(int codConsulta) {
        this.codConsulta = codConsulta;
    }
    
    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getCodCID() {
        return codCID;
    }

    public void setCodCID(String codCID) {
        this.codCID = codCID;
    }

    public String getDescricaoCID() {
        return descricaoCID;
    }

    public void setDescricaoCID(String descricaoCID) {
        this.descricaoCID = descricaoCID;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

}
