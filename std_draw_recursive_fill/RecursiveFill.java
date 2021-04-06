package lab3;

public class RecursiveFill {
	public static final int WIDTH = 1000, HEIGHT = 600;
	public static final int MIN_SIZE = 2; // 2
	public static final int MIN_SIZE_BONUS = 20;

	public static void main(String[] args) {
		StdDraw.setCanvasSize(WIDTH, HEIGHT);
		StdDraw.show(0);
		recursiveRectangleFill(0, 1, 0, 1);
//		 recursiveBonus(0,1,0,1); //comment-out one line to view the other
		StdDraw.show(0);
	}

	public static void recursiveRectangleFill(double minX, double maxX, double minY, double maxY){
		
		/* YOUR CODE HERE */
		if((maxX-minX)*WIDTH < MIN_SIZE || (maxY-minY)*HEIGHT < MIN_SIZE) {
			return;
		}
		
		double x_step = (maxX-minX)/3;
		double y_step = (maxY-minY)/3;
		
		// set color
		int r = (int) ( Math.random() * 255);
		int g = (int) ( Math.random() * 255);
		int b = (int) ( Math.random() * 255);
//		System.out.print(r + " " + g + " " + b + " ");
		StdDraw.setPenColor(r, g, b);
		
		// draw the center one
		double xc = minX+1.5*x_step;
		double yc = minY+1.5*y_step;
		double hw = x_step/2;
		double hh = y_step/2;
//		System.out.println(xc + " " + yc + " " + hw + " " + hh);
		StdDraw.filledRectangle(xc,yc,hw,hh);
		
		
		// the other 8 blocks
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i==1 && j==1) {
					
				}else {
					recursiveRectangleFill(minX+i*x_step, minX+(i+1)*x_step, 
							minY+j*y_step, minY+(j+1)*y_step);
				}
			}
		}
		
		
	}// recursiveRectangleFill

	public static void recursiveBonus(double minX, double maxX, double minY, double maxY) {

		/* YOUR CODE HERE */
		/* YOUR CODE HERE */
		if((maxX-minX)*WIDTH < MIN_SIZE*20 || (maxY-minY)*HEIGHT < MIN_SIZE*20) {
			return;
		}
		
		double x_step = (maxX-minX)/2;
		double y_step = (maxY-minY)/2;
		
		// set color
		int r = (int) ( Math.random() * 255);
		int g = (int) ( Math.random() * 255);
		int b = (int) ( Math.random() * 255);
//		System.out.print(r + " " + g + " " + b + " ");
		StdDraw.setPenColor(r, g, b);
		
		// draw the center one
		double xc = minX+1*x_step;
		double yc = minY+1*y_step;
		double hw = x_step;
		double hh = y_step;
		double radius = (hw+hh)/3;
//		System.out.println(xc + " " + yc + " " + hw + " " + hh);
		StdDraw.filledCircle(xc,yc,radius);
		
		
//		for (int i = -1; i < 2; i++) {
//			for (int j = -1; j < 2; j++) {
//				if(i==0 || j==0) {
//					
//				}else {
//					recursiveBonus(xc+i*radius, xc+(i+1)*radius, 
//							yc+j*radius, yc+(j+1)*radius);
//				}
//			}
//		}
//		StdDraw.filledCircle(xc-radius/2,yc-radius/2,radius/2);
		recursiveBonus(minX, minX+x_step, minY, minY+y_step);
		recursiveBonus(minX+x_step, minX+2*x_step, minY, minY+y_step);
		recursiveBonus(minX, minX+x_step, minY+y_step, minY+2*y_step);
		recursiveBonus(minX+x_step, minX+2*x_step, minY+y_step, minY+2*y_step);
		
	}// recursiveBonus

}
