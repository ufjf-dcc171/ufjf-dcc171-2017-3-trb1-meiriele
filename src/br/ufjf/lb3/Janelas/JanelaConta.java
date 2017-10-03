
package br.ufjf.lb3.Janelas;

import br.ufjf.lb3.RepositorioDeDados.Mesas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


class JanelaConta extends JFrame{
    private JLabel lblConta = new JLabel("Conta");
    private JList lstConta = new JList(new DefaultListModel());
    DefaultListModel modelo = (DefaultListModel) lstConta.getModel();
    
    private JLabel lblTotal = new JLabel("Total:");
    private JTextField txtTotal = new JTextField(5);
    private JButton btnPago = new JButton("Pago");
    public JanelaConta(final ArrayList<Mesas> barMukifo, JComboBox<String> cbMesa, JButton btnAdicionar, JButton btnRemover)  throws HeadlessException{
        super("Bar Mukifo");
        setLayout(new BorderLayout());
        JPanel pnlTotal = new JPanel(new FlowLayout());
        pnlTotal.add(lblTotal, FlowLayout.LEFT);
        pnlTotal.add(txtTotal, FlowLayout.CENTER);
        pnlTotal.add(btnPago);
        add(lblConta,BorderLayout.NORTH);
        add(lstConta,BorderLayout.CENTER);
        add(pnlTotal,BorderLayout.SOUTH);
        preencherLista(barMukifo, cbMesa);
        txtTotal.setEnabled(true);
        txtTotal.setEditable(false);
        btnPago.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                barMukifo.get(cbMesa.getSelectedIndex()).setStatus(null);
                 JOptionPane.showMessageDialog(null,"Conta fechada com sucesso.");
                 barMukifo.get(cbMesa.getSelectedIndex()).reajustaHora(null);
                 btnAdicionar.setEnabled(true);
                 btnRemover.setEnabled(true);
            }
        });
    }

    private void preencherLista(ArrayList<Mesas> barMukifo, JComboBox<String> cbMesa) {
        int numeroDaMesa= cbMesa.getSelectedIndex();
        Double valor = 0.0;
        modelo.removeAllElements();
        String adicionarElemento = new String();
        modelo.addElement("Nome-----quantidade----Valor");
        for(int i=1; i < barMukifo.get(numeroDaMesa).getPedido().size()+1;i++){
            adicionarElemento = barMukifo.get(numeroDaMesa).getPedido().get(i-1).getNome()+"--"
                    + barMukifo.get(numeroDaMesa).getPedido().get(i-1).getQuantidade()+"---"
                    +barMukifo.get(numeroDaMesa).getPedido().get(i-1).getValor();
            modelo.addElement(adicionarElemento);
            valor += barMukifo.get(numeroDaMesa).getPedido().get(i-1).getQuantidade()*
                     barMukifo.get(numeroDaMesa).getPedido().get(i-1).getValor();
        }
        txtTotal.setText("R$ "+valor);
        
    }
}
