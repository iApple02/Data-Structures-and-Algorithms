public class TowerOfHanoi
{
    public static void tower(int n, int src, int dest)
    {
        int tmp;

        if (n <= 0)
        {
            throw new IllegalArgumentException("Cannot be less than or equal to 0");
        }
        if (n == 1)
        {
            moveDisk(n, src, dest); //base case: move one disk from peg src to peg dest
        }
        else
        {
            tmp = 6 - src - dest; //tmp is the other peg, since src+dest+tmp = 6
            tower(n-1, src, tmp); //Move all but bottom disk to temp peg tmp

            moveDisk(n, src, dest); //Move bottom disk to target peg dest
            tower(n-1, tmp, dest); //Move the rest from temp peg tmp to target peg dest
        }
    }

    private static void moveDisk(int n, int src, int dest)
    {
        String spacing = ""; //For Indentation

        for (int i = 0 ; i < n; i++) //Level of recursion spacing
        {
            spacing = spacing + "   "; //Add indentation for every level of recursion
        }

        System.out.println(spacing + "Moving top disk from peg " + src + " to peg " + dest);
    }
}