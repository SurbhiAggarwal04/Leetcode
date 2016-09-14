package LeetCode;

public class TotalAreaOfTwoRectilineraRectangles {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(C<E || A>G || B>H || F>D)
        return (C-A)*(D-B) + (G-E)*(H-F);
        return (C-A)*(D-B) + (G-E)*(H-F) - (Math.min(C,G)-Math.max(A,E))*(Math.min(D,H)-Math.max(B,F));
    }
}
