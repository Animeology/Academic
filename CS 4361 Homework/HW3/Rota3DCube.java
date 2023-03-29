public class Rota3DCube {

  public static void main(String[] args) {

    // check number of command line arguments
    if (args.length != 5) {
      System.out.println("Usage: java Rota3DCube a1 a2 a3 alpha axis");
      return;
    }

    // parse command line arguments
    int a1 = Integer.parseInt(args[0]);
    int a2 = Integer.parseInt(args[1]);
    int a3 = Integer.parseInt(args[2]);
    int alpha = Integer.parseInt(args[3]);
    String axis = args[4];

    // perform 3D rotation
    int[][] cube = rotate3DCube(a1, a2, a3, alpha, axis);

    // print results
    System.out.println("a1 = " + a1 + ", a2 = " + a2 + ", a3 = " + a3);
    System.out.println("alpha = " + alpha + ", axis = " + axis);
    System.out.println();
    System.out.println("Before Rotation");
    System.out.println("x\ty\tz");
    for (int i = 0; i < cube.length; i++) {
      System.out.println(cube[i][0] + "\t" + cube[i][1] + "\t" + cube[i][2]);
    }
    System.out.println();
    System.out.println("After Rotation");
    System.out.println("x\ty\tz");
    for (int i = 0; i < cube.length; i++) {
      System.out.println(cube[i][0] + "\t" + cube[i][1] + "\t" + cube[i][2]);
    }
    System.out.println();
  }

  public static int[][] rotate3DCube(int a1, int a2, int a3, int alpha, String axis) {

    // convert angle of rotation from degrees to radians
    double radians = Math.toRadians(alpha);

    // initialize array of vertices
    int[][] cube = new int[8][3];

    // vertices of unit cube centered at origin
    cube[0][0] = -1;
    cube[0][1] = -1;
    cube[0][2] = -1;
    cube[1][0] = -1;
    cube[1][1] = -1;
    cube[1][2] = 1;
    cube[2][0] = -1;
    cube[2][1] = 1;
    cube[2][2] = -1;
    cube[3][0] = -1;
    cube[3][1] = 1;
    cube[3][2] = 1;
    cube[4][0] = 1;
    cube[4][1] = -1;
    cube[4][2] = -1;
    cube[5][0] = 1;
    cube[5][1] = -1;
    cube[5][2] = 1;
    cube[6][0] = 1;
    cube[6][1] = 1;
    cube[6][2] = -1;
    cube[7][0] = 1;
    cube[7][1] = 1;
    cube[7][2] = 1;

    // translate vertices so that cube is centered at (a1, a2, a3)
    for (int i = 0; i < cube.length; i++) {
      cube[i][0] += a1;
      cube[i][1] += a2;
      cube[i][2] += a3;
    }

    // rotate cube
    if (axis.equals("x_axis")) {
      for (int i = 0; i < cube.length; i++) {
        int y = cube[i][1];
        int z = cube[i][2];
        cube[i][1] = (int) (y * Math.cos(radians) - z * Math.sin(radians));
        cube[i][2] = (int) (y * Math.sin(radians) + z * Math.cos(radians));
      }
    } else if (axis.equals("y_axis")) {
      for (int i = 0; i < cube.length; i++) {
        int x = cube[i][0];
        int z = cube[i][2];
        cube[i][0] = (int) (x * Math.cos(radians) + z * Math.sin(radians));
        cube[i][2] = (int) (-x * Math.sin(radians) + z * Math.cos(radians));
      }
    } else { // axis must be z_axis
      for (int i = 0; i < cube.length; i++) {
        int x = cube[i][0];
        int y = cube[i][1];
        cube[i][0] = (int) (x * Math.cos(radians) - y * Math.sin(radians));
        cube[i][1] = (int) (x * Math.sin(radians) + y * Math.cos(radians));
      }
    }

    return cube;
  }
}
