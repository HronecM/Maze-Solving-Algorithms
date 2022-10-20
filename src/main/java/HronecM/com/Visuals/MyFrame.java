package HronecM.com.Visuals;

import HronecM.com.Objects.Maze;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MyFrame extends JFrame implements ActionListener {

    JButton start;
    MyFrame(List<Maze> mazes) {
        //frame.add(new ControlsPane());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        String dir = System.getProperty("user.dir") + "\\src\\main\\resources\\";
        ImageIcon image = new ImageIcon(dir + "\\logo.png");
        this.setIconImage(image.getImage());

        Maze maze = mazes.get(0);
        JPanel bfsP = new MazePainter(maze, maze.getMazeGrid().length, maze.getMazeGrid()[0].length);
        JPanel dfsP = new MazePainter(maze, maze.getMazeGrid().length, maze.getMazeGrid()[0].length);
        JPanel dijkstraP = new MazePainter(maze, maze.getMazeGrid().length, maze.getMazeGrid()[0].length);
        JPanel AStarP = new MazePainter(maze, maze.getMazeGrid().length, maze.getMazeGrid()[0].length);
        JPanel controlsP = new JPanel();

        controlsP.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        JCheckBox dfs = new JCheckBox("Depth-search first");
        dfs.setFocusable(false);
        JCheckBox bfs = new JCheckBox("Breadth-search first");
        bfs.setFocusable(false);
        JCheckBox dst = new JCheckBox("Dijkstra");
        dst.setFocusable(false);
        JCheckBox ast = new JCheckBox("AStar");
        ast.setFocusable(false);
        start = new JButton("Start");
        start.setFocusable(false);

        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        controlsP.add(dfs,gbc2);
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        controlsP.add(bfs,gbc2);
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        controlsP.add(dst,gbc2);
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.gridx = 1;
        gbc2.gridy = 2;
        controlsP.add(ast,gbc2);
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.gridx = 0;
        gbc2.gridy = 3;
        gbc2.gridwidth = 2;
        start.addActionListener(this);
        controlsP.add(start,gbc2);

        bfsP.setBackground(Color.WHITE);
        dfsP.setBackground(Color.WHITE);
        dijkstraP.setBackground(Color.WHITE);
        AStarP.setBackground(Color.WHITE);
        controlsP.setBackground(Color.gray);

        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(bfsP, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(dfsP ,gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(dijkstraP,gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(AStarP,gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx=.5;
        gbc.weighty=.5;
        this.add(controlsP, gbc);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start) {
            //make it start all
        }
    }
}
