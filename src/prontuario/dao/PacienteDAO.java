/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.dao;

import prontuario.connection.ConnectionFactory;
import prontuario.model.Paciente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author molsousa
 */
public class PacienteDAO {
    
    public Paciente buscarPaciente(int nroPaciente) throws SQLException {
        String sql = "SELECT pc.nro_paciente, pc.nome_paciente, pc.data_nascimento, "
                    + "pc.doc_identidade, ec.descricao_estado_civil, se.descricao_sexo "
                    + "FROM \"Paciente\" pc "
                    + "JOIN \"EstadoCivil\" ec ON ec.id_estado_civil = pc.id_estado_civil "
                    + "JOIN \"Sexo\" se ON se.id_sexo = pc.id_sexo WHERE pc.nro_paciente = ?";
        
        Paciente paciente = new Paciente();
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nroPaciente);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                paciente.setNomePaciente(rs.getString("nome_paciente"));
                paciente.setDataNascimento(rs.getDate("data_nascimento"));
                paciente.setDocIdentidade(rs.getString("doc_identidade"));
                paciente.setEstadoCivil(rs.getString("descricao_estado_civil"));
                paciente.setSexo(rs.getString("descricao_sexo"));
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao buscar paciente: "+ e.getMessage());
            throw e;
        }
        
        return paciente;
    }
    
    public List<Paciente> listarPacientes() throws SQLException {
        String sql = "SELECT pac.nro_paciente, pac.nome_paciente FROM \"Paciente\" pac";
        
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while(rs.next()){
                Paciente paciente = new Paciente();
                
                paciente.setNroPaciente(rs.getInt("nro_paciente"));
                paciente.setNomePaciente(rs.getString("nome_paciente"));
                
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar pacientes: " + e.getMessage());
            throw e;
        }
        
        return pacientes;
    }
}
