/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.dao;

import prontuario.model.Medico;
import java.sql.*;
import prontuario.connection.ConnectionFactory;

/**
 *
 * @author molsousa
 */
public class MedicoDAO {
    public Medico buscarMedico(int idMedico) throws SQLException {
        String sql = "SELECT med.nome_medico, med.crm FROM \"Medico\" med WHERE med.id_medico = ?";
        Medico medico = new Medico();
        
        try(Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, idMedico);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                medico.setNomeMedico(rs.getString("nome_medico"));
                medico.setCrm("crm");
            }
            
        } catch (SQLException e){
            System.err.println("Erro ao buscar médico: " + e.getMessage());
            throw e;
        }
        
        return medico;
    }
}
