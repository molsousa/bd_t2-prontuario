/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.dao;

import java.sql.*;
import java.util.*;
import prontuario.connection.ConnectionFactory;
import prontuario.model.FonePaciente;

/**
 *
 * @author molsousa
 */
public class FonePacienteDAO {
    public List<FonePaciente> buscarTelefone(int nroPaciente) throws SQLException {
        String sql = "SELECT * FROM \"FonePaciente\" WHERE nro_paciente = ?";
        List<FonePaciente> fones = new ArrayList<>();
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, nroPaciente);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                FonePaciente fonePaciente = new FonePaciente();
                
                fonePaciente.setNroFone(rs.getString("nro_fone_paciente"));
                fonePaciente.setNroDDD(rs.getInt("nro_ddd"));
                fonePaciente.setNroDDI(rs.getInt("nro_ddi"));
                
                fones.add(fonePaciente);
            }
            
        } catch(SQLException e) {
            System.err.println("Erro ao buscar telefones: " + e.getMessage());
            throw e;
        }
        
        return fones;
    }
}
