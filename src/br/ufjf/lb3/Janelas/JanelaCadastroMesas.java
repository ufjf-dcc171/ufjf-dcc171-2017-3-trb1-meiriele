
package br.ufjf.lb3.Janelas;

import br.ufjf.lb3.RepositorioDeDados.Mesas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JanelaCadastroMesas extends JFrame{
    private JLabel lblNumeroDaMesa = new JLabel("Numero da Mesa:");
    private JTextField txtNumeroDaMesa = new JTextField();
    private JButton btnCadastrar = new JButton("Cadastrar");
    private JButton btnRemover = new JButton("Remover");

    public JanelaCadastroMesas(final ArrayList<Mesas> barMukifo, JComboBox<String> cbMesa)  throws HeadlessException{
          super("Bar Mukifo");
          setLayout(new BorderLayout());
          JPanel pnlBotoes = new JPanel(new FlowLayout());
          pnlBotoes.add(btnCadastrar,FlowLayout.LEFT);
          pnlBotoes.add(btnRemover, FlowLayout.CENTER);
          add(lblNumeroDaMesa,BorderLayout.NORTH);
          add(txtNumeroDaMesa, BorderLayout.CENTER);
          add(pnlBotoes, BorderLayout.SOUTH);
          
          funcaoBotaoOK(barMukifo, cbMesa);
          funcaoBotaoRemover(barMukifo, cbMesa);
    }


    private void funcaoBotaoOK(ArrayList<Mesas> barMukifo, JComboBox<String> cbMesa) {
        try {
                btnCadastrar.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Mesas novaMesa = new Mesas();
                        novaMesa.setNome(txtNumeroDaMesa.getText());
                        barMukifo.add(novaMesa);
                        cbMesa.addItem(txtNumeroDaMesa.getText());
                        JOptionPane.showMessageDialog(null,"Mesa adicionada com sucesso");
                    }
            });
        } catch (Exception e) {
            System.err.println("erro ao add nova ");
        } 
    }

    private void funcaoBotaoRemover(ArrayList<Mesas> barMukifo, JComboBox<String> cbMesa) {
        try {
                btnRemover.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String busca = new String();
                        int i;
                        busca = txtNumeroDaMesa.getText();                        
                     
                        for(i=0;!barMukifo.get(i).getNome().equals(busca) && i<= barMukifo.size();i++);                                                 
                        if(i<barMukifo.size()){
                            barMukifo.remove(i);
                            cbMesa.removeItemAt(i);// remove do comboBox e reorganiza a ordem
                            JOptionPane.showMessageDialog(null,"Mesa removida com sucesso");
                        }else{
                            JOptionPane.showMessageDialog(null,"erro ao remover");
                        }
                    }
            });
        } catch (Exception e) {
            System.err.println(" erro ao remover mesa");
        }

    }
    
    
}
