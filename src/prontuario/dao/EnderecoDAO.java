/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prontuario.dao;

import java.sql.*;
import prontuario.connection.ConnectionFactory;
import prontuario.model.Endereco;

/**
 *
 * @author molsousa
 */
public class EnderecoDAO {
    public Endereco buscarEndereco(int nroPaciente) throws SQLException {
        
        String sql = "SELECT ende.cep, bai.nome_bairro, lg.nome_logradouro, tl.nome_tipo_logradouro, "
                + "cd.nome_cidade, uf.sigla_uf, pac.comp_endereco, pac.nro_endereco "
                + "FROM \"Endereco\" ende "
                + "JOIN \"Bairro\" bai ON ende.id_bairro = bai.id_bairro "
                + "JOIN \"Logradouro\" lg ON ende.id_logradouro = lg.id_logradouro "
                + "JOIN \"TipoLogradouro\" tl ON lg.sigla_tipo_logradouro = tl.sigla_tipo_logradouro "
                + "JOIN \"Cidade\" cd ON ende.id_cidade = cd.id_cidade "
                + "JOIN \"UnidadeFederativa\" uf ON cd.sigla_uf = uf.sigla_uf "
                + "JOIN \"Paciente\" pac ON ende.id_endereco = pac.id_endereco WHERE pac.nro_paciente = ?";
        Endereco endereco = new Endereco();
        
        try(Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, nroPaciente);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String bairro = rs.getString("nome_bairro");
                String logradouro = rs.getString("nome_logradouro");
                String tipoLogradouro = rs.getString("nome_tipo_logradouro");
                String enderecoCep = rs.getString("cep");
                String uf = rs.getString("sigla_uf");
                String cidade = rs.getString("nome_cidade");
                String compEndereco = rs.getString("comp_endereco");
                String nroEndereco = rs.getString("nro_endereco");
                
                endereco.setCep(enderecoCep);
                endereco.setTipoLogradouro(tipoLogradouro);
                endereco.setSiglaUF(uf);
                endereco.setNomeCidade(cidade);
                endereco.setNomeBairro(bairro);
                endereco.setLogradouro(logradouro);
                endereco.setCompEndereco(compEndereco);
                endereco.setNroEndereco(nroEndereco);
            }
            
        } catch (SQLException e){
            System.err.println("Erro ao buscar endereço: " + e.getMessage());
            throw e;
        }
        
        return endereco;
    }
}
