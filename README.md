Nome: Maria Meiriele Dias da Silva
Matricula : 201476009
Curso: Sistemas de Informação

Objetivo do Sistema

O sistema foi desenvolvido para atender um bar de pequeno porte. 
Ao chegar ao estabelecimento o cliente é lotado em uma mesa de numero estabelecido, o consumo é gerado em função do numero da mesa. Para o encerramento da mesa e sua liberação para outro cliente, o garçom deverá acionar o botão Fechar Pedido. Após quitada a comanda referente a mesa, retorna –se para a tela principal e a referida mesa estará disponível novamente.

Modelo de Dados: 
Segue o link https://drive.google.com/open?id=1WOKILWBl1JRzE2tNQDgUKfSf2jDYYPQn
O diagrama mostra o relacionamento entre as classes mais importantes que compõe o sistema

Interface:

A interface funciona em duas janelas. 
A primeira janela é a tela principal do Sistema do “Bar Mukifo” feito a partir de  FlowLayout ( ) onde foi adequado: botões , ComboBoxs, JScrollPane etc. Os botões cujas funções são controlar  ações como  (adicionar/Remover) Mesas e Itens do Pedido. 
Segue o Link para a tela principal https://drive.google.com/open?id=1ndoClEb1Uwfp3LoAgaR5PKkUpXd-0qfa
A segunda janela é acionada quando deseja-se Fechar o Pedido de uma mesa, e esse botão leva a uma JTextArea onde encontrará os detalhes da conta a  pagar, com detalhamento dos  produtos pedidos, seus respectivos valores e quantidades.
Segue o Link para a segunda tela https://drive.google.com/open?id=1GITh1_GIpVpRYo1dPOXr5IDxvetImqYy

Características do Sistema:

Possibilidade de controle dos itens, informando seus valores e nomes. 
Possibilidade de controle do funcionamento, oferecendo controle de mesas e pedidos. 
O controle dos itens permite ao usuário: Adicionar, Alterar ou Remover um item, ou remover todos os itens caso o pedido tenha sido feito de forma errada.

Funcionamento da interface:

Para a realização de um pedido o usuário deverá estar em uma mesa. Estas mesas foram representadas na Interface através de Arraylist e comboBox. Escolhendo a Mesa, será aberto um novo Pedido que será sinalizado como aberto no campo Status Atual. Nesta mesma tela, há uma JcomboBox com todos os itens disponíveis no restaurante para servir seus clientes. O usuário deverá selecionar o item a partir do Jcombo e acionar o botão Adicionar, onde o item selecionado será copiado adicionado ao campo Detalhamento do Pedido( uma JTextArea ) e será armazenado também em um ArrayList para poder ser gerenciado posteriormente. Para realizar o fechamento do Pedido, o usuário com a referida mesa aberta deverá clicar no botão Fechar Pedido, será aberta uma nova tela onde serão mostrados detalhes como: produto pedido, quantidade e valor, será mostrado o  valor total e após clicar no botão pago, será encerrado está mesa e ela estará livre para ser aberta novamente.

Melhorias futuras:

Melhorias futuras podem ocorrer com a utilização de um banco de dados, onde controlar a quantidade de itens disponíveis pode ser uma boa solução. Além disso, a utilização do Banco de Dados pode oferecer ao sistema um maior controle e administração dos dados através de novas funcionalidades que possam surgir para melhorar o funcionamento do software. 
Melhorar a interface que gera o detalhamento da conta a pagar, pois acabou ficando muito simples,  devido ao tempo de entrega.

Maiores Dificuldades:

Os campos de tratamentos ( hora de abertura e fechamento do pedido) foram bem complicados. Devido ao fato de  podermos abrir varias mesas ao mesmo tempo, e seus horários serão travados na hora da abertura. Acabei tratando eles como String ai ficou mais fácil.
Em síntese não foi fácil fazer o trabalho precisei pesquisar muito, ou seja, isso inclui horas de vídeo aulas, recorrer ao material da disciplina, além de ter comprado o livro, Java: Como Programar do DEITEL. Mas acaba que com o trabalho aprendi muita coisa que não havia ficado claro durante as aulas.
