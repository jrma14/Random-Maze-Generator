/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import processing.core.*;

/**
 *
 * @author jrmad
 */

@SuppressWarnings("serial")
public class P5Main extends PApplet{

    int size = 10;
    int cols = 160;
    int rows = 80;
    int starti = 5;
    int startj = 5;

    Grid table = new Grid(cols,rows);
    Cell[][] grid = table.Grid();
    Cell next = table.random(grid,grid[starti][startj]);

    @Override
    public void settings() {
        size(1920, 1080);
    }
    @Override
    public void setup(){
        for(int i = 0;i<cols;i++)
        {
            for(int j = 0;j<rows;j++){
                rect(i*size,j*size,size,size);
            }
        }
    }

    @Override
    public void draw(){
        while(table.neighborsLeft(grid)){
            String from = next.fromDir();
            eraseWall(from);
            while(table.hasNeighbors(grid, next))
            {
                from = next.fromDir();
                eraseWall(from);
                next = table.random(grid,grid[next.i][next.j]);
                from = next.fromDir();
                eraseWall(from);
            }
            int i = grid[grid[next.i][next.j].ifrom][grid[next.i][next.j].jfrom].i;
            int j = grid[grid[next.i][next.j].ifrom][grid[next.i][next.j].jfrom].j;
            int ifrom = grid[grid[next.i][next.j].ifrom][grid[next.i][next.j].jfrom].ifrom;
            int jfrom = grid[grid[next.i][next.j].ifrom][grid[next.i][next.j].jfrom].jfrom;
            next.i = i;
            next.j = j;
            next.ifrom = ifrom;
            next.jfrom = jfrom;
        }
    }

    void eraseWall(String from){
        stroke(255,255,255);

        if(from.equals("top"))
        {
            line(next.i*size,next.j*size,(next.i+1)*size,next.j*size);
        }
        if(from.equals("left"))
        {
            line(next.i*size,next.j*size,next.i*size,(next.j+1)*size);
        }
        if(from.equals("right"))
        {
            line(next.ifrom*size,next.j*size,next.ifrom*size,(next.j+1)*size);
        }
        if(from.equals("bottom"))
        {
            line(next.ifrom*size,next.jfrom*size,(next.i+1)*size,next.jfrom*size);
        }

    }


    /**
     * @param passedArgs the command line arguments
     */
    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] {P5Main.class.getName()};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}

