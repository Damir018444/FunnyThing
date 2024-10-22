import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon("src/BACYA.jpg"));

        Runtime runtime = Runtime.getRuntime();

        runtime.exec("nircmd.exe mutesysvolume 0");
        runtime.exec("nircmd changesysvolume +65535"); // +65535

        File file = new File("src/jumpscare.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        label.setVisible(true);

        frame.add(label);
        frame.setUndecorated(true);
        frame.setLocation(0,0);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
        frame.setVisible(true);

    }
}
