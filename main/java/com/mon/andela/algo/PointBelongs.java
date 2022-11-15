package com.mon.andela.algo;

public class PointBelongs {

    public static int pointBelongs(int x1, int y1, int x2, int y2, int x3, int y3,int xp, int yp, int xq, int yq){
        double originalArea = area(x1,y1, x2, y2, x3, y3);
        double pArea = area(x1,y1, x2, y2, xp, yp) + area(x1,y1, xp, yp, x3, y3) + area(xp,yp, x2, y2, x3, y3);
        double qArea = area(x1,y1, x2, y2, xq, yq) + area(x1,y1, xq, yq, x3, y3) + area(xq,yq, x2, y2, x3, y3);
        System.out.println("originalArea = " + originalArea);
        System.out.println("pArea = " + pArea);
        System.out.println("qArea = " + qArea);

        boolean pBelongs = originalArea == pArea;
        boolean qBelongs = originalArea == qArea;

        if(originalArea == 0) return 0;
        if(pBelongs && !qBelongs) return 1;
        if(!pBelongs && qBelongs) return 2;
        if(pBelongs && qBelongs) return 3;
        if(!pBelongs && !qBelongs) return 4;
        return -1;

    }

    private static double area(int x1, int y1, int x2, int y2, int x3, int y3){
        double area = (0.5) * ((x1 * (y2-y3)) + (x2 *(y3 -y1)) + x3*(y1-y2));
        return Math.abs(area);
    }

    public static void main(String[] args) {
        int sol = pointBelongs(2,2, 7, 2, 5, 4, 4, 3, 7, 4);
        System.out.println("sol = " + sol); // 1
    }
}
