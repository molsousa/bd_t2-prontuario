/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.dao;

import java.util.*;
import java.sql.*;
import prontuario.connection.ConnectionFactory;
import prontuario.model.Exame;

/**
 *
 * @author molsousa
 */
public class ExameDAO {
    public List<Exame> buscarExames(int nroPaciente) throws SQLException {
        String sql = "SELECT exa.nro_exame, exa.data_exame, exa.observacao_exame, "
                + "te.nome_tipo_exame, re.descricao_resultado_exame "
                + "FROM \"Exame\" exa "
                + "JOIN \"TipoExame\" te ON te.id_tipo_exame = exa.id_tipo_exame "
                + "JOIN \"ResultadoExame\" re ON re.id_resultado_exame = exa.id_resultado_exame "
                + "JOIN \"Paciente\" pac ON pac.nro_paciente = exa.nro_paciente WHERE pac.nro_paciente = ?";
        List<Exame> exames = new ArrayList<>();
        
        try(Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, nroPaciente);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Exame exame = new Exame();
                
                exame.setNroExame(rs.getInt("nro_exame"));
                exame.setDataExame(rs.getDate("data_exame"));
                exame.setDescricaoResultadoExame(rs.getString("descricao_resultado_exame"));
                exame.setNomeExame(rs.getString("nome_tipo_exame"));
                exame.setObversacaoExame(rs.getString("observacao_exame"));
                
                exames.add(exame);
            }
            
        } catch (SQLException e){
            System.err.println("Erro ao buscar consultas: " + e.getMessage());
            throw e;
        }
        
        return exames;
    }
}
