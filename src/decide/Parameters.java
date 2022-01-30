package decide;

public class Parameters{

    double LENGTH1; // Length in LICs 0, 7, 12
    double RADIUS1 ; // Radius in LICs 1, 8, 13
    double EPSILON ; // Deviation from PI in LICs 2, 9
    double AREA1; // Area in LICs 3, 10, 14
    int Q_PTS ; // No. of consecutive points in LIC 4
    int QUADS; // No. of quadrants in LIC 4
    double DIST ; // Distance in LIC 6
    int N_PTS ; // No. of consecutive pts. in LIC 6
    int K_PTS ; // No. of int. pts. in LICs 7, 12
    int A_PTS ; // No. of int. pts. in LICs 8, 13
    int B_PTS ; // No. of int. pts. in LICs 8, 13
    int C_PTS ; // No. of int. pts. in LIC 9
    int D_PTS ; // No. of int. pts. in LIC 9
    int E_PTS ; // No. of int. pts. in LICs 10, 14
    int F_PTS ; // No. of int. pts. in LICs 10, 14
    int G_PTS ; // No. of int. pts. in LIC 11
    double LENGTH2; // Maximum length in LIC 12
    double RADIUS2 ; // Maximum radius in LIC 13
    double AREA2; // Maximum area in LIC 14

    public Parameters(double length1, double radius1, double epsilon, double area1, int q_pts, int quads, double dist,
                      int n_pts, int k_pts, int a_pts, int b_pts, int c_pts, int d_pts, int e_pts, int f_pts, int g_pts,
                      double length2, double radius2, double area2){
        this.LENGTH1 = length1;
        this.RADIUS1 = radius1;
        this.EPSILON = epsilon;
        this.AREA1 = area1;
        this.Q_PTS = q_pts;
        this.QUADS = quads;
        this.DIST = dist;
        this.N_PTS = n_pts;
        this.K_PTS = k_pts;
        this.A_PTS = a_pts;
        this.B_PTS = b_pts;
        this.C_PTS = c_pts;
        this.D_PTS = d_pts;
        this.E_PTS = e_pts;
        this.F_PTS = f_pts;
        this.G_PTS = g_pts;
        this.LENGTH2 = length2;
        this.RADIUS2 = radius2;
        this.AREA2 = area2;
    }
}