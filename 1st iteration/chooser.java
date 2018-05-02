import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Filechooser extends JPanel implements ActionListener{

    static private final String newline = "\n";
    JButton openFileButton, saveButton, openDirButton;
    JTextArea log;
    JFileChooser fc;
    JFileChooser fc_sub;
    public Filechooser() {
        super(new BorderLayout());
 
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
        
        fc = new JFileChooser();
        fc_sub = new JFileChooser();
        fc_sub.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        openDirButton = new JButton("폴더를 엽니다.",createImageIcon("images/Open16.gif"));
        openDirButton.addActionListener(this);
        //////////////////////////////////////////////////////////
        openFileButton = new JButton("파일을 엽니다.",
                                 createImageIcon("/Users/jaewon/Desktop/java/sample1.gif"));
        openFileButton.addActionListener(this);
 
        saveButton = new JButton("파일을 저장합니다.",
                                 createImageIcon("/Users/jaewon/Desktop/java/sample1.gif"));
        saveButton.addActionListener(this);
 
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openDirButton); 
        buttonPanel.add(openFileButton);
        buttonPanel.add(saveButton);
        
 
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
 
    public void actionPerformed(ActionEvent e) {
    		Calendar date = Calendar.getInstance();
    		int year = date.get(Calendar.YEAR);
    		int month = date.get(Calendar.MONTH)+1;
    		int day = date.get(Calendar.DAY_OF_MONTH); 
    		
        if(e.getSource() == openDirButton) {
        		int returnVal = fc.showOpenDialog(Filechooser.this);
        		
        		if(returnVal == JFileChooser.APPROVE_OPTION) {
        			File file = fc.getSelectedFile();
        			log.append("디렉토리를 엽니다. "+ file.getName() + "." + newline);
        			log.append("작성날짜: "+year+"년"+month+"월"+day+"일");
        		} else {
        			log.append("디렉토리 열기가 취소되었습니다.." + newline);
        		}
        		log.setCaretPosition(log.getDocument().getLength());
        }
    		else if (e.getSource() == openFileButton) {
            int returnVal = fc.showOpenDialog(Filechooser.this);
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                log.append("파일을 엽니다. " + file.getName() + "." + newline);
                log.append("작성날짜: "+year+"년"+month+"월"+day+"일");
            } else {
                log.append("파일열기가 취소되었습니다.." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
 
        } else if (e.getSource() == saveButton) {    
        	int returnVal = fc.showSaveDialog(Filechooser.this);
        	int returnVal2 = fc_sub.showSaveDialog(Filechooser.this); 
        		if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                log.append("파일을 저장합니다.: " + file.getName() + "." + newline);
                log.append("작성날짜: "+year+"년"+month+"월"+day+"일");
            }else if(returnVal2 ==JFileChooser.APPROVE_OPTION){
            		File file = fc_sub.getSelectedFile();
                log.append("파일을 저장합니다.: " + file.getName() + "." + newline);
                log.append("작성날짜: "+year+"년"+month+"월"+day+"일");
            }
            	else {
            
                log.append("파일저장 실행이 취소되었습니다.." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }
 
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Filechooser.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("해당 이미지 파일을 볼러올 수 없습니다.: " + path);
            return null;
        }
    }

    // 확장자 필터링 
  /*  String[] filterArr = new String[] {
    		".jpg",".png",".gif",".jpeg"};
    
  FileFileter filter = ()
    //FileFilter filter = new FileNameExtensionFilter(null, filterArr);
   fc.addChoosableFileFilter(filter);
    */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Filechooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Filechooser());
        frame.pack();
        frame.setVisible(true);
    }
    public static void getInstanceof() {
    		Filechooser.createAndShowGUI(); 
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });
    }
}
