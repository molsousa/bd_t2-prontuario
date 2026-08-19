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

    private Date dataConsulta;
    private int codCID;
    private String descricaoCID;

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public int getCodCID() {
        return codCID;
    }

    public void setCodCID(int codCID) {
        this.codCID = codCID;
    }

    public String getDescricaoCID() {
        return descricaoCID;
    }

    public void setDescricaoCID(String descricaoCID) {
        this.descricaoCID = descricaoCID;
    }

}
