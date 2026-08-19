/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package prontuario.main;

import java.sql.SQLException;
import prontuario.model.*;
import prontuario.dao.*;

/**
 *
 * @author molsousa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        Paciente paciente = new Paciente();
        PacienteDAO pdao = new PacienteDAO();
        FonePacienteDAO fonePDao = new FonePacienteDAO();
        EmailPacienteDAO emailPDao = new EmailPacienteDAO();
        EnderecoDAO endDAO = new EnderecoDAO();
        
        paciente = pdao.buscarPaciente(2);
        paciente.setFones(fonePDao.buscarTelefone(2));
        paciente.setEmails(emailPDao.buscarEmails(2));
        paciente.setEndereco(endDAO.buscarEndereco(2));
        
        System.out.println(paciente.getNomePaciente());
        System.out.println(paciente.getFones().get(0).getNroFone());
        System.out.println(paciente.getEmails().get(0).getEmailEndereco());
        System.out.println(paciente.getEndereco().getNroEndereco());
    }
}
