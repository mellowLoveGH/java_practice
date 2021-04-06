package aa;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Schedule {

	public static void main(String[] args) {

		int start, end, number;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("enter starting and ending track number: ");
		System.out.print("starting number: ");
		start = in.nextInt();
		System.out.print("ending number: ");
		end = in.nextInt();
		System.out.print("how many requests: ");
		number = in.nextInt();

		Magnetic mag = new Magnetic(start, end, number);

		//
		Schedule sch = new Schedule(mag);
		System.out.println();
		sch.FCFS();

	}

	private Magnetic mag;
	private int begin;
	private DecimalFormat df = new DecimalFormat("0.000");

	public Schedule(Magnetic mag) {
		// TODO Auto-generated constructor stub
		this.mag = mag;
		this.mag.generateRequests();
		begin = (mag.getStart() + mag.getEnd()) / 2;
	}

	//
	public void FCFS() {
		System.out.println("\t\t\tFCFS");

		List<Request> list = mag.getRequests();
		System.out.println("disk track range: \t" + mag.getStart() + " to " + mag.getEnd());
		System.out.println("where to start: \t" + begin);

		double sum = 0;
		System.out.println("request id: \t the track number: \t the distance");
		for (Request r : list) {
			System.out.println("id: " + r.getId() + "\t\t\t" + r.getNumber() + "\t\t\t"
					+ Math.abs(begin - r.getNumber()));
			sum += Math.abs(begin - r.getNumber());
			begin = r.getNumber();
		}
		System.out.println("average: \t" + df.format(sum / list.size()));
	}

}
