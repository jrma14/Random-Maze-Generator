/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author jadams20
 */
public class Grid {
    Random r = new Random();
    private boolean restart = false;
    private int test = 1;
    private int next;
    private final int cols;
    private final int rows;
    private boolean neighborsLeft = true;
    private final int num[]= {-1,1};

    public Grid(int cols, int rows)
    {
        this.cols = cols;
        this.rows = rows;
    }

    public Cell[][] Grid()
    {
        Cell[][] grid = new Cell[cols][rows];
        for(int i = 0;i<cols;i++)
        {
            for(int j = 0;j<rows;j++)
            {
                grid[i][j] = new Cell(i,j);
            }
        }
      /*  for(int i = 0;i<cols;i++)
        {
            for(int j = 0;j<rows;j++)
            {
                System.out.println(grid[i][j].i + " " + grid[i][j].j);
            }
        }*/
        return grid;
    }

    public boolean hasNeighbors(Cell[][] grid,Cell cell)
    {
        /*int plusminus = (int)Math.random()*3-1;
        if(grid[cell.i+plusminus][cell.j+plusminus].isVisited()){
        hasNeighbors(grid,cell);
        }*/
        if(cell.i == 0 && cell.j!=0 && cell.j!=this.rows-1)
        {
            return !(grid[cell.i][cell.j+1].isVisited()&&grid[cell.i+1][cell.j].isVisited()&&grid[cell.i][cell.j-1].isVisited());
        }
        else if(cell.i == 0 && cell.j==0)
        {
            return !(grid[cell.i+1][cell.j].isVisited()&&grid[cell.i][cell.j+1].isVisited());
        }
        else if(cell.i == 0 && cell.j==this.rows-1)
        {
            return !(grid[cell.i][cell.j-1].isVisited()&&grid[cell.i+1][cell.j].isVisited());
        }
        else if(cell.j == 0 && cell.i!=this.cols-1)
        {
            return !(grid[cell.i-1][cell.j].isVisited()&&grid[cell.i][cell.j+1].isVisited()&&grid[cell.i+1][cell.j].isVisited());
        }
        else if(cell.j == 0 && cell.i==this.cols-1)
        {
            return !(grid[cell.i][cell.j+1].isVisited()&&grid[cell.i-1][cell.j].isVisited());
        }
        else if(cell.i == this.cols-1 && cell.j!=0 && cell.j!=this.rows-1)
        {
            return !(grid[cell.i][cell.j+1].isVisited()&&grid[cell.i-1][cell.j].isVisited()&&grid[cell.i][cell.j-1].isVisited());
        }
        else if(cell.i == this.cols-1 && cell.j==this.rows-1)
        {
            return !(grid[cell.i-1][cell.j].isVisited()&&grid[cell.i][cell.j-1].isVisited());
        }
        else if(cell.j==this.rows-1&&cell.i!=0 && cell.i!=this.cols-1)
        {
            return !(grid[cell.i+1][cell.j].isVisited()&&grid[cell.i-1][cell.j].isVisited()&&grid[cell.i][cell.j-1].isVisited());
        }
        return !(grid[cell.i-1][cell.j].isVisited()&&grid[cell.i+1][cell.j].isVisited()&&grid[cell.i][cell.j-1].isVisited()&&grid[cell.i][cell.j+1].isVisited());
    }

