package ProblemReviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textTitle;
    private JTextField textURL;
    private JTextField textTags;
    private JTextArea textNote;
    private Problem currentProblem = null;

    public AddDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setMinimumSize(new Dimension(640, 480));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public void setProblem(Problem updateProblem){
        currentProblem = updateProblem;
        textTitle.setText(currentProblem.title);
        textURL.setText(currentProblem.getURL());
        textTags.setText(currentProblem.tags);
        textNote.setText(currentProblem.note);
    }

    private void onOK() {
        //TODO: validator
        Reviewer reviewer = new Reviewer();
        reviewer.init();
        if(currentProblem==null) {
            Problem newProblem = new Problem(textTitle.getText(), textURL.getText(), textTags.getText());
            newProblem.note = textNote.getText();
            reviewer.addProblem(newProblem);
        } else {
            currentProblem.title = textTitle.getText();
            currentProblem.URL = textURL.getText();
            currentProblem.tags = textTags.getText();
            currentProblem.note = textNote.getText();
            reviewer.updateProblem(currentProblem);
            reviewer.saveReview();
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AddDialog dialog = new AddDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
