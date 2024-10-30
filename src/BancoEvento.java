import java.sql.*;
import java.util.Scanner;

public class BancoEvento {

    private static Scanner sc = new Scanner(System.in);

    public static Evento salvarEvento (Evento evento) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_evento ( nome, local, data, descricao) VALUES " + "( ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, evento.getNome());
            ps.setString(2, evento.getLocal());
            ps.setString(3, evento.getData());
            ps.setString(4, evento.getDescricao());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                evento.setId(rs.getInt(1));
            }

        } catch (SQLException e ) {
            e.printStackTrace();
        }

        return evento;
    }

    public static void deletarEvento (int id) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("DELETE FROM tb_evento WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Evento buscarPorNome (String nome) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_evento WHERE nome = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Evento(rs.getInt("id"), rs.getString("nome"), rs.getString("local"), rs.getString("data"), rs.getString("descricao"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Evento não encontrado.");

    }
}
