package ProblemReviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
    private JButton nextProblemButton;
    private JPanel MainPanel;
    private JTextField textUrl;
    private JButton addProblemButton;
    private JButton knowButton;
    private JButton notKnowButton;
    private Problem currentProblem;
    static SwingFXWebView webview;
    static Reviewer reviewer = new Reviewer();

    public MainUI() {
        nextProblemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentProblem = reviewer.getRandomRecord();
                if(currentProblem!=null){
                    textUrl.setText(currentProblem.URL);
                    webview.loadURL(currentProblem.URL);
                } else {
                    textUrl.setText("No Problems");
                }
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
            }
        });
    }

    public static void main(String[] args) {
        reviewer.init();

        // Run this later:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("MainUI");

                frame.setContentPane(new MainUI().MainPanel);
                GridBagConstraints c = new GridBagConstraints();
                c.anchor = GridBagConstraints.PAGE_END;
                c.gridx = 0;
                c.gridy = 1;
                c.weighty = 1.0;
                c.weightx = 1.0;
                c.fill = GridBagConstraints.BOTH;
                webview = new SwingFXWebView();
                frame.getContentPane().add(webview, c);
                frame.setMinimumSize(new Dimension(1320, 900));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
