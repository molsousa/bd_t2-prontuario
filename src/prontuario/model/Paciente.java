/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.model;

import java.sql.Date;
import java.util.*;

/**
 *
 * @author molsousa
 */
public class Paciente {

    private int nroPaciente;
    private String nomePaciente;
    private Date dataNascimento;
    private String docIdentidade;
    private String estadoCivil;
    private String sexo;
    private Endereco endereco;
    private List<FonePaciente> fones;
    private List<EmailPaciente> emails;

    public int getNroPaciente() {
        return nroPaciente;
    }

    public void setNroPaciente(int nroPaciente) {
        this.nroPaciente = nroPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocIdentidade() {
        return docIdentidade;
    }

    public void setDocIdentidade(String docIdentidade) {
        this.docIdentidade = docIdentidade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<FonePaciente> getFones() {
        return fones;
    }

    public void setFones(List<FonePaciente> fones) {
        this.fones = fones;
    }

    public List<EmailPaciente> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailPaciente> emails) {
        this.emails = emails;
    }

}
