/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.dao;

import java.sql.*;
import prontuario.model.Consulta;
import java.util.*;
import prontuario.connection.ConnectionFactory;

/**
 *
 * @author molsousa
 */
public class ConsultaDAO {
    public List<Consulta> buscarConsultas(int nroPaciente) throws SQLException {
        String sql = "SELECT cons.nro_consulta, cons.data_consulta, med.id_medico, "
                + "cid.cod_cid, cid.descricao_cid "
                + "FROM \"Consulta\" cons "
                + "JOIN \"Medico\" med ON med.id_medico = cons.id_medico "
                + "JOIN \"CID\" cid ON cid.cod_cid = cons.cod_cid "
                + "JOIN \"Paciente\" pac ON pac.nro_paciente = cons.nro_paciente WHERE pac.nro_paciente = ?";
        List<Consulta> consultas = new ArrayList<>();
        
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, nroPaciente);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Consulta consulta = new Consulta();
                
                consulta.setCodConsulta(rs.getInt("nro_consulta"));
                consulta.setCodCID(rs.getString("cod_cid"));
                consulta.setDescricaoCID(rs.getString("descricao_cid"));
                consulta.setDataConsulta(rs.getDate("data_consulta"));
                consulta.setIdMedico(rs.getInt("id_medico"));
                
                consultas.add(consulta);
            }
            
        } catch (SQLException e){
            System.err.println("Erro ao buscar consultas: " + e.getMessage());
            throw e;
        }
        
        return consultas;
    }
}
