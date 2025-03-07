import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyFrame extends JFrame {
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;
    int id;


    JTabbedPane tab = new JTabbedPane();
    JTable tableR = new JTable();
    JTable tableB = new JTable();
    JTable tableTB = new JTable();
    JPanel readersPanel = new JPanel();
    JPanel booksPanel = new JPanel();
    JPanel takenBooksPanel = new JPanel();

    JPanel readersUp = new JPanel();
    JPanel readersMid = new JPanel();
    JPanel readersDown = new JPanel();
    JPanel booksUp = new JPanel();
    JPanel booksMid = new JPanel();
    JPanel booksDown = new JPanel();
    JPanel takenBooksUp = new JPanel();
    JPanel takenBooksMid = new JPanel();
    JPanel takenBooksDown = new JPanel();


    //READERS
    JLabel fnameL = new JLabel( "   Име");
    JLabel lnameL = new JLabel( "   Фамилия");
    JLabel egnL = new JLabel(   "   ЕГН");
    JLabel telL = new JLabel(   "   Телефон");
    JLabel specL = new JLabel(  "   Специалност");

    JTextField fnameTF = new JTextField();
    JTextField lnameTF = new JTextField();
    JTextField egnTF = new JTextField();
    JTextField telTF = new JTextField();
    JTextField specTF = new JTextField();
    //CLOSED

    //BOOKS
    JLabel titleL = new JLabel      ("  Заглавие");
    JLabel authorL = new JLabel     ("  Автор");
    JLabel isbnL = new JLabel       ("  ISBN");
    JLabel publHouseL = new JLabel  ("  Издателство");
    JLabel yearL = new JLabel       ("  Година на издаване");
    JTextField titleTF = new JTextField();
    JTextField authorTF = new JTextField();
    JTextField isbnTF = new JTextField();
    JTextField publHouseTF = new JTextField();
    JTextField yearrTF = new JTextField();
    //CLOSED

    //TAKEN_BOOKS
    JLabel readerIDL = new JLabel   ("  Читателски номер");
    JLabel bookIDL = new JLabel     ("  Номер на книга");
    JLabel dateOfGL = new JLabel    ("  Ден на вземане");
    JLabel dateToRL = new JLabel    ("  Ден на връщане");

    JComboBox readerCb = new JComboBox();
    JComboBox bookCb = new JComboBox();
    JTextField dateOfGTF = new JTextField();
    JTextField dateToRTF = new JTextField();

    //CLOSED

    //QUERY
    JLabel dToRQL=new JLabel    ("  Въведете дата на връщане:");
    JTextField dToRQTF=new JTextField();

    JPanel queryPanel=new JPanel();
    //подпанели
    JPanel queryPanelUp=new JPanel();
    JPanel queryPanelMid=new JPanel();
    JPanel queryPanelDown=new JPanel();
    JButton searchBQ=new JButton("Търси");

    JTable tableQ=new JTable();
    JScrollPane scrollQ=new JScrollPane(tableQ);

    //CLOSED

    //2nd QUERY
    JLabel fnameQ2L =new JLabel("Специалност:");
    JComboBox specialityCb = new JComboBox(Specialty.values());

    JLabel lnameQ2L =new JLabel("Автор:");
    JTextField fnameQ2TF =new JTextField();
    JTextField lnameQ2TF =new JTextField();
    JPanel queryPanel2=new JPanel();
    //подпанели
    JPanel queryPanelUp2=new JPanel();
    JPanel queryPanelMid2=new JPanel();
    JPanel queryPanelDown2=new JPanel();
    JButton searchBQ2=new JButton("Търси");

    JTable tableQ2=new JTable();
    JScrollPane scrollQ2=new JScrollPane(tableQ2);

    //CLOSED


    JButton addButtonR = new JButton("Добави");
    JButton deleteButtonR = new JButton("Изтрий");
    JButton editButtonR = new JButton("Промени");
    JButton searchButtonR = new JButton("Търси");
    JButton refreshButtonR = new JButton("Обнови");
    JScrollPane myScrollR = new JScrollPane(tableR);


    JButton addButtonB = new JButton("Добави");
    JButton deleteButtonB = new JButton("Изтрий");
    JButton editButtonB = new JButton("Промени");
    JButton searchButtonB = new JButton("Търси");
    JButton refreshButtonB = new JButton("Обнови");
    JScrollPane myScrollB = new JScrollPane(tableB);
    JButton addButtonTB = new JButton("Добави");
    JButton deleteButtonTB = new JButton("Изтрий");
    JButton editButtonTB = new JButton("Промени");
    JButton searchButtonTB = new JButton("Търси");
    JButton refreshButtonTB = new JButton("Обнови");
    JScrollPane myScrollTB = new JScrollPane(tableTB);

    JComboBox<String> readersCombo = new JComboBox<>();
    JComboBox<String> booksCombo = new JComboBox<>();

    public MyFrame() {
        this.setSize(400, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        readersPanel.setName("Читатели");
        booksPanel.setName("Книги");
        takenBooksPanel.setName("Взети книги");
        tab.add(readersPanel);
        tab.add(booksPanel);
        tab.add(takenBooksPanel);

        this.add(tab);

        //Читатели
        readersPanel.setLayout(new GridLayout(3, 1));
        readersUp.setBackground(Color.decode("#34495e")); // background color
        readersUp.setLayout(new GridLayout(5, 2));

        readersUp.add(fnameL);
        fnameL.setForeground(Color.WHITE); // Бял текст
        fnameL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        readersUp.add(fnameTF);

        readersUp.add(lnameL);
        lnameL.setForeground(Color.WHITE); // Бял текст
        lnameL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        readersUp.add(lnameTF);

        readersUp.add(egnL);
        egnL.setForeground(Color.WHITE); // Бял текст
        egnL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        readersUp.add(egnTF);

        readersUp.add(telL);
        telL.setForeground(Color.WHITE); // Бял текст
        telL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        readersUp.add(telTF);

        readersUp.add(specL);
        specL.setForeground(Color.WHITE); // Бял текст
        specL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        readersUp.add(specTF);


        readersMid.setBackground(Color.decode("#34495e")); // background color
        addHoverEffect(addButtonR, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        addButtonR.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        readersMid.add(addButtonR);

        addHoverEffect(deleteButtonR, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        deleteButtonR.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        readersMid.add(deleteButtonR);

        addHoverEffect(editButtonR, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        editButtonR.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        readersMid.add(editButtonR);

        addHoverEffect(searchButtonR, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        searchButtonR.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        readersMid.add(searchButtonR);

        addHoverEffect(refreshButtonR, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        refreshButtonR.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        readersMid.add(refreshButtonR);

        myScrollR.setPreferredSize(new Dimension(350, 150));
        readersDown.setBackground(Color.decode("#34495e")); // background color
        readersDown.add(myScrollR);

        readersPanel.add(readersUp);
        readersPanel.add(readersMid);
        readersPanel.add(readersDown);

        //Книги
        booksPanel.setLayout(new GridLayout(3, 1));
        booksUp.setBackground(Color.decode("#34495e")); // background color
        booksUp.setLayout(new GridLayout(5, 2));

        booksUp.add(titleL);
        titleL.setForeground(Color.WHITE); // Бял текст
        titleL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        booksUp.add(titleTF);

        booksUp.add(authorL);
        authorL.setForeground(Color.WHITE); // Бял текст
        authorL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        booksUp.add(authorTF);

        booksUp.add(isbnL);
        isbnL.setForeground(Color.WHITE); // Бял текст
        isbnL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        booksUp.add(isbnTF);

        booksUp.add(publHouseL);
        publHouseL.setForeground(Color.WHITE); // Бял текст
        publHouseL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        booksUp.add(publHouseTF);

        booksUp.add(yearL);
        yearL.setForeground(Color.WHITE); // Бял текст
        yearL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        booksUp.add(yearrTF);

        booksMid.setBackground(Color.decode("#34495e")); // background color
        addHoverEffect(addButtonB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        addButtonB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        booksMid.add(addButtonB);

        addHoverEffect(deleteButtonB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        deleteButtonB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        booksMid.add(deleteButtonB);

        addHoverEffect(editButtonB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        editButtonB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        booksMid.add(editButtonB);

        addHoverEffect(searchButtonB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        searchButtonB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        booksMid.add(searchButtonB);

        addHoverEffect(refreshButtonB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        refreshButtonB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        booksMid.add(refreshButtonB);

        myScrollB.setPreferredSize(new Dimension(350, 150));
        booksDown.setBackground(Color.decode("#34495e")); // background color
        booksDown.add(myScrollB);

        booksPanel.add(booksUp);
        booksPanel.add(booksMid);
        booksPanel.add(booksDown);

        //Взети книги
        takenBooksPanel.setLayout(new GridLayout(3, 1));
        takenBooksUp.setBackground(Color.decode("#34495e")); // background color
        takenBooksUp.setLayout(new GridLayout(4, 2));

        takenBooksUp.add(readerIDL);
        readerIDL.setForeground(Color.WHITE); // Бял текст
        readerIDL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        takenBooksUp.add(readerCb);

        takenBooksUp.add(bookIDL);
        bookIDL.setForeground(Color.WHITE); // Бял текст
        bookIDL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        takenBooksUp.add(bookCb);

        takenBooksUp.add(dateOfGL);
        dateOfGL.setForeground(Color.WHITE); // Бял текст
        dateOfGL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        takenBooksUp.add(dateOfGTF);

        takenBooksUp.add(dateToRL);
        dateToRL.setForeground(Color.WHITE); // Бял текст
        dateToRL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт Comic Sans MS
        takenBooksUp.add(dateToRTF);

        refreshComboTBR();
        refreshComboTBB();
        addHoverEffect(addButtonTB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        addButtonTB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        addButtonTB.addActionListener(new AddActionTB());

        addHoverEffect(deleteButtonTB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        deleteButtonTB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        deleteButtonTB.addActionListener(new DeleteActionTB());

        tableTB.addMouseListener(new MouseActionTB());

        addHoverEffect(searchButtonTB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        searchButtonTB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        searchButtonTB.addActionListener(new SearchActionTB());

        addHoverEffect(refreshButtonTB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        refreshButtonTB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        refreshButtonTB.addActionListener(new RefreshActionTB());

        addHoverEffect(editButtonTB, "#5499c7", "#F5F5F5"); //Hover ефект за бутон
        editButtonTB.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        editButtonTB.addActionListener(new EditTakenBooks());

        takenBooksMid.setBackground(Color.decode("#34495e")); // background color
        takenBooksMid.add(addButtonTB);
        takenBooksMid.add(deleteButtonTB);
        takenBooksMid.add(searchButtonTB);
        takenBooksMid.add(refreshButtonTB);
        takenBooksMid.add(editButtonTB);

        myScrollTB.setPreferredSize(new Dimension(350, 150));
        takenBooksDown.setBackground(Color.decode("#34495e")); // background color
        takenBooksDown.add(myScrollTB);

        takenBooksPanel.add(takenBooksUp);
        takenBooksPanel.add(takenBooksMid);
        takenBooksPanel.add(takenBooksDown);


        addButtonR.addActionListener(new AddAction());
        deleteButtonR.addActionListener(new DeleteAction());
        tableR.addMouseListener(new MouseAction());
        searchButtonR.addActionListener(new SearchAction());
        refreshButtonR.addActionListener(new RefreshAction());
        editButtonR.addActionListener(new EditReaders());
        refreshTable();

        addButtonB.addActionListener(new AddActionB());
        deleteButtonB.addActionListener(new DeleteActionB());
        tableB.addMouseListener(new MouseActionB());
        searchButtonB.addActionListener(new SearchActionB());
        refreshButtonB.addActionListener(new RefreshActionB());
        editButtonB.addActionListener(new EditBooks());
        refreshTableB();
        readersMid.add(readersCombo);
        booksMid.add(booksCombo);
        refreshCombo();
        refreshComboB();
        refreshTableTB();


        //Спаравка
        tab.add(queryPanel,"Справка");
        queryPanel.setLayout(new GridLayout(3,1));
        queryPanel.add(queryPanelUp);
        queryPanelUp.setBackground(Color.decode("#34495e")); // background color


        queryPanelUp.add(dToRQL);
        dToRQL.setForeground(Color.WHITE); // Бял текст
        dToRQL.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        queryPanelUp.add(dToRQTF);
        dToRQTF.setPreferredSize(new Dimension(60,30));
        queryPanel.add(queryPanelMid);
        queryPanelMid.add(searchBQ);
        queryPanelMid.setBackground(Color.decode("#34495e")); // background color

        searchBQ.addActionListener(new SearchActionQ());
        searchBQ.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        
        scrollQ.setPreferredSize(new Dimension(350, 200));
        queryPanelDown.add(scrollQ);
        queryPanelDown.setBackground(Color.decode("#34495e")); // background color
        queryPanel.add(queryPanelDown);
        clearFormQ();


        //Справка 2
        tab.add(queryPanel2,"Справка2");
        queryPanel2.setLayout(new GridLayout(3,1));
        queryPanel2.add(queryPanelUp2);
        queryPanelUp2.setBackground(Color.decode("#34495e")); // background color
        queryPanelUp2.add(fnameQ2L);
        fnameQ2L.setForeground(Color.WHITE); // Бял текст
        fnameQ2L.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт

        queryPanelUp2.add(specialityCb);
        //queryPanelUp2.add(fnameQ2TF);
        queryPanelUp2.add(lnameQ2L);
        lnameQ2L.setForeground(Color.WHITE); // Бял текст
        lnameQ2L.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт
        queryPanelUp2.add(lnameQ2TF);
        fnameQ2TF.setPreferredSize(new Dimension(90,30));
        lnameQ2TF.setPreferredSize(new Dimension(90,30));
        queryPanel2.add(queryPanelMid2);
        queryPanelMid2.setBackground(Color.decode("#34495e")); // background color
        queryPanelMid2.add(searchBQ2);

        searchBQ2.addActionListener(new SearchActionQ2());
        searchBQ2.setFont(new Font("Comic Sans MS", Font.ITALIC, 14)); //шрифт

        scrollQ2.setPreferredSize(new Dimension(350, 200));
        queryPanelDown2.add(scrollQ2);
        queryPanelDown2.setBackground(Color.decode("#34495e")); // background color
        queryPanel2.add(queryPanelDown2);
        clearFormQ2();

        this.setVisible(true);


    }


    private void addHoverEffect(JButton button, String colorOnHover, String colorDefault) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.decode(colorOnHover));
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.decode(colorDefault));
            }
        });
    }


    public void refreshTable() {

        conn = DBConnection.getConnection();
        try {
            state = conn.prepareStatement("select * from readers");
            result = state.executeQuery();
            tableR.setModel(new MyModel(result));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
public void clearFormQ() {
        dToRQTF.setText("");
}
    class AddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnection.getConnection();
            String sql = "insert into readers(fname, lname, egn, tel, spec) values(?,?,?,?,?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, fnameTF.getText());
                state.setString(2, lnameTF.getText());
                state.setString(3, egnTF.getText());
                state.setString(4, telTF.getText());
                state.setString(5, specTF.getText());

                state.execute();
                refreshTable();
                refreshCombo();
                clearForm();

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }

    class MouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tableR.getSelectedRow();
            id = Integer.parseInt(tableR.getValueAt(row, 0).toString());
            fnameTF.setText(tableR.getValueAt(row, 1).toString());
            lnameTF.setText(tableR.getValueAt(row, 2).toString());
            egnTF.setText(tableR.getValueAt(row, 3).toString());
            telTF.setText(tableR.getValueAt(row, 4).toString());
            specTF.setText(tableR.getValueAt(row, 5).toString());


        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    class DeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();

            String sql = "delete from readers where id=?";

            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, id);
                state.execute();
                id = -1;
                refreshTable();
                 refreshCombo();
                clearForm();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }

    public void clearForm() {
        fnameTF.setText("");
        lnameTF.setText("");
        egnTF.setText("");
        telTF.setText("");
        specTF.setText("");
    }

    public void refreshCombo() {
        readersCombo.removeAllItems();
        conn=DBConnection.getConnection();
        String sql="select id, fname, lname from readers";
        String item="";

        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            while(result.next()) {
                item=result.getObject(1).toString()+"."
                        +result.getObject(2).toString()+" "
                        +result.getObject(3).toString();
                readersCombo.addItem(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void refreshComboTBR() {
       readerCb.removeAllItems();
        conn=DBConnection.getConnection();
        String sql="select id, fname, lname from readers";
        String item ="";


        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            while(result.next()) {
                item=result.getObject(1).toString()+"."+
                        result.getObject(2).toString()+" "+
                        result.getObject(3).toString();
                readerCb.addItem(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class SearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnection.getConnection();
            String sql = "select * from readers where spec=?";

            try {
                state = conn.prepareStatement(sql);
                state.setString(1, specTF.getText());
                result = state.executeQuery();
                tableR.setModel(new MyModel(result));
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    class RefreshAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshTable();
        }
    }
    class EditReaders implements ActionListener {
        public void actionPerformed (ActionEvent arg0) {
			conn=DBConnection.getConnection();
            if(id>0) {
                String sql="update readers set fname=?, lname=?, egn=?, tel=?, spec=? where id=?";

                try {
                    state=conn.prepareStatement(sql);

                    state.setString(1, fnameTF.getText());
                    state.setString(2, lnameTF.getText());
                    state.setString(3, egnTF.getText());
                    state.setString(4, telTF.getText());
                    state.setString(5, specTF.getText());
                    state.setInt(6, id);

                    state.execute();

                    refreshTable();

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                clearForm();
            }
        }
    }

    //BOOKS

    public void refreshTableB() {

        conn = DBConnection.getConnection();
        try {
            state = conn.prepareStatement("select * from books");
            result = state.executeQuery();
            tableB.setModel(new MyModel(result));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    class AddActionB implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnection.getConnection();
            String sql = "insert into books(title, author, isbn, publHouse, yearr) values(?,?,?,?,?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, titleTF.getText());
                state.setString(2, authorTF.getText());
                state.setString(3, isbnTF.getText());
                state.setString(4, publHouseTF.getText());
                state.setString(5, yearrTF.getText());

                state.execute();
                refreshTableB();
                refreshComboB();
                clearFormB();

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    class MouseActionB implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tableB.getSelectedRow();
            id = Integer.parseInt(tableB.getValueAt(row, 0).toString());
            titleTF.setText(tableB.getValueAt(row, 1).toString());
            authorTF.setText(tableB.getValueAt(row, 2).toString());
            isbnTF.setText(tableB.getValueAt(row, 3).toString());
            publHouseTF.setText(tableB.getValueAt(row, 4).toString());
            yearrTF.setText(tableB.getValueAt(row, 5).toString());


        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    class DeleteActionB implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();

            String sql = "delete from books where id=?";

            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, id);
                state.execute();
                id = -1;
                refreshTableB();
                refreshComboB();
                clearFormB();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }

    public void clearFormB() {
        titleTF.setText("");
        authorTF.setText("");
        isbnTF.setText("");
        publHouseTF.setText("");
        yearrTF.setText("");
    }

    class SearchActionB implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnection.getConnection();
            String sql = "select * from books where isbn=?";

            try {
                state = conn.prepareStatement(sql);
                state.setString(1, isbnTF.getText());
                result = state.executeQuery();
                tableB.setModel(new MyModel(result));
                clearFormB();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


        }

    }
    class RefreshActionB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshTableB();

        }

    }
    class EditBooks implements ActionListener {
        public void actionPerformed (ActionEvent arg0) {
            conn=DBConnection.getConnection();
            if(id>0) {
                String sql="update books set title=?, author=?, isbn=?, publHouse=?, yearr=? where id=?";

                try {
                    state=conn.prepareStatement(sql);

                    state.setString(1, titleTF.getText());
                    state.setString(2, authorTF.getText());
                    state.setString(3, isbnTF.getText());
                    state.setString(4, publHouseTF.getText());
                    state.setString(5, yearrTF.getText());
                    state.setInt(6, id);

                    state.execute();

                    refreshTableB();

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                clearFormB();
            }

        }
    }
    public void refreshComboB() {
        booksCombo.removeAllItems();
        conn=DBConnection.getConnection();
        String sql="select id, title, isbn from books";
        String item="";

        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            while(result.next()) {
                item=result.getObject(1).toString()+"."
                        +result.getObject(2).toString()+" "
                        +result.getObject(3).toString();
                booksCombo.addItem(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void refreshComboTBB() {
        bookCb.removeAllItems();
        conn=DBConnection.getConnection();
        String sql="select id, title, author from books";
        String item="";

        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            while(result.next()) {
                item=result.getObject(1).toString()+"."
                        +result.getObject(2).toString()+" "
                        +result.getObject(3).toString();
                bookCb.addItem(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class AddActionTB implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnection.getConnection();
            String sql = "insert into takenbooks(reader_id, book_id, issuedate, returndate) values(?,?,?,?)";

            String vaS =readerCb.getSelectedItem().toString();
            int va = Integer.parseInt(vaS.substring(0,vaS.indexOf('.')));


            String valS =bookCb.getSelectedItem().toString();
            int val = Integer.parseInt(valS.substring(0,valS.indexOf('.')));
            // System.out.printf(va + " " + val);

            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, va);
                state.setInt(2, val);
               // state.setString(2, bookCb.getSelectedItem().toString());
                state.setString(3, dateOfGTF.getText());
                state.setString(4, dateToRTF.getText());

                state.execute();
                refreshTableTB();
                clearFormTB();

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }
    class MouseActionTB implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tableTB.getSelectedRow();
            id = Integer.parseInt(tableTB.getValueAt(row, 0).toString());
            try {
                state.setString(1, readerCb.getSelectedItem().toString());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                state.setString(2, bookCb.getSelectedItem().toString());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            dateOfGTF.setText(tableTB.getValueAt(row, 3).toString());
            dateToRTF.setText(tableTB.getValueAt(row, 4).toString());

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    class DeleteActionTB implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();

            String sql = "delete from takenbooks where id=?";

            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, id);
                state.execute();
                id = -1;
                refreshTableTB();
                clearFormTB();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }

    public void clearFormTB() {
        dateOfGTF.setText("");
        dateToRTF.setText("");
    }

    class SearchActionTB implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnection.getConnection();
            String sql = "select * from takenbooks where book_id=?";

            try {
                state = conn.prepareStatement(sql);
                result = state.executeQuery();
                tableTB.setModel(new MyModel(result));
                clearFormTB();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


        }

    }
    class RefreshActionTB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshTableTB();

        }

    }
    class EditTakenBooks implements ActionListener {
        public void actionPerformed (ActionEvent arg0) {
            conn=DBConnection.getConnection();
            if(id>0) {
                String sql="update takenbooks set reader_id=?, book_id=?, issuedate=?, returndate=? where id=?";

                try {
                    state=conn.prepareStatement(sql);
                    state.setString(1, readerCb.getSelectedItem().toString());
                    state.setString(2, bookCb.getSelectedItem().toString());
                    state.setString(3, dateOfGTF.getText());
                    state.setString(4, dateToRTF.getText());
                    state.setInt(5, id);

                    state.execute();

                    refreshTableTB();

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                clearFormTB();
            }

        }
    }
    public void refreshTableTB() {

        conn = DBConnection.getConnection();
        try {
            state = conn.prepareStatement("select tb.id, r.fname, r.lname, b.title, tb.returndate from takenbooks tb, readers r, books b where tb.reader_id = r.id and tb.book_id = b.id");
            result = state.executeQuery();
            tableTB.setModel(new MyModel(result));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class SearchActionQ implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnection.getConnection();
            String sql = "select r.fname,r.lname,b.title,tb.returndate from readers r,books b,takenbooks tb where r.id=tb.reader_id and b.id=tb.book_id and tb.returndate=?";

            try {
                state = conn.prepareStatement(sql);
                state.setString(1, dToRQTF.getText());
                result = state.executeQuery();
                tableQ.setModel(new MyModel(result));
                clearFormQ();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    public void clearFormQ2() {
        fnameQ2TF.setText("");
        lnameQ2TF.setText("");

    }

    class SearchActionQ2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnection.getConnection();
            String sql = "select r.fname,r.lname,b.title,b.isbn,r.spec,tb.returndate from readers r,books b,takenbooks tb where r.id=tb.reader_id and b.id=tb.book_id and r.spec=? and b.author=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, fnameQ2TF.getText());
                state.setString(2, lnameQ2TF.getText());
                result = state.executeQuery();
                tableQ2.setModel(new MyModel(result));
                clearFormQ2();
                refreshTableTB();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
