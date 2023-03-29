import java.io.*;

public class Stairs {
   public static void main(String[] args) throws IOException {
      if (args.length != 3) {
         System.out.println("Three arguments(Supply n (> 0), a (>= 0.5) and a filename as program arguments.\n");
         System.exit(1);
      }
      int n = 0;
      double a = 0;
      try {
         n = Integer.valueOf(args[0]).intValue();
         a = Double.valueOf(args[1]).doubleValue();
         if (n <= 0 || a < 0.5)
            throw new NumberFormatException();
      } catch (NumberFormatException e) {
         System.out.println("n must be an integer > 0");
         System.out.println("a must be a real number >= 0.5");
         System.exit(1);
      }
      new StairsObj(n, a, args[2]);
   }
}

class StairsObj {

   FileWriter fw;

   StairsObj(int n, double a, String fileName)
         throws IOException {
      fw = new FileWriter(fileName);
      Point3D[] P = new Point3D[9];
      double b = a - 1;
      P[1] = new Point3D(a, -a, 0);
      P[2] = new Point3D(a, a, 0);
      P[3] = new Point3D(b, a, 0);
      P[4] = new Point3D(b, -a, 0);
      P[5] = new Point3D(a, -a, 1);
      P[6] = new Point3D(a, a, 1);
      P[7] = new Point3D(b, a, 1);
      P[8] = new Point3D(b, -a, 1);
      for (int k = 0; k < n; k++) { // Each Stairstep:
         int m = 8 * k;
         for (int i = 1; i <= 8; i++) {
            double x = P[i].x, y = P[i].y, z = P[i].z;
            float x1 = (float) (x) - (float) k,
                  y1 = (float) (y),
                  z1 = (float) (z + k);
            if (z == 0) {
               z1 = 0;
            }
            fw.write((m + i) + " " + x1 + " " + y1 + " " + z1 + "\r\n");
         }
      }
      fw.write("Faces:\r\n");
      for (int k = 0; k < n; k++) { // Beam k again:
         int m = 8 * k;
         face(m, 1, 2, 6, 5);
         face(m, 4, 8, 7, 3);
         face(m, 5, 6, 7, 8);
         face(m, 1, 4, 3, 2);
         face(m, 2, 3, 7, 6);
         face(m, 1, 5, 8, 4);
      }
      fw.close();
   }

   void face(int m, int a, int b, int c, int d) throws IOException {
      a += m;
      b += m;
      c += m;
      d += m;
      fw.write(a + " " + b + " " + c + " " + d + ".\r\n");
   }
}

class Point3D {
   float x, y, z;

   Point3D(double x, double y, double z) {
      this.x = (float) x;
      this.y = (float) y;
      this.z = (float) z;
   }
}