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
public class Exame {

    private Date dataExame;
    private String nomeExame;
    private String descricaoResultadoExame;
    private String obversacaoExame;

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public String getDescricaoResultadoExame() {
        return descricaoResultadoExame;
    }

    public void setDescricaoResultadoExame(String descricaoResultadoExame) {
        this.descricaoResultadoExame = descricaoResultadoExame;
    }

    public String getObversacaoExame() {
        return obversacaoExame;
    }

    public void setObversacaoExame(String obversacaoExame) {
        this.obversacaoExame = obversacaoExame;
    }

}
