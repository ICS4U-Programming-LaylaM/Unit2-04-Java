import java.util.Scanner;

/**
* This program tells the user how to play the towers of hanoi
* in the least amount of moves.
*
* @author Layla Michel
* @version 1.0
* @since 2022-04-12
*/

public class TowersOfHanoi {
    /**
    * Default empty constructor.
    */
    public TowersOfHanoi() { }

    /**
    * Creating function to display which moves to do in towers of hanoi.
    *
    * @param diskNumber as int
    * @param firstPeg as int
    * @param middlePeg as int
    * @param lastPeg as int
    */
    public void hanoi(int diskNumber, int firstPeg,
            int middlePeg, int lastPeg) {
        if (diskNumber == 1) {
            // Default case
            System.out.println("Disk 1 moved from peg " + firstPeg + " to "
                + "peg " + lastPeg);
        } else {
            // Move disk diskNumber-1 from firstPeg to middlePeg
            // using lastPeg as the middlePeg
            hanoi(diskNumber - 1, firstPeg, lastPeg, middlePeg);

            // Move last disk from firstPeg to lastPeg
            System.out.println("Disk " + diskNumber + " moved from peg "
                    + firstPeg + " to peg " + lastPeg);

            // Move disk diskNumber-1 from middlePeg to lastPeg
            // using firstPeg as middlePeg
            hanoi(diskNumber - 1, middlePeg, firstPeg, lastPeg);
        }
    }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    */
    public static void main(String[] args) {
        // Declare variables
        final int startPeg = 1;
        final int middlePeg = 2;
        final int endPeg = 3;
        final Scanner myObj;
        String diskNumStr;
        int diskNumInt;

        myObj = new Scanner(System.in);

        // Create a binary search object
        final TowersOfHanoi towersOfHanoi = new TowersOfHanoi();

        System.out.println("Towers of Hanoi\n");

        while (true) {
            System.out.print("How many disks do you want to use?: ");
            diskNumStr = myObj.nextLine();

            try {
                diskNumInt = Integer.parseInt(diskNumStr);
                if (diskNumInt > 0) {
                    towersOfHanoi.hanoi(diskNumInt, startPeg,
                        middlePeg, endPeg);
                    break;
                } else {
                    // Error message if input is 0 or negative
                    System.out.println("Please enter a positive integer.\n");
                }
            } catch (NumberFormatException ex) {
                // Error message if input isn't an integer
                System.out.println("Please enter a valid integer.\n");
            }
        }
        myObj.close();
    }
}
