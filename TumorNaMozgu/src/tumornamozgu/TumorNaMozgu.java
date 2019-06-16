/*
 * Studentski projekat:
 * Aplikacija koja obavlja prepoznavanje kontura sa 2D snimaka DICOM formata
 * medicinskih slika. Program radi tako što na osnovu zadatog thresholda 
 * izvršava prepoznavanje tumora mozga. Kao rezultat se dobija nova slika
 * sa obeleženim delom mozga na koji se sumnja da je tumor. 
 */
package tumornamozgu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import ij.IJ;
import ij.ImagePlus;
import ij.io.Opener;
import java.awt.FlowLayout;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.pdfbox.exceptions.COSVisitorException;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDPage;
import org.pdfbox.pdmodel.edit.PDPageContentStream;
import org.pdfbox.pdmodel.font.PDType1Font;
import org.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;


/**
 *
 * @author Aleksandar Mihajlović
 */
public class TumorNaMozgu extends JFrame {
    
    public TumorNaMozgu(){
            Lekar lekar =new Lekar("Aleksandar","Mihajlovic");
            JButton b = new JButton("Unesi snimak");
            b.setBounds(300,330,200,40);
            JButton b1 = new JButton("Sačuvaj rezultat");
            b1.setBounds(500,330,200,40);
            JTextField t1=new JTextField();
            JTextField t2=new JTextField();
	    JTextField t3=new JTextField();
	    JTextArea t4=new JTextArea();
	    JTextField t5=new JTextField();
            JTextField t6=new JTextField();
            JTextField t7=new JTextField();
            JTextField t8=new JTextField();
            JTextField t9=new JTextField();
            JLabel l = new JLabel();
            l.setBounds(400,20,470,350);
            JLabel pac = new JLabel("<html>PODACI O PACIJENTU:");
            pac.setBounds(10,-140,300,300);
            JLabel ime=new JLabel("<html>IME:");
	    ime.setBounds(10,-70,300,300);
	    t1.setBounds(80,70,90,30);
	    JLabel prezime=new JLabel("<html>PREZIME:");
	    prezime.setBounds(10,-15,300,300);
	    t2.setBounds(80,120,90,30);
	    JLabel bg=new JLabel("<html>BROJ GODINA:");
	    bg.setBounds(200,-70,300,300);
	    t3.setBounds(300,70,90,30);
	    JLabel dija=new JLabel("<html>DIJAGNOZA:");
	    dija.setBounds(250,15,300,300);
	    t4.setBounds(280,190,230,120);
	    JLabel dcid=new JLabel("<html>ID LEKARA:");
	    dcid.setBounds(10,70,300,300);
	    t5.setBounds(125,210,90,30);
            JLabel datum = new JLabel("<html>DATUM PREGLEDA:");
            datum.setBounds(10,150,300,300);
            t9.setBounds(125,290,90,30);
            JLabel adresa = new JLabel("<html>ADRESA:");
            adresa.setBounds(200,-15,300,300);
            t6.setBounds(300,120,90,30);
            JLabel bt = new JLabel("<html>BR. TELEFONA:");
            bt.setBounds(420,-70,300,300);
            t7.setBounds(520,70,90,30);
            JLabel bk= new JLabel("<html>BR. KNJIŽICE:");
            bk.setBounds(420,-15,300,300);
            t8.setBounds(520,120,90,30);
            
            
            b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent izaberi) {
                        
	                  pathFinder b1 = new pathFinder();
		          Analyze o1 = new Analyze();
                          Opener o = new Opener();
                          ImagePlus slika2 = o.openImage(b1.path);
		          slika2.show();
		          o1.analyzing(b1.path);
                           
					 
			}    }    );
            b1.addActionListener(new ActionListener()  {
       public void actionPerformed(ActionEvent snimi)  {
                                String x1=t1.getText();
				String x2=t2.getText();
				String x3=t3.getText();
				String x4=t4.getText();
				String x5=t5.getText();
                                String x6=t6.getText();
                                String x7=t7.getText();
                                String x8=t8.getText();
                                String x9=t9.getText();
                                
				try{
			        PDDocument doc = new PDDocument();
			        PDPage page = new PDPage();
                    doc.addPage(page);
                    PDPageContentStream content = new PDPageContentStream(doc, page);
			        content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 26);
			        content.moveTextPositionByAmount(220, 750);
			        content.drawString("IZVESTAJ LEKARA");
			        content.endText();
			        content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 20);
			        content.moveTextPositionByAmount(80, 700);
			       
			        content.drawString("PACIJENT: " + x1 + ' ' + x2 );
			        content.endText();
			        content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 20);
			        content.moveTextPositionByAmount(80,650);
			        content.drawString("BROJ GODINA : " + x3);
			        content.endText();
			        content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 20);
			        content.moveTextPositionByAmount(80,600);
			        content.drawString("DIJAGNOZA: " +x4);
			        content.endText();
                                
                                content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 20);
			        content.moveTextPositionByAmount(80, 550);
			       
			        content.drawString("ID LEKARA: " + x5 );
			        content.endText();
                                
                                content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 20);
			        content.moveTextPositionByAmount(80, 500);
			       
			        content.drawString("ADRESA: " + x6 );
			        content.endText();
                                
                                content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 20);
			        content.moveTextPositionByAmount(80, 450);
			       
			        content.drawString("BROJ TELEFONA: " + x7 );
			        content.endText();
                                
                                content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 20);
			        content.moveTextPositionByAmount(80, 400);
			       
			        content.drawString("BROJ KNJIZICE: " + x8 );
			        content.endText();
                                
                                content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 20);
			        content.moveTextPositionByAmount(80, 350);
			       
			        content.drawString("DATUM PREGLEDA: " + x9 );
			        content.endText();
                                
                                
                                
			        content.beginText();
			        content.setFont(PDType1Font.HELVETICA, 15);
			        content.moveTextPositionByAmount(200,100);
			        content.drawString("IZABRANI LEKAR: " + lekar.getIme()+ " " + lekar.getPrezime());
			        content.endText();
			        content.close();
                                IJ.save("C:\\Users\\Aca\\Desktop\\snimak"+x1+x2+".JPG");
                                doc.save("C:\\Users\\Aca\\Desktop\\pacijent-"+x1+x2+".pdf");
			        doc.close();
			        }
			        catch(IOException | COSVisitorException e1){
			      }
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
                                t5.setText(null);
				t6.setText(null);
				t7.setText(null);
				t8.setText(null);
                                t9.setText(null);
                          
           }});           
            add(b); add(b1);add(pac); add(ime); add(prezime); add(bg); add(dija); add(dcid);add(adresa);add(bt);add(bk);add(datum); add(l);
	    add(t1); add(t2); add(t3); add(t4); add(t5); add(t6);add(t7);add(t8);add(t9);           
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Pronalaženje tumora na mozgu");
            setSize(750,450);
            setVisible(true);
            
            
    }
    public static void main(String[] args) {
        new TumorNaMozgu();
    }
    
}
