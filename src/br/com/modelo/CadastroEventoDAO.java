package br.com.modelo;
import br.com.entidade.Evento;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadastroEventoDAO extends DAO {
     public void inserir(Evento a) throws Exception {
     abrirBanco();
        //JOptionPane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "INSERT INTO evento (id,evento,Dataevento,valor) values(null,?,?,?)";
        ps=(PreparedStatement) con.prepareStatement(query);
        ps.setString(1, a.getEvento());
        ps.setString(2, a.getData());
        ps.setDouble(3, a.getValor());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Evento adicionado!");
        fecharBanco();
        }    
 public void deletarAluno(Evento a) throws Exception{
         abrirBanco();
         String query = "delete from evento where id=?";
         ps=(PreparedStatement) con.prepareStatement(query);
         ps.setInt(1, a.getId());
         ps.execute();
        JOptionPane.showMessageDialog(null, "Evento excluído!");
        fecharBanco();
     }
public void pesquisarRegistro (Evento a) throws Exception {
        try{
         abrirBanco();  
         String query = "select id, evento, data, valor FROM"
                 + " evento where id=?";
         ps = (PreparedStatement) con.prepareStatement(query);
         ps.setInt(1, a.getId());
         ResultSet tr = ps.executeQuery();
         if (tr.next()){  
           a.setId(tr.getInt("id"));
           a.setEvento(tr.getString("evento"));
           a.setData(tr.getString("data"));
           a.setValor(tr.getDouble("valor"));
         } else{
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado! ");
         }
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
     }
 
 public ArrayList<Evento> PesquisarTudo () throws Exception {
       ArrayList<Evento> eventos = new ArrayList<Evento>();
         try{
         abrirBanco();  
         String query = "select id, evento FROM evento";
         ps = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = ps.executeQuery();
         Evento a ;
         while (tr.next()){               
           a = new Evento();
           a.setId(tr.getInt("id"));
           a.setEvento(tr.getString("evento"));
           eventos.add(a);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return eventos;
     }
 
 public void editarAluno(Evento a) throws Exception {
     abrirBanco();
        //JOptionPane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "UPDATE evento set evento = ?, Dataevento = ?, valor = ? where id = ?";
        ps=(PreparedStatement) con.prepareStatement(query);
        ps.setString(1, a.getEvento());
        ps.setString(2, a.getData());
        ps.setDouble(3, a.getValor());
        ps.setInt(4, a.getId());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Evento Alterado!");
        fecharBanco();
        }

    public void editarEvento(Evento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

