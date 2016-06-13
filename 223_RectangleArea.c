/* Analysis
Area1 + Area2 - Intersection
*/

int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int area1 = (C - A) * (D - B);
    int area2 = (G - E) * (H - F);
    
    if(A >= G || E >= C || B >= H || F >= D )
        return area1 + area2;
    
    int top = (D <= H ? D: H);
    int bottom = (B >= F? B: F);
    int left = (A >= E? A: E);
    int right = (C <= G? C: G);
    
    return area1 + area2 - (right - left) * (top - bottom);
}
