package ie.lennon.minesweeper;

public class MineSweeper {

    private MineSweeper(){}

    private static final String MINE ="*";

    public static String[][] hint(String[][] mineField){
        String [][] hintField = new String [mineField.length][mineField[0].length];

        int rows = mineField.length;
        int columns = mineField[0].length;

        // row
        for(int row = 0; row< rows; row++){

            for (int column=0; column< columns; column++){
                if(mineField[row][column].equals(MINE)){
                    hintField[row][column] = MINE;
                    continue;
                }
                int count =0;

                //Top left
                if(row==0 && column==0){
                    //cell right
                    if(mineField[0][1].equals(MINE)){
                        count++;
                    }
                    //cell below right
                    if(mineField[1][1].equals(MINE)){
                        count++;
                    }
                    //cell below
                    if(mineField[1][0].equals(MINE)){
                        count++;
                    }
                }

                //Top right
                if(row==0 && column==columns-1){
                    //cell left
                    if(mineField[0][column-1].equals(MINE)){
                        count++;
                    }
                    //cell bottom left
                    if(mineField[1][column-1].equals(MINE)){
                        count++;
                    }
                    //cell bottom
                    if(mineField[1][column].equals(MINE)){
                        count++;
                    }

                }

                //Bottom left
                if(row==rows-1 && column==0){
                    if(mineField[row][1].equals(MINE)){
                        count++;
                    }
                    if(mineField[row-1][0].equals(MINE)){
                        count++;
                    }
                    if(mineField[row-1][1].equals(MINE)){
                        count++;
                    }
                }
                //Bottom right
                if(row==rows-1 && column==columns-1){
                    //cell right
                    if(mineField[row-1][column-1].equals(MINE)){
                        count++;
                    }
                    if(mineField[row-1][column].equals(MINE)){
                        count++;
                    }
                    if(mineField[row][column-1].equals(MINE)){
                        count++;
                    }
                }




                //Top center
                if(row==0 && (column>0 && column<columns-1)){
                    if(mineField[0][column-1].equals(MINE)){
                        count++;
                    }
                    if(mineField[0][column+1].equals(MINE)){
                        count++;
                    }
                    if(mineField[1][column-1].equals(MINE)){
                        count++;
                    }
                    if(mineField[1][column].equals(MINE)){
                        count++;
                    }
                    if(mineField[1][column+1].equals(MINE)){
                        count++;
                    }
                }




                //left center

                //bottom left



                //Normal field
                else if((row>0 && column>0) && (row<(rows-1) && column<(columns-1)) ){

                    if(mineField[row-1][column-1].equals(MINE)){
                        count++;
                    }
                    if(mineField[row][column-1].equals(MINE)){
                        count++;
                    }
                    if(mineField[row+1][column-1].equals(MINE)){
                        count++;
                    }
                    if(mineField[row-1][column].equals(MINE)){
                        count++;
                    }
                    if(mineField[row+1][column].equals(MINE)){
                        count++;
                    }
                    if(mineField[row-1][column+1].equals(MINE)){
                        count++;
                    }
                    if(mineField[row][column+1].equals(MINE)){
                        count++;
                    }
                    if(mineField[row+1][column+1].equals(MINE)){
                        count++;
                    }

                }


                hintField[row][column] = Integer.toString(count);
            }
        }

//        String temp[][] = {{"*", "1", "0", "0"},
//                {"2", "2", "1", "0"},
//                {"1", "*", "1", "0"},
//                {"1", "1", "1", "0"}};

        return hintField;
    }

}
