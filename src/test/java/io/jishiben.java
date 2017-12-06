package io;

import javax.xml.soap.Text;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

/**
 * Created by Administrator on 2017/10/18.
 */
public class jishiben {
    public static void main(String [] args){
        TextEdit TE = new TextEdit("记事本");
    }
}

class TextEdit extends Frame implements ActionListener{

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */

    MenuBar m;
    Menu m1,m2;
    MenuItem xinjian,dakai,baocun,tuichu,jianqie,fuzhi,zhantie;
    TextArea text ;
    String filename;
    FileDialog openFD,saveFD;
    BufferedReader in;
    FileReader read;
    BufferedWriter out;
    FileWriter writer;
    Clipboard cb;
    TextEdit(String s){
        m = new MenuBar();
        m1 = new Menu("文件");
        xinjian = new MenuItem("新建");
        dakai = new MenuItem("打开");
        baocun = new MenuItem("保存");
        tuichu = new MenuItem("退出");
        m2 = new Menu("编辑");
        jianqie = new MenuItem("剪切");
        fuzhi = new MenuItem("复制");
        zhantie = new MenuItem("粘贴");
        text = new TextArea();
        openFD = new FileDialog(this,"打开",FileDialog.LOAD);
        saveFD = new FileDialog(this,"保存",FileDialog.SAVE);
        filename = "noname";
        m1.add(xinjian);
        m1.addSeparator();
        m1.add(dakai);
        m1.addSeparator();
        m1.add(baocun);
        m1.addSeparator();
        m1.add(tuichu);
        m2.add(jianqie);
        m2.addSeparator();
        m2.add(fuzhi);
        m2.addSeparator();
        m2.add(zhantie);
        m.add(m1);
        m.add(m2);

        cb = new Clipboard("nothing"        );
        setMenuBar(m);
        setSize(300,400);
        setVisible(true);
        add(text,"Center");

        xinjian.addActionListener(this);
        dakai.addActionListener(this);
        baocun.addActionListener(this);
        tuichu.addActionListener(this);
        jianqie.addActionListener(this);
        fuzhi.addActionListener(this);
        zhantie.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==xinjian){
            text.setText("");
        }
        if (e.getSource()==dakai){
            openFD.show();
            String s;
            filename = openFD.getDirectory()+openFD.getFile();
            if (filename!=null){
                try{
                    File file = new File(filename);
                    read = new FileReader(file);
                    in = new BufferedReader(read);
                    while ((s = in.readLine())!=null){
                        text.append(s+'\n');

                    }
                    in.close();
                    read.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getSource()==baocun){
            saveFD.show();
            filename = saveFD.getDirectory()+saveFD.getFile();
            if (filename!=null){
                try{
                    File file = new File(filename);
                    writer = new FileWriter(file);
                    out = new BufferedWriter(writer);
                    out.write(text.getText(),0,(text.getText()).length());
                    out.close();;
                    writer.close();
                }catch (IOException e1){

                }
            }
        }
        if (e.getSource()==tuichu){
            System.exit(0);
        }






        if(e.getSource()==jianqie)
        {
            //类text中没有cut方法，不能使用text.cut
            String s=text.getSelectedText();
            StringSelection select=new StringSelection(s);
            cb.setContents(select,null);
            text.replaceRange("",text.getSelectionStart(),text.getSelectionEnd());
        }
        if(e.getSource()==fuzhi)
        {
            //同上，没有copy这个方法
            String s=text.getSelectedText();
            StringSelection select=new StringSelection(s);
            cb.setContents(select,null);
        }
        if(e.getSource()==zhantie)
        {
            //同上，没有paste方法
            String s="";
            Transferable t = cb.getContents(null);
            try
            {
                if (t != null
                        && t.isDataFlavorSupported(DataFlavor.stringFlavor))
                {
                    // 因为原系的剪贴板里有多种信息, 如文字, 图片, 文件等
                    // 先判断开始取得的可传输的数据是不是文字, 如果是, 取得这些文字

                    s = (String)t.getTransferData(DataFlavor.stringFlavor);
                    // 同样, 因为Transferable中的DataFlavor是多种类型的,
                    // 所以传入DataFlavor这个参数, 指定要取得哪种类型的Data.
                    //System.out.println(s);
                }
            }
            catch (UnsupportedFlavorException ex)
            {
                ex.printStackTrace();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }

            text.insert(s,text.getCaretPosition());

        }







    }




}
