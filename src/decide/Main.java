package decide;

public class Main {
    public static void main(String[] args) {

        int numpoints = 100;
        Coordinate[] points = new Coordinate[numpoints];
        // TODO fill points

        //dummy numbers
        // input: length1, radius1, epsilon, area1, q_pts, quads, n_pts, k_pts, a_pts, b_pts, c_pts, d_pts, e_pts,
        // f_pts, g_pts, length2, radius2, area2
        Parameters parameters = new Parameters(1.0, 1.0, 1.0, 1.0, 1, 1, 1.0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Connectors[][] lcm = new Connectors[15][15];
        boolean[][] pum = new boolean[15][15];
        Decider decider = new Decider(numpoints, points, parameters, lcm, pum);
        boolean decision = decider.decide();

        System.out.println(decision);
    }
}