    public Cell random(Cell[][] grid, Cell cell)
    {
        if(test==1) next = num[r.nextInt(2)];
        if(restart)
        {
            next*=-1;
            restart = false;
        }
        grid[cell.i][cell.j].visited(true);
        if(cell.i == 0 || cell.j == 0 || cell.i == this.cols - 1 || cell.j == this.rows - 1)
        {
            if(cell.i == 0 && cell.j == 0)
            {
                if(r.nextBoolean())
                {
                    if(!grid[cell.i+1][cell.j].isVisited())
                    {
                        test = 1;
                        grid[cell.i+1][cell.j].cameFrom(cell.i,cell.j);
                        grid[cell.i+1][cell.j].visited(true);
                        return grid[cell.i+1][cell.j];
                    }
                }
                else
                {
                    if(!grid[cell.i][cell.j+1].isVisited())
                    {
                        test = 1;
                        grid[cell.i][cell.j+1].cameFrom(cell.i,cell.j);
                        grid[cell.i][cell.j+1].visited(true);
                        return grid[cell.i][cell.j+1];
                    }
                }
            }


            else if(cell.i==0 && cell.j==this.rows-1)
            {
                if(r.nextBoolean())
                {
                    if(!grid[cell.i+1][cell.j].isVisited())
                    {
                        test = 1;
                        grid[cell.i+1][cell.j].cameFrom(cell.i,cell.j);
                        grid[cell.i+1][cell.j].visited(true);
                        return grid[cell.i+1][cell.j];
                    }
                }
                else
                {
                    if(!grid[cell.i][cell.j-1].isVisited())
                    {
                        test = 1;
                        grid[cell.i][cell.j-1].cameFrom(cell.i,cell.j);
                        grid[cell.i][cell.j-1].visited(true);
                        return grid[cell.i][cell.j-1];
                    }
                }
            }


            else if(cell.i==this.cols-1 && cell.j==this.rows-1)
            {
                if(r.nextBoolean())
                {
                    if(!grid[cell.i-1][cell.j].isVisited())
                    {
                        test = 1;
                        grid[cell.i-1][cell.j].cameFrom(cell.i,cell.j);
                        grid[cell.i-1][cell.j].visited(true);
                        return grid[cell.i-1][cell.j];
                    }
                }
                else
                {
                    if(!grid[cell.i][cell.j-1].isVisited())
                    {
                        test = 1;
                        grid[cell.i][cell.j-1].cameFrom(cell.i,cell.j);
                        grid[cell.i][cell.j-1].visited(true);
                        return grid[cell.i][cell.j-1];
                    }
                }
            }


            else if(cell.i==this.cols-1&&cell.j==0)
            {
                if(r.nextBoolean())
                {
                    if(!grid[cell.i-1][cell.j].isVisited())
                    {
                        test = 1;
                        grid[cell.i-1][cell.j].cameFrom(cell.i,cell.j);
                        grid[cell.i-1][cell.j].visited(true);
                        return grid[cell.i-1][cell.j];
                    }
                }
                else
                {
                    if(!grid[cell.i][cell.j+1].isVisited())
                    {
                        test = 1;
                        grid[cell.i][cell.j+1].cameFrom(cell.i,cell.j);
                        grid[cell.i][cell.j+1].visited(true);
                        return grid[cell.i][cell.j+1];
                    }
                }
            }


            else if(cell.i==0)
            {
                if(r.nextBoolean())
                {
                    if(!grid[cell.i+1][cell.j].isVisited())
                    {
                        test = 1;
                        grid[cell.i+1][cell.j].cameFrom(cell.i,cell.j);
                        grid[cell.i+1][cell.j].visited(true);
                        return grid[cell.i+1][cell.j];
                    }
                }
                else
                {
                    if(!grid[cell.i][cell.j+next].isVisited())
                    {
                        test = 1;
                        grid[cell.i][cell.j+next].cameFrom(cell.i,cell.j);
                        grid[cell.i][cell.j+next].visited(true);
                        return grid[cell.i][cell.j+next];
                    }
                }
            }


            else if(cell.i==this.cols-1)
            {
                if(r.nextBoolean())
                {
                    if(!grid[cell.i-1][cell.j].isVisited())
                    {
                        test = 1;
                        grid[cell.i-1][cell.j].cameFrom(cell.i,cell.j);
                        grid[cell.i-1][cell.j].visited(true);
                        return grid[cell.i-1][cell.j];
                    }
                }
                else
                {
                    if(!grid[cell.i][cell.j+next].isVisited())
                    {
                        test = 1;
                        grid[cell.i][cell.j+next].cameFrom(cell.i,cell.j);
                        grid[cell.i][cell.j+next].visited(true);
                        return grid[cell.i][cell.j+next];
                    }
                }
            }


            else if(cell.j==0)
            {
                if(r.nextBoolean())
                {
                    if(!grid[cell.i+next][cell.j].isVisited())
                    {
                        test = 1;
                        grid[cell.i+next][cell.j].cameFrom(cell.i,cell.j);
                        grid[cell.i+next][cell.j].visited(true);
                        return grid[cell.i+next][cell.j];
                    }
                }
                else
                {
                    if(!grid[cell.i][cell.j+1].isVisited())
                    {
                        test = 1;
                        grid[cell.i][cell.j+1].cameFrom(cell.i,cell.j);
                        grid[cell.i][cell.j+1].visited(true);
                        return grid[cell.i][cell.j+1];
                    }
                }
            }


            else if (cell.j==this.rows-1)
            {
                if(r.nextBoolean())
                {
                    if(!grid[cell.i+next][cell.j].isVisited())
                    {
                        test = 1;
                        grid[cell.i+next][cell.j].cameFrom(cell.i,cell.j);
                        grid[cell.i+next][cell.j].visited(true);
                        return grid[cell.i+next][cell.j];
                    }
                }
                else
                {
                    if(!grid[cell.i][cell.j-1].isVisited())
                    {
                        test = 1;
                        grid[cell.i][cell.j-1].cameFrom(cell.i,cell.j);
                        grid[cell.i][cell.j-1].visited(true);
                        return grid[cell.i][cell.j-1];
                    }
                }
            }
        }




        else
        {
            if(r.nextBoolean())
            {
                if(!grid[cell.i+next][cell.j].isVisited())
                {
                    test = 1;
                    grid[cell.i+next][cell.j].cameFrom(cell.i,cell.j);
                    grid[cell.i+next][cell.j].visited(true);
                    return grid[cell.i+next][cell.j];
                }
            }
            else
            {
                if(!grid[cell.i][cell.j+next].isVisited()){
                    test = 1;
                    grid[cell.i][cell.j+next].cameFrom(cell.i,cell.j);
                    grid[cell.i][cell.j+next].visited(true);
                    return grid[cell.i][cell.j+next];
                }
            }
        }
        if(hasNeighbors(grid,cell))
        {
            restart = true;
            cell = random(grid,cell);
        }
        grid[cell.i][cell.j].visited(true);
        return cell;
    }

    public boolean neighborsLeft(Cell[][] grid)
    {
        for(int i = 0;i<cols;i++)
        {
            for(int j = 0;j<rows;j++)
            {
                if(!grid[i][j].isVisited())
                {
                    neighborsLeft = true;
                    return neighborsLeft;
                }
            }
        }
        neighborsLeft = false;
        return neighborsLeft;
    }
}