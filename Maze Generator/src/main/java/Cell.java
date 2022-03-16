/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jadams20
 */
public class Cell {
    public int i;
    public int j;
    public int ifrom;
    public int jfrom;
    int walls = 4;
    boolean visited = false;
    public Cell(int i,int j){
        this.i = i;
        this.j = j;
    }
    public Cell(){
        this.i = 0;
        this.j = 0;
    }
    public int Walls(){
        return walls;
    }
    public void setWalls(int wall){
        walls = wall;
    }
    public void visited(boolean answer){
        this.visited = answer;
    }
    public boolean isVisited(){
        return visited;
    }
    public void cameFrom(int i,int j){
        this.ifrom = i;
        this.jfrom = j;
    }
    public String fromDir(){
        if(i-ifrom==1) return("left");
        else if(i-ifrom==-1) return("right");
        else if(j-jfrom==1) return("top");
        else if(j-jfrom==-1) return("bottom");
        return("nofrom");
    }

}
