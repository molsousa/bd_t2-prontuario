/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.dao;

import java.sql.*;
import java.util.*;
import prontuario.connection.ConnectionFactory;
import prontuario.model.EmailPaciente;

/**
 *
 * @author molsousa
 */
public class EmailPacienteDAO {
    public List<EmailPaciente> buscarEmails(int nroPaciente) throws SQLException {
        String sql = "SELECT * FROM \"EmailPaciente\" WHERE nro_paciente = ?";
        List<EmailPaciente> emails = new ArrayList<>();
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, nroPaciente);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                EmailPaciente emailPaciente = new EmailPaciente();
                
                emailPaciente.setEmailEndereco(rs.getString("endereco_email"));
                
                emails.add(emailPaciente);
            }
            
        } catch(SQLException e) {
            System.err.println("Erro ao buscar emails: " + e.getMessage());
            throw e;
        }
        
        return emails;
    }
}
