package ProblemReviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainUI {
    private JButton nextProblemButton;
    private JPanel MainPanel;
    private JTextField textUrl;
    private JButton addProblemButton;
    private JButton knowButton;
    private JButton notKnowButton;
    private JButton updateButton;
    private Problem currentProblem;
    // static SwingFXWebView webview;
    static Reviewer reviewer = new Reviewer();
    private static JFrame frame = null;

    public void nextProblem(){
        currentProblem = reviewer.getRandomRecord();
        if(currentProblem!=null){
            textUrl.setText(currentProblem.URL);
            frame.setTitle(reviewer.problemsLeft + " problems left");
            // webview.loadURL(currentProblem.URL);
            Desktop desk = Desktop.getDesktop();
            try {
                desk.browse(new URI(currentProblem.URL));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            textUrl.setText("No Problems");
        }
    }
    public MainUI() {
        nextProblemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                nextProblem();
            }
        });
        addProblemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddDialog addDialog = new AddDialog();
                addDialog.setVisible(true);
            }
        });
        knowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(currentProblem!=null){
                    currentProblem.stage++;
                    currentProblem.lastReview = java.util.Calendar.getInstance().getTime();
                    reviewer.saveReview();
                }
                nextProblem();
            }
        });
        notKnowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(currentProblem!=null){
                    currentProblem.stage=0;
                    currentProblem.strange++;
                    currentProblem.lastReview = java.util.Calendar.getInstance().getTime();
                    reviewer.saveReview();
                }
                nextProblem();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddDialog addDialog = new AddDialog();
                addDialog.setProblem(currentProblem);
                addDialog.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        reviewer.init();

        // Run this later:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //final JFrame frame = new JFrame("MainUI");
                frame = new JFrame("MainUI");

                frame.setContentPane(new MainUI().MainPanel);
                GridBagConstraints c = new GridBagConstraints();
                c.anchor = GridBagConstraints.PAGE_END;
                c.gridx = 0;
                c.gridy = 1;
                c.weighty = 1.0;
                c.weightx = 1.0;
                c.fill = GridBagConstraints.BOTH;
                // webview = new SwingFXWebView();
                // frame.getContentPane().add(webview, c);
                frame.setMinimumSize(new Dimension(800, 80));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setAlwaysOnTop(true);
                frame.pack();
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
                Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
                int taskbarheight = Toolkit.getDefaultToolkit().getScreenSize().height-ge.getMaximumWindowBounds().height;
                int x = ((int) rect.getMaxX() - frame.getWidth())/2;
                int y = (int) rect.getMaxY() - frame.getHeight() - taskbarheight;
                frame.setLocation(x, y);
                frame.setVisible(true);
            }
        });
    }
}
