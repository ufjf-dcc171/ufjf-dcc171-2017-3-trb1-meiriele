package br.ufjf.lb3.Janelas;

import br.ufjf.lb3.RepositorioDeDados.Itens;
import br.ufjf.lb3.RepositorioDeDados.Mesas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JanelaMain extends JFrame {
    //Mesas

    private JLabel lblSelectMesa = new JLabel("Selecione a Mesa");
    private JComboBox<String> cbMesa;
    private JButton btnAddMesa = new JButton("Adiciona/Remover Mesas");

    private JScrollPane jsDetalhamento = new JScrollPane();
    // Estoque de Itens
    private JLabel lblItensDispEstoque = new JLabel("Itens Disponiveis");
    private JComboBox<String> cbEstoque;
    private JLabel lblQtd = new JLabel("QTD");
    private JTextField txtQtd = new JTextField(2);

    //Add e Remover
    private JButton btnRemover = new JButton("Remover");
    private JButton btnAdicionar = new JButton("Adicionar");

    //Status
    private JLabel lblStatus = new JLabel("Status atual.");
    private JTextField txtStatus = new JTextField();

    //detalhamento        
    private JLabel lblDetalhamentoPedido = new JLabel("Detalhamento do pedido");
    private JList lstDetalhamento = new JList(new DefaultListModel());
    DefaultListModel modelo = (DefaultListModel) lstDetalhamento.getModel();
    //hora de abertura
    private JLabel lblAbertura = new JLabel("Hora de Abertura");
    private JTextField txtHoraAbertura = new JTextField();
    //hora de fechamento
    private JLabel lblFechamento = new JLabel("Hora de Fechamento");
    private JTextField txtHoraFechamento = new JTextField();
    //fechar pedido
    private JButton btnFecharPedido = new JButton("Fechar Pedido");

    private ArrayList<Mesas> barMukifo = new ArrayList<>();

    private boolean precisaAtualizarListaMesas = false;

    public JanelaMain() throws HeadlessException {
        super("Bar Mukifo");
        // setMinimumSize(new Dimension(400, 350));
        //perguntar o Igor 
        lstDetalhamento.setVisibleRowCount(10);
        DefaultListModel modelo = (DefaultListModel) lstDetalhamento.getModel();
        DefaultListModel Modelo = (DefaultListModel) lstDetalhamento.getModel();
        criaMesas();
        //ação pra listar itens
        addItens();

        setLayout(new FlowLayout());

        JPanel pnlMesas = new JPanel(new BorderLayout(1, 1));
        JPanel pnlEstoque = new JPanel(new BorderLayout(1, 1));
        JPanel pnlOrganizar = new JPanel(new BorderLayout(1, 1));
        JPanel pnlAddRemove = new JPanel(new GridLayout(1, 2));
        JPanel pnlStatus = new JPanel(new BorderLayout(2, 2));
        JPanel pnlDetalhamento = new JPanel(new BorderLayout(1, 1));
        JPanel pnlAux = new JPanel(new FlowLayout());
        JPanel pnlAux2 = new JPanel(new BorderLayout(5, 5));
        JPanel pnlAbertura = new JPanel(new BorderLayout(1, 1));
        JPanel pnlFechamento = new JPanel(new BorderLayout(1, 1));
        JPanel pnlFechar = new JPanel(new BorderLayout(1, 1));

        //   
        pnlMesas.add(lblSelectMesa, BorderLayout.NORTH);
        pnlMesas.add(cbMesa, BorderLayout.CENTER);
        pnlMesas.add(btnAddMesa, BorderLayout.EAST);
        pnlMesas.add(pnlEstoque, BorderLayout.SOUTH);

        pnlEstoque.add(lblItensDispEstoque, BorderLayout.NORTH);
        pnlEstoque.add(cbEstoque, BorderLayout.CENTER);
        pnlEstoque.add(txtQtd, BorderLayout.EAST);
        pnlEstoque.add(pnlOrganizar, BorderLayout.SOUTH);

        pnlOrganizar.add(pnlAddRemove, BorderLayout.NORTH);

        pnlAddRemove.add(btnAdicionar);
        pnlAddRemove.add(btnRemover);

        pnlStatus.add(lblStatus, BorderLayout.NORTH);
        pnlStatus.add(txtStatus, BorderLayout.CENTER);

        pnlOrganizar.add(pnlStatus, BorderLayout.WEST);
        pnlOrganizar.add(pnlAux, BorderLayout.SOUTH);

        pnlAux.add(pnlDetalhamento, FlowLayout.LEFT);
        pnlAux.add(pnlAux2, FlowLayout.CENTER);

        pnlDetalhamento.add(lblDetalhamentoPedido, BorderLayout.NORTH);

        pnlDetalhamento.add(new JScrollPane(lstDetalhamento), BorderLayout.CENTER);

        pnlAux2.add(pnlAbertura, BorderLayout.NORTH);
        pnlAbertura.add(lblAbertura, BorderLayout.NORTH);
        pnlAbertura.add(txtHoraAbertura, BorderLayout.CENTER);

        pnlAux2.add(pnlFechamento, BorderLayout.CENTER);
        pnlFechamento.add(lblFechamento, BorderLayout.NORTH);
        pnlFechamento.add(txtHoraFechamento, BorderLayout.CENTER);

        pnlAux2.add(btnFecharPedido, BorderLayout.SOUTH);
        add(pnlMesas);

        //Desativar os botões
        txtStatus.setEditable(false);
        txtHoraAbertura.setEditable(false);
        txtHoraFechamento.setEditable(false);
        // lstDetalhamento.setEnabled(false);

        //ação para adicionar item no pedido;
        addItemPedido();
        removeItemPedido();
        fecharPedido();
        //ação para adicionar mesa
        addMesas();
        //ação para mostrar todos pedidos feitos por X mesa
        listarPedidos();

    }
//pronto

    private void addItemPedido() {
        try {
            btnAdicionar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int i = cbMesa.getSelectedIndex();
                    int j = cbEstoque.getSelectedIndex();
                    Itens itenPedido;
                    if (barMukifo.get(i).getStatus() == null) {
                        itenPedido = novoItem(j);
                        barMukifo.get(i).setStatus(true);
                        barMukifo.get(i).setHoraAbertura();
                        barMukifo.get(i).getPedido().add(itenPedido);
                        atualizaModelo();//chama a funcao na JanelaMain, ATUALIZAR A LISTA DE ITENS
                        atualizarStatus();
                    } else if (barMukifo.get(i).getStatus() == true) {
                        itenPedido = novoItem(j);
                        barMukifo.get(i).getPedido().add(itenPedido);
                        atualizaModelo();
                        atualizarStatus();
                    }
                    txtQtd.setText("");

                }

                private Itens novoItem(int j) {
                    Itens itenPedido; //meu cadastro de estoque, não cadastra pela tela como a MESA
                    switch (j) {
                        case 0:
                            itenPedido = new Itens(cbEstoque.getItemAt(j), 2.5);
                            itenPedido.setQuantidade(Integer.parseInt(txtQtd.getText()));
                            return itenPedido;
                        case 1:
                            itenPedido = new Itens(cbEstoque.getItemAt(j), 6.5);
                            itenPedido.setQuantidade(Integer.parseInt(txtQtd.getText()));
                            return itenPedido;
                        case 2:
                            itenPedido = new Itens(cbEstoque.getItemAt(j), 3.5);
                            itenPedido.setQuantidade(Integer.parseInt(txtQtd.getText()));
                            return itenPedido;
                        case 3:
                            itenPedido = new Itens(cbEstoque.getItemAt(j), 15.5);
                            itenPedido.setQuantidade(Integer.parseInt(txtQtd.getText()));
                            return itenPedido;
                        case 4:
                            itenPedido = new Itens(cbEstoque.getItemAt(j), 12.5);
                            itenPedido.setQuantidade(Integer.parseInt(txtQtd.getText()));
                            return itenPedido;
                        default:
                            itenPedido = new Itens(cbEstoque.getItemAt(j), 4.5);
                            itenPedido.setQuantidade(Integer.parseInt(txtQtd.getText()));
                            return itenPedido;
                    }
                }

            });

        } catch (Exception e) {
            System.err.println("erro ao inserir itens no pedido.");
        }
    }

    private void removeItemPedido() {
        try {
            btnRemover.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int i = cbMesa.getSelectedIndex();
                    int index = lstDetalhamento.getSelectedIndex();
                    modelo.remove(index);
                    /*podemos remover o pedido de  indice index direto pq
                      quando criamos o modelo, garantimos que o indice do modelo
                    é igual ao indice do ArrayList
                     */
                    barMukifo.get(i).getPedido().remove(index);

                }
            });
        } catch (Exception e) {
            System.err.println("erro ao remover item");
        }

    }

    private void fecharPedido() {
        try {
            btnFecharPedido.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int i = cbMesa.getSelectedIndex();
                    if (barMukifo.get(i).getStatus() == null) {
                        JOptionPane.showMessageDialog(null, "Pedido não foi aberto!");

                    } else if (barMukifo.get(i).getStatus()) {
                        JanelaConta janelaDaConta = new JanelaConta(barMukifo, cbMesa, btnAdicionar, btnRemover);
                        janelaDaConta.setSize(450, 400);
                        janelaDaConta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        janelaDaConta.setLocation(900, 165);
                        janelaDaConta.setVisible(true);
                        barMukifo.get(i).setHoraFechamento();
                        barMukifo.get(i).setStatus(false);
                        atualizarStatus();
                        btnAdicionar.setEnabled(false);
                        btnRemover.setEnabled(false);
                    } else {
                        JanelaConta janelaDaConta = new JanelaConta(barMukifo, cbMesa, btnAdicionar, btnRemover);
                        janelaDaConta.setSize(450, 400);
                        janelaDaConta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        janelaDaConta.setLocation(900, 165);
                        janelaDaConta.setVisible(true);
                        barMukifo.get(i).setStatus(false);
                        atualizarStatus();
                        btnAdicionar.setEnabled(false);
                        btnRemover.setEnabled(false);

                    }

                }

            });

        } catch (Exception e) {
            System.err.println("erro ao fechar pedido!");
        }

    }

    private void listarPedidos() {
        try {
            cbMesa.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    atualizarStatus();
                }
            });
        } catch (Exception e) {
            System.err.println("Erro ao listar pedidos");
        }
    }

    private void atualizarStatus() {
        int i = cbMesa.getSelectedIndex();
        if (barMukifo.get(i).getStatus() != null) {

            if (barMukifo.get(i).getStatus()) {
                txtStatus.setText("Aberto");
                atualizaModelo();
            } else {
                txtStatus.setText("Fechado");
            }
        } else {
            txtStatus.setText("N/D");
            modelo.removeAllElements();
            txtHoraAbertura.setText("N/D");
            txtHoraFechamento.setText("N/D");
        }
        if (barMukifo.get(i).getHoraAbertura() == null) {
            txtHoraAbertura.setText("N/D");
        } else {
            txtHoraAbertura.setText(barMukifo.get(i).getHoraAbertura().toString());
        }
        if (barMukifo.get(i).getHoraFechamento() == null) {
            txtHoraFechamento.setText("N/D");
        } else {
            txtHoraFechamento.setText(barMukifo.get(i).getHoraFechamento().toString());
        }
    }

    private void atualizaModelo() {
        int numeroDaMesa = cbMesa.getSelectedIndex();
        modelo.removeAllElements();
        String adicionarElemento = new String();
        for (int i = 0; i < barMukifo.get(numeroDaMesa).getPedido().size(); i++) {
            adicionarElemento = barMukifo.get(numeroDaMesa).getPedido().get(i).getNome() + "--"
                    + barMukifo.get(numeroDaMesa).getPedido().get(i).getQuantidade();
            modelo.addElement(adicionarElemento);
        }
    }

    private void addMesas() {
        try {
            btnAddMesa.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JanelaCadastroMesas janelaMesaNova = new JanelaCadastroMesas(barMukifo, cbMesa);
                    janelaMesaNova.setSize(250, 110);
                    janelaMesaNova.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    janelaMesaNova.setLocationRelativeTo(null);
                    janelaMesaNova.setVisible(true);

                }
            });

        } catch (Exception e) {
            System.err.println("Erro ao criar janela de cadastro de mesas");
        }
    }

    private void criaMesas() {
        String[] mesasPraCombo;
        for (int i = 0; i < 15; i++) {
            Mesas mesaAux = new Mesas();
            mesaAux.setNome("Mesa" + " " + i);
            barMukifo.add(mesaAux);
        }
        mesasPraCombo = new String[barMukifo.size()];
        for (int i = 0; i < barMukifo.size(); i++) {
            mesasPraCombo[i] = barMukifo.get(i).getNome();
        }
        cbMesa = new JComboBox<>(mesasPraCombo);
    }

    private void addItens() {
        String[] itensPraCombo;
        itensPraCombo = new String[6];
        itensPraCombo[0] = "Coca-cola";
        itensPraCombo[1] = "cerveja";
        itensPraCombo[2] = "Coxinha";
        itensPraCombo[3] = "pinga";
        itensPraCombo[4] = "Sorvete";
        itensPraCombo[5] = "Quibe";
        cbEstoque = new JComboBox<>(itensPraCombo);
    }

}
