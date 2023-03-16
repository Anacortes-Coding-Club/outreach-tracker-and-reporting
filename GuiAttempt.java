import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GuiAttempt{
    boolean saveType; //false for add, true for replace
    int index; /*for replacing things in ParseMD.inputs*/
    
    String input;
    JFrame frame = new JFrame("Will it work?");
    JPanel editPanel = new JPanel();
    JPanel menuPanel = new JPanel();
    JTextArea area = new JTextArea();
    JList<String> tags = new JList<String>(Taggable.tokens);
    JList<String> inputs = new JList<String>((String[])ParseMD.inputs.toArray());

    public void go(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new clslstnr());
        frame.setSize(100, 100);
        frame.setVisible(true);
        frame.add(menu());
    }
    
    private void newVisit(){
        saveType = false;
        frame.remove(menuPanel);
        frame.add(inputter("@Date"));
    }

    private void editVisit(int i){
        index = i;
        saveType = true;
        frame.remove(menuPanel);
        frame.add(inputter(ParseMD.inputs.get(i)));
    }

    private void save(){
        if(area.getText() != ""){
            if(saveType){
                ParseMD.inputs.remove(index);
                ParseMD.inputs.add(index, area.getText());
            }else{
                ParseMD.inputs.add(area.getText());
            }
            area.setText("");
            frame.remove(editPanel);
            frame.add(menu());
        }
    }

    private JPanel menu(){
        inputs.setVisibleRowCount(6);
        inputs.addListSelectionListener(new inplstnr());
        JScrollPane scrl = new JScrollPane(inputs);
        scrl.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrl.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nvst = new JButton("New Visit");
        nvst.addActionListener(new nvstlstnr());

        menuPanel.add(scrl, BorderLayout.WEST);
        menuPanel.add(nvst, BorderLayout.EAST);
        return menuPanel;
    }

    private JPanel inputter(String start){
        //editPanel is an instance variable because the listener classes might need to access it
        
        //setup text area
        //area is an instance variable because the listener classes need to access it
        area.setText(start);
        area.setLineWrap(true);
        area.requestFocus();
        JScrollPane scrl = new JScrollPane(area);
        scrl.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrl.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //setup the buttons
        JButton nprsn = new JButton("New Person");
        nprsn.addActionListener(new nplstnr());

        JButton save = new JButton("Save");
        save.addActionListener(new svlstnr());

        JButton cncl = new JButton("Cancel");
        cncl.addActionListener(new cnclstnr());

        //tags is an instance variable because the listener classes need to access it
        tags.setVisibleRowCount(3);
        tags.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tags.addListSelectionListener(new tglstnr());
        JScrollPane tgscrl = new JScrollPane(tags);
        tgscrl.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tgscrl.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //setup toolbar editPanel and add tools to it
        JPanel toolbar = new JPanel();
        toolbar.add(save);
        toolbar.add(nprsn);
        toolbar.add(tags);

        //add everything to the editPanel
        editPanel.add(scrl, BorderLayout.CENTER);
        editPanel.add(toolbar, BorderLayout.SOUTH);

        return editPanel;
    }
    public class  nplstnr implements ActionListener{
        public void actionPerformed(ActionEvent event){
            area.append("\n+");
        }
    }
    public class  svlstnr implements ActionListener{
        public void actionPerformed(ActionEvent event){
            save();
        }
    }
    public class  tglstnr implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent event){
            if(!event.getValueIsAdjusting()){
                String a = tags.getSelectedValue();
                area.append(a);
            }
        }
    }
    public class  cnclstnr implements ActionListener{
        public void actionPerformed(ActionEvent event){
            area.setText("");
            frame.remove(editPanel);
            frame.add(menu());
        }
    }
    public class  clslstnr implements WindowListener{
        public void windowClosing(WindowEvent wv){
            save();
        }
        public void windowOpened(WindowEvent a){}
        public void windowDeiconified(WindowEvent a){}
        public void windowActivated(WindowEvent a){}
        public void windowClosed(WindowEvent a){}
        public void windowDeactivated(WindowEvent a){}
        public void windowIconified(WindowEvent a){}
    }
    public class  inplstnr implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent event){
            if(!event.getValueIsAdjusting()){
                editVisit(inputs.getSelectedIndex());
            }
        }
    }
    public class  nvstlstnr implements ActionListener{
        public void actionPerformed(ActionEvent event){
            newVisit();
        }
    }
}