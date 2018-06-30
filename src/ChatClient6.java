import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient6 extends Frame {

    TextField tfTxt = new TextField();
    TextArea taContext = new TextArea();

    public static void main(String[] args){
        ChatClient6 cc = new ChatClient6();
        cc.launchFrame();
    }

    public void launchFrame(){
        setLocation(300,400);
        setSize(300,300);
        add(taContext, BorderLayout.NORTH);
        add(tfTxt,BorderLayout.SOUTH);
        pack();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tfTxt.addActionListener(new TFListener());
        setVisible(true);
        connect(); //new
    }

    public void connect() {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
System.out.println("Connected!");
        }catch (UnknownHostException e){ // import java.net.*;
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private class TFListener implements ActionListener{
        public void actionPerformed(ActionEvent E){
            String s = tfTxt.getText().trim();
            taContext.setText(s);
            tfTxt.setText("");
        }
    }
}
