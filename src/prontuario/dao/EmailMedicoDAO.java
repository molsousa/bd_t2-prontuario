/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.dao;

import java.sql.*;
import java.util.*;
import prontuario.connection.ConnectionFactory;
import prontuario.model.EmailMedico;

/**
 *
 * @author molsousa
 */

public class EmailMedicoDAO {
    public List<EmailMedico> buscarEmails(int idMedico) throws SQLException {
        String sql = "SELECT * FROM \"EmailMedico\" WHERE id_medico = ?";
        List<EmailMedico> emails = new ArrayList<>();
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idMedico);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                EmailMedico emailMedico = new EmailMedico();
                
                emailMedico.setEnderecoEmail(rs.getString("endereco_email"));
                
                emails.add(emailMedico);
            }
            
        } catch(SQLException e) {
            System.err.println("Erro ao buscar emails: " + e.getMessage());
            throw e;
        }
        
        return emails;
    }
}
