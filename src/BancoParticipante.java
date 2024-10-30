import java.sql.*;
import java.util.Scanner;

public class BancoParticipante {

    private static Scanner sc = new Scanner(System.in);

    public static Participante salvarParticipante (Participante participante) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_participante (nome, email) VALUES " + "(?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, participante.getNome());
            ps.setString(2, participante.getEmail());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if ( rs.next()) {
                participante.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participante;

    }

    public static void deletarParticipante (int id) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("DELETE FROM tb_participante WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Participante buscarPorNome (String nome) {

        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_participante WHERE nome = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Participante(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Participante não encontrado.");

    }
}